package br.com.ordensservico.aberturaordensservico.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ordensservico.aberturaordensservico.Service.EquipamentoService;
import br.com.ordensservico.aberturaordensservico.Service.SetorService;
import br.com.ordensservico.aberturaordensservico.model.Setor;

@RestController 
@RequestMapping ("/equipamentos")
public class EquipamentoController {
    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService){
        this.equipamentoService = equipamentoService;
    }
    
}
