package br.com.ordensservico.aberturaordensservico.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ordensservico.aberturaordensservico.Service.OrdemServicoService;
import br.com.ordensservico.aberturaordensservico.dto.OrdemServicoRequest;
import br.com.ordensservico.aberturaordensservico.model.OrdemServico;
import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/ordens-servico")
public class OrdemservicoController {
    private final OrdemServicoService ordemServicoService;

    public OrdemservicoController(OrdemServicoService ordemServicoService){
        this.ordemServicoService = ordemServicoService;
    }

    @PostMapping 
    public ResponseEntity<Optional<OrdemServico>> cadastrar(@Valid @RequestBody OrdemServicoRequest ordemServico){
        Optional<OrdemServico> ordemServicoCadastrado = ordemServicoService.cadastrar(ordemServico);

        if (ordemServicoCadastrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(ordemServicoCadastrado);
    }
    
    @GetMapping
    public ResponseEntity<List<OrdemServico>> listar(){
        List<OrdemServico> ordensServico = ordemServicoService.listar();
        return ResponseEntity.ok(ordensServico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<OrdemServico>> buscarPorId(@PathVariable Integer id){
        Optional<OrdemServico> ordemServico = ordemServicoService.buscarPorId(id);


        if (ordemServico.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(ordemServico);
    }
}
