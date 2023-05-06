package com.api.proj.apiTest.Projeto.Controller;

import com.api.proj.apiTest.Projeto.DTO.ProjetoDTO;
import com.api.proj.apiTest.Projeto.Entity.Projeto;
import com.api.proj.apiTest.Projeto.Repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projeto")
public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;

    @GetMapping("buscar")
    public ResponseEntity<List<Projeto>> getAllProjeto(){
        return ResponseEntity.ok(projetoRepository.findAll());
    }

    @PostMapping("cadastrar")
    public ResponseEntity cadastrarProjeto(@RequestBody ProjetoDTO projetoDTO){

        Projeto projeto = new Projeto(projetoDTO);
        Projeto projetoCadastrado = projetoRepository.save(projeto);

        return ResponseEntity.ok(projetoCadastrado);
    }
}
