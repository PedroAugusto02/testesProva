package org.example;

import java.util.ArrayList;
import java.util.List;

public class VagaService {

    private final List<Long> vagas = new ArrayList<>();

    // Inicializa com dados fictícios
    public VagaService() {
        vagas.add(1L);
        vagas.add(2L);
        vagas.add(3L);
    }

    public List<Long> getVagas() {
        return vagas;
    }

    public void deletarVaga(Long id) {
        if (!vagas.remove(id)) {
            throw new IllegalArgumentException("Vaga não encontrada: " + id);
        }
    }

    public void inserirVaga(Long id) {
        if (vagas.contains(id)) {
            throw new IllegalArgumentException("Vaga já existe: " + id);
        }
        vagas.add(id);
    }

    public void alterarVaga(Long idAtual, Long novoId) {
        int index = vagas.indexOf(idAtual);

        if (index == -1) {
            throw new IllegalArgumentException("Vaga não encontrada: " + idAtual);
        }

        if (vagas.contains(novoId)) {
            throw new IllegalArgumentException("Vaga com o novo ID já existe: " + novoId);
        }

        vagas.set(index, novoId);
    }

}
