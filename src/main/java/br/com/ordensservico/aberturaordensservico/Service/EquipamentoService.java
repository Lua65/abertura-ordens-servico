package br.com.ordensservico.aberturaordensservico.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ordensservico.aberturaordensservico.Repository.EquipamentoRepository;
import br.com.ordensservico.aberturaordensservico.Repository.SetorRepository;
import br.com.ordensservico.aberturaordensservico.dto.EquipamentoRequest;
import br.com.ordensservico.aberturaordensservico.model.Equipamento;
import br.com.ordensservico.aberturaordensservico.model.Setor;


@Service 
public class EquipamentoService {
    private final EquipamentoRepository equipamentoRepository;

    private final SetorRepository setorRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository, SetorRepository setorRepository){
        this.equipamentoRepository = equipamentoRepository;
        this.setorRepository = setorRepository;
    }

    public Optional<Equipamento> cadastrar(EquipamentoRequest dadosEquipamento){
        Optional<Setor> setorEncontrado = setorRepository.findById(dadosEquipamento.getSetorId());

        if (setorEncontrado.isEmpty()) {
            return Optional.empty();
        }

        Equipamento equipamento = new Equipamento();
        equipamento.setNome(dadosEquipamento.getNome());
        equipamento.setNumeroPatrimonio(dadosEquipamento.getNumeroPatrimonio());
        equipamento.setSetor(setorEncontrado.get());
        return Optional.of(equipamentoRepository.save(equipamento));
    }

    public List<Equipamento> listar(){
        return equipamentoRepository.findAll();
    }


    public Optional<Equipamento> buscarPorId(Integer id){
        return equipamentoRepository.findById(id);
    }

    public Optional<Equipamento> atualizar(Integer id, EquipamentoRequest novosDados){
        Optional<Equipamento> equipamentoEncontrado = equipamentoRepository.findById(id);

        if (!equipamentoEncontrado.isPresent()) {
            return Optional.empty();
        }

        Optional<Setor> setorEncontrado = setorRepository.findById(novosDados.getSetorId());

        if (setorEncontrado.isEmpty()) {
            return Optional.empty();
        }

        Equipamento equipamento = equipamentoEncontrado.get();

        equipamento.setNome(novosDados.getNome());
        equipamento.setNumeroPatrimonio(novosDados.getNumeroPatrimonio());
        equipamento.setSetor(setorEncontrado.get());

        return Optional.of(equipamentoRepository.save(equipamento));
    }

    public boolean excluir(Integer id){
        equipamentoRepository.deleteById(id);
        return true;
    }








    
}
