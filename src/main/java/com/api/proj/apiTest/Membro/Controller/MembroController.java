package com.api.proj.apiTest.Membro.Controller;

import com.api.proj.apiTest.Membro.DTO.MembroDTO;
import com.api.proj.apiTest.Membro.Entity.Membro;
import com.api.proj.apiTest.Membro.Service.MembroService;
import com.api.proj.apiTest.Shared.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("membro")
public class MembroController {

    @Autowired
    private MembroService membroService;

    @GetMapping("buscar")
    public ResponseEntity getAllMembro(){

        List<MembroDTO> membroDto = membroService.getAllMembro().stream().map(MembroDTO::new).toList();

        if (!membroDto.isEmpty()){
            return ResponseEntity.ok(membroDto);
        }

        return Exceptions.returnErro("Não foi encontrado nenhum membro cadastrado.");
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity getMembro(@PathVariable("id") Long id){
        if (this.membroService.verificaSeExisteMembro(id)){
            return ResponseEntity.ok(this.membroService.buscaMembro(id));
        }

        return Exceptions.returnErro("Membro não encontrado.");
    }

    @PostMapping("cadastrar")
    public ResponseEntity cadastrarMembro(@RequestBody MembroDTO membroDTO){

        Membro membro = new Membro(membroDTO);

        if (!membro.getNome().isEmpty()){

            return ResponseEntity.ok(membroService.cadastrarOuAtualizarMembro(membro));
        }

        return Exceptions.returnErro("Não foi possível cadastrar o membro");
    }

    @PutMapping("atualizar")
    public ResponseEntity atualizarMembro(@RequestBody MembroDTO membroDTO){

        if (membroService.verificaSeExisteMembro(membroDTO.id().isPresent() ? membroDTO.id().get() : null)){
            Membro membro = new Membro(membroDTO);

            membro.setId(membroDTO.id().get());

            return ResponseEntity.ok(membroService.cadastrarOuAtualizarMembro(membro));
        }

        return Exceptions.returnErro("Não foi possível atualizar o membro");
    }

    @DeleteMapping("excluir/{id}")
    public ResponseEntity excluirMembro(@PathVariable("id") Long id){

        if (this.membroService.verificaSeExisteMembro(id)){

            Optional<Membro> membro = this.membroService.buscaMembro(id);
            membroService.excluirMembro(id);

            return ResponseEntity.ok("Membro excluído");
        }
        return Exceptions.returnErro("Não foi possível excluir o membro");
    }
}
