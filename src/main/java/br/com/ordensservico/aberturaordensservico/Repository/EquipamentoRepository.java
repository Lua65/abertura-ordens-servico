package br.com.ordensservico.aberturaordensservico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ordensservico.aberturaordensservico.model.Equipamento;

public interface EquipamentoRepository 
    extends JpaRepository<Equipamento, Integer> {

    }
    

