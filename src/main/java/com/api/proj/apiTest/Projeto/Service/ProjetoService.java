package com.api.proj.apiTest.Projeto.Service;

import com.api.proj.apiTest.Projeto.Entity.Projeto;
import com.api.proj.apiTest.Projeto.Repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> getAllProjeto() {
        return (List<Projeto>) this.projetoRepository.findAll();
    }

    public void cadastrarProjeto(Projeto projeto){
        this.projetoRepository.save(projeto);
    }
}
