package com.api.proj.apiTest.Projeto.DTO;


import com.api.proj.apiTest.Membro.Entity.Membro;
import com.api.proj.apiTest.Projeto.Enum.Classificacao;
import com.api.proj.apiTest.Projeto.Entity.Projeto;
import com.api.proj.apiTest.Projeto.Enum.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public record ProjetoDTO(Optional<Long> id,
                         String nome,
                         LocalDate dataInicio,
                         String gerente,
                         LocalDate previsaoTermino,
                         LocalDate realTermino,
                         double orcamentoTotal,
                         String descricao,
                         Status status,
                         Classificacao classificacao,
                         List<Membro> membros) {

    public ProjetoDTO(Projeto projeto) {
        this(
                Optional.of(projeto.getId()),
                projeto.getNome(),
                projeto.getDataInicio(),
                projeto.getGerente(),
                projeto.getPrevisaoTermino(),
                projeto.getRealTermino(),
                projeto.getOrcamentoTotal(),
                projeto.getDescricao(),
                projeto.getStatus(),
                projeto.getClassificacao(),
                projeto.getMembro());
    }
}
