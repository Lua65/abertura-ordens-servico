package br.com.ordensservico.aberturaordensservico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "equipamento")
public class Equipamento {
    @Id 
    @GeneratedValue 
    private Integer id;

    private String nome;

    private Integer numeroPatrimonio;

    @ManyToOne 
    private String setor;

    public Equipamento(){
        

    }

    public Equipamento (String nome, Integer numeroPatrimonio, String setor){
        this.nome = nome;
        this.numeroPatrimonio = numeroPatrimonio;
        this.setor = setor;
    }


    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public Integer getNumeroPatrimonio(){
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(Integer numeroPatrimonio){
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public String getSetor(){
        return setor;
    }

    public void setSetor(String setor){
        this.setor = setor;
    }

        
}
