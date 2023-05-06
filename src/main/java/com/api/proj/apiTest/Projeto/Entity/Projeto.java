package com.api.proj.apiTest.Projeto.Entity;

import com.api.proj.apiTest.Projeto.Enum.Classificacao;
import com.api.proj.apiTest.Projeto.DTO.ProjetoDTO;
import com.api.proj.apiTest.Projeto.Enum.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "gerente_responsavel")
    private String gerente;

    @Column(name = "previsao_termino")
    private LocalDate previsaoTermino;

    @Column(name = "data_real_termino;")
    private LocalDate realTermino;

    @Column(name = "orcamento_total")
    private double orcamentoTotal;

    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Enumerated(EnumType.ORDINAL)
    private Classificacao classificacao;

    public Projeto() {
    }

    public Projeto(Long id, String nome, LocalDate dataInicio, String gerente, LocalDate previsaoTermino,
                   LocalDate realTermino, double orcamentoTotal, String descricao, Status status,
                   Classificacao classificacao) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.gerente = gerente;
        this.previsaoTermino = previsaoTermino;
        this.realTermino = realTermino;
        this.orcamentoTotal = orcamentoTotal;
        this.descricao = descricao;
        this.status = status;
        this.classificacao = classificacao;
    }

    public Projeto(ProjetoDTO projetoDTO){
        this.nome = projetoDTO.name();
        this.dataInicio = projetoDTO.dataInicio();
        this.gerente = projetoDTO.gerente();
        this.previsaoTermino = projetoDTO.previsaoTermino();
        this.realTermino = projetoDTO.realTermino();
        this.orcamentoTotal = projetoDTO.orcamentoTotal();
        this.descricao = projetoDTO.descricao();
        this.status = projetoDTO.status();
        this.classificacao = projetoDTO.classificacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public LocalDate getPrevisaoTermino() {
        return previsaoTermino;
    }

    public void setPrevisaoTermino(LocalDate previsaoTermino) {
        this.previsaoTermino = previsaoTermino;
    }

    public LocalDate getRealTermino() {
        return realTermino;
    }

    public void setRealTermino(LocalDate realTermino) {
        this.realTermino = realTermino;
    }

    public double getOrcamentoTotal() {
        return orcamentoTotal;
    }

    public void setOrcamentoTotal(double orcamentoTotal) {
        this.orcamentoTotal = orcamentoTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }
}
