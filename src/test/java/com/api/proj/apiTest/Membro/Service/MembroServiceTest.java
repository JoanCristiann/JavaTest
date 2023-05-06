package com.api.proj.apiTest.Membro.Service;

import com.api.proj.apiTest.Membro.DTO.MembroDTO;
import com.api.proj.apiTest.Membro.Entity.Membro;
import com.api.proj.apiTest.Membro.Repository.MembroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MembroServiceTest {

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
        MockitoAnnotations.openMocks(this);
        mockMembro();
    }

    @Test
    void buscaMembro() {

        when(membroRepository.findById(Mockito.anyLong())).thenReturn(membroOptional);

        Optional<Membro> response = membroService.buscaMembro(1L);

        assertEquals(membroOptional,response);
    }

    @Test
    void getAllMembro() {

        when(membroRepository.findAll()).thenReturn(List.of(membro));

        List<Membro> response = membroService.getAllMembro();

        assertEquals(1,response.size());
    }

    @Test
    void cadastrarOuAtualizarMembro() {

        when(membroRepository.save(any())).thenReturn(membro);

        Membro response= membroService.cadastrarOuAtualizarMembro(membro);

        assertEquals(membro,response);
    }

    @Test
    void excluirMembro() {

        doNothing().when(membroRepository).deleteById(anyLong());

        membroService.excluirMembro(2L);

        verify(membroRepository,times(1)).deleteById(anyLong());
    }

    @Test
    void verificaSeExisteMembro() {

        when(membroRepository.existsById(any())).thenReturn(true);

        boolean response = membroService.verificaSeExisteMembro(2L);

        assertTrue(response);
    }

    public void mockMembro()
    {
        membroDTO = new MembroDTO(Optional.of(1L),"Jorge","QA",false);
        membroOptional = Optional.of( new Membro(1L,"Jorge","QA",false));
        membro = new Membro(1L,"Jorge","QA",false);
    }
}