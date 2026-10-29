package br.com.ordensservico.aberturaordensservico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "setor")
public class Setor {
    @Id
    @GeneratedValue 
    private Integer id;

    private String nome;
    
    
}
