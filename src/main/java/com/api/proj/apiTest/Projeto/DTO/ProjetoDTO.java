package com.api.proj.apiTest.Projeto.DTO;

import com.api.proj.apiTest.Projeto.Enum.Classificacao;
import com.api.proj.apiTest.Projeto.Entity.Projeto;
import com.api.proj.apiTest.Projeto.Enum.Status;

import java.time.LocalDate;

public record ProjetoDTO(String name, LocalDate dataInicio, String gerente, LocalDate previsaoTermino,
                         LocalDate realTermino, double orcamentoTotal, String descricao, Status status,
                         Classificacao classificacao) {

    public ProjetoDTO(Projeto projeto) {
        this(projeto.getNome(), projeto.getDataInicio(), projeto.getGerente(), projeto.getPrevisaoTermino(),
             projeto.getRealTermino(), projeto.getOrcamentoTotal(), projeto.getDescricao(), projeto.getStatus(),
             projeto.getClassificacao());
    }
}
