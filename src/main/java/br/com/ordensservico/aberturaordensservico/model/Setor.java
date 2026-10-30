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

<<<<<<< HEAD
    public String getNome(){
        return nome;
    }
=======
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
>>>>>>> 4807cc56cf0dfc8f570211f62f64d6c0a477e1f6
    
    public void setNome(String nome){
        this.nome = nome; 
    }
     
}
