package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VagaServiceTest {

    @Test
    void getVagas() {
        VagaService vagaService = new VagaService();

        assertEquals(3, vagaService.getVagas().size());
        assertTrue(vagaService.getVagas().contains(1L));
        assertTrue(vagaService.getVagas().contains(2L));
        assertTrue(vagaService.getVagas().contains(3L));
    }

    @Test
    void deletarVaga() {
        VagaService vagaService = new VagaService();

        assertTrue(vagaService.getVagas().contains(1L));

        vagaService.deletarVaga(1L);

        assertFalse(vagaService.getVagas().contains(1L));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> vagaService.deletarVaga(99L));

        assertEquals("Vaga não encontrada: 99", exception.getMessage());
    }

    @Test
    void inserirVaga() {
        VagaService vagaService = new VagaService();

        int tamanhoInicial = vagaService.getVagas().size();

        vagaService.inserirVaga(4L);

        assertEquals(tamanhoInicial + 1, vagaService.getVagas().size());
        assertTrue(vagaService.getVagas().contains(4L));
    }

    @Test
    void alterarVaga() {
        VagaService vagaService = new VagaService();

        // Vamos supor que a vaga com ID 2L precisa ser alterada para 99L
        assertTrue(vagaService.getVagas().contains(2L));
        assertFalse(vagaService.getVagas().contains(99L));

        vagaService.alterarVaga(2L, 99L);

        assertFalse(vagaService.getVagas().contains(2L));
        assertTrue(vagaService.getVagas().contains(99L));

        // Testando alterar uma vaga inexistente
        Exception exception = assertThrows(IllegalArgumentException.class, () -> vagaService.alterarVaga(100L, 200L));

        assertEquals("Vaga não encontrada: 100", exception.getMessage());
    }

}