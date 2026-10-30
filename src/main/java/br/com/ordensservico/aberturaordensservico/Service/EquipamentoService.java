package br.com.ordensservico.aberturaordensservico.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ordensservico.aberturaordensservico.Repository.EquipamentoRepository;
import br.com.ordensservico.aberturaordensservico.Repository.SetorRepository;
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

    public Equipamento cadastrar(Equipamento equipamento){
        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> listar(){
        return equipamentoRepository.findAll();
    }


    public Optional<Equipamento> buscarPorId(Integer id){
        return equipamentoRepository.findById(id);
    }

    public Optional<Equipamento> atualizar(Integer id, Equipamento novosDados){
        Optional<Equipamento> equipamentoEncontrado = equipamentoRepository.findById(id);

        Equipamento equipamento = equipamentoEncontrado.get();

        equipamento.setNome(novosDados.getNome());
        
        return Optional.of(equipamentoRepository.save(equipamento));
    }

    public boolean excluir(Integer id){
        equipamentoRepository.deleteById(id);
        return true;
    }








    
}
