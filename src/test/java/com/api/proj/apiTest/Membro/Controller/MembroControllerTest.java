package com.api.proj.apiTest.Membro.Controller;

import com.api.proj.apiTest.Membro.DTO.MembroDTO;
import com.api.proj.apiTest.Membro.Entity.Membro;
import com.api.proj.apiTest.Membro.Repository.MembroRepository;
import com.api.proj.apiTest.Membro.Service.MembroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class MembroControllerTest {
    @Autowired
    private MembroController membroController;
    @InjectMocks
    private MembroService membroService;
    @Mock
    private MembroRepository membroRepository;
    private Optional<Membro> membroOptional;
    private Membro membro;
    private MembroDTO membroDTO;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this.membroController);
        mockMembro();
    }
    @Test
    void buscarMembro() throws Exception {
        when(membroRepository.findById(Mockito.anyLong())).thenReturn(membroOptional);
        when(membroService.buscaMembro(Mockito.anyLong())).thenReturn(membroOptional);
        ResponseEntity response = membroController.getMembro(2L);

        assertEquals(true,response.hasBody());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void buscarTodosMembros()
    {
        when(membroRepository.findById(Mockito.anyLong())).thenReturn(membroOptional);
        when(membroService.buscaMembro(Mockito.anyLong())).thenReturn(membroOptional);
        ResponseEntity response = membroController.getAllMembro();

        assertTrue(response.hasBody());
        assertEquals(response.getStatusCode(),HttpStatus.OK);
    }

    @Test
    void castrarMembros()
    {
        when(membroRepository.save(Mockito.any())).thenReturn(membro);
        when(membroService.cadastrarOuAtualizarMembro(membro)).thenReturn(membro);
        ResponseEntity response = membroController.cadastrarMembro(membroDTO);

        assertTrue(response.hasBody());
        assertEquals(response.getStatusCode(),HttpStatus.OK);
    }

    @Test
    void atualizarMembro() {

        when(membroRepository.save(Mockito.any())).thenReturn(membro);
        when(membroService.cadastrarOuAtualizarMembro(membro)).thenReturn(membro);
        ResponseEntity response = membroController.atualizarMembro(membroDTO);

        assertTrue(response.hasBody());
        assertEquals(response.getStatusCode(),HttpStatus.OK);
    }

    public void mockMembro()
    {
        membroDTO = new MembroDTO(Optional.of(1L),"Jorge","QA",false);
        membroOptional = Optional.of( new Membro(1L,"Jorge","QA",false));
        membro = new Membro(1L,"Jorge","QA",false);
    }
}