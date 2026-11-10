package br.com.ordensservico.aberturaordensservico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ordensservico.aberturaordensservico.model.OrdemServico;

public interface OrdemServicoRepository 
    extends JpaRepository<OrdemServico, Integer> {
}
