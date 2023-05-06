package com.api.proj.apiTest.Membro.DTO;

import com.api.proj.apiTest.Membro.Entity.Membro;

import java.util.Optional;

public record MembroDTO(Optional<Long> id,
                        String nome,
                        String cargo,
                        Boolean funcionario) {
    public MembroDTO(Membro membro){
        this(
                Optional.of(membro.getId()),
                membro.getNome(),
                membro.getCargo(),
                membro.getFuncionario());
    }

}
