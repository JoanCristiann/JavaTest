package com.api.proj.apiTest.Projeto.Service;

import com.api.proj.apiTest.Membro.Entity.Membro;
import com.api.proj.apiTest.Membro.Repository.MembroRepository;
import com.api.proj.apiTest.Membro.Service.MembroService;
import com.api.proj.apiTest.Projeto.DTO.ProjetoDTO;
import com.api.proj.apiTest.Projeto.Entity.Projeto;
import com.api.proj.apiTest.Projeto.Enum.Status;
import com.api.proj.apiTest.Projeto.Enum.Classificacao;
import com.api.proj.apiTest.Projeto.Repository.ProjetoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@SpringBootTest
class ProjetoServiceTest {

    @InjectMocks
    private ProjetoService projetoService;
    @InjectMocks
    private MembroService membroService;

    @Mock
    private ProjetoRepository projetoRepository;
    @Mock
    private MembroRepository membroRepository;
    private Optional<Projeto> projetoOptional;
    private Projeto projeto;
    private ProjetoDTO projetoDTO;
    private Projeto projeto1;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        mockProjeto();
    }

    @Test
    void buscaProjeto() {
        when(projetoRepository.findById(anyLong())).thenReturn(projetoOptional);

        Optional<Projeto> response = projetoService.buscaProjeto(1L);

        assertEquals(projetoOptional,response);
    }

    @Test
    void getAllProjeto() {
        when(projetoRepository.findAll()).thenReturn(List.of(projeto));

        List<Projeto> response = projetoService.getAllProjeto();

        assertEquals(1,response.size());
    }

    @Test
    void cadastrarOuAtualizarProjeto() {

        when(projetoRepository.save(any())).thenReturn(projeto);

        Projeto response = projetoService.cadastrarOuAtualizarProjeto(projeto);

        assertEquals(projeto,response);
    }

    @Test
    void excluirProjeto() {

        doNothing().when(projetoRepository).deleteById(anyLong());

        projetoService.excluirProjeto(2L);

        verify(projetoRepository,times(1)).deleteById(anyLong());
    }

    @Test
    void verificaSeExisteProjeto() {

        when(projetoRepository.existsById(any())).thenReturn(true);

        boolean response = projetoService.verificaSeExisteProjeto(2L);

        assertTrue(response);
    }

    @Test
    void validaAntesDaExclusao() {
        assertTrue(projetoService.validaAntesDaExclusao(projetoOptional));
    }

    public void mockProjeto()
    {
        List<Membro> membros = new ArrayList<>();
        membros.add(new Membro(2L,"Jorge", "Programador",false));

        projetoDTO = new ProjetoDTO(
                Optional.of(1L),
                "Projeto de Sentença",
                LocalDate.parse("2016-06-01"),
                "Jorge",
                LocalDate.parse("2016-06-01"),
                LocalDate.parse("2016-06-01"),
                1000.0,
                "boa noite, severino",
                Status.ENCERRADO,
                Classificacao.ALTORISCO,
                membros

        );
        projetoOptional = Optional.of(new Projeto(
                "Projeto de Sentença",
                LocalDate.parse("2016-06-01"),
                "Jorge",
                LocalDate.parse("2016-06-01"),
                LocalDate.parse("2016-06-01"),
                1000.0,
                "boa noite, severino",
                Status.ENCERRADO,
                Classificacao.ALTORISCO,
                membros
        ));
        projeto = new Projeto(
                "Projeto de Sentença",
                LocalDate.parse("2016-06-01"),
                "Jorge",
                LocalDate.parse("2016-06-01"),
                LocalDate.parse("2016-06-01"),
                1000.0,
                "boa noite, severino",
                Status.ENCERRADO,
                Classificacao.ALTORISCO,
                membros
        );
    }
}