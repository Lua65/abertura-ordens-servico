package br.com.ordensservico.aberturaordensservico.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.ordensservico.aberturaordensservico.Repository.EquipamentoRepository;
import br.com.ordensservico.aberturaordensservico.Repository.OrdemServicoRepository;
import br.com.ordensservico.aberturaordensservico.dto.EncerramentoOrdemServicoRequest;
import br.com.ordensservico.aberturaordensservico.dto.OrdemServicoRequest;
import br.com.ordensservico.aberturaordensservico.model.Equipamento;
import br.com.ordensservico.aberturaordensservico.model.OrdemServico;

@Service 
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final EquipamentoRepository equipamentoRepository;

    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository, EquipamentoRepository equipamentoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
        this.equipamentoRepository = equipamentoRepository;
    }


    public Optional<OrdemServico> cadastrar(OrdemServicoRequest dadosOrdemServico) {
        Optional<Equipamento> equipamentoEncontrado = equipamentoRepository.findById(dadosOrdemServico.getEquipamentoId());
         
        if (equipamentoEncontrado.isEmpty()) { 
            return Optional.empty();
        }

        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setDescricao(dadosOrdemServico.getDescricao());
        ordemServico.setEquipamento(equipamentoEncontrado.get());
        ordemServico.setDataAbertura(LocalDateTime.now());
        return Optional.of(ordemServicoRepository.save(ordemServico));
    }

    public List<OrdemServico> listar() {
        return ordemServicoRepository.findAll();
    }

    public Optional<OrdemServico> buscarPorId(Integer id) {
        return ordemServicoRepository.findById(id);
    }

    public Optional<OrdemServico> encerrar(Integer id, EncerramentoOrdemServicoRequest dados){
        Optional<OrdemServico> ordemServicoOptional = ordemServicoRepository.findById(id);

        if (ordemServicoOptional.isEmpty()) {
            return Optional.empty();
        }

        boolean ordemServicoEncerrada = ordemServicoRepository
        .existsByIdAndDataEncerramentoIsNotNull(ordemServicoOptional.get().getId());
        
        if (ordemServicoEncerrada) {  
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, 
                "Ordem de serviço já encerrada.");
            }
            
        OrdemServico ordemServico = ordemServicoOptional.get();
        ordemServico.setSolucao(dados.getSolucao());
        ordemServico.setDataEncerramento(LocalDateTime.now());
        return Optional.of(ordemServicoRepository.save(ordemServico));
    }

    public List<OrdemServico> listarAbertas() {
        return ordemServicoRepository.findByDataEncerramentoIsNull();
    }
    
}
