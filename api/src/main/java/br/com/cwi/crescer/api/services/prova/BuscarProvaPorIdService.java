package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.exception.prova.ProvaNaoEncontradaException;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarProvaPorIdService {

    @Autowired
    private ProvaRepository repository;

    public Prova buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new ProvaNaoEncontradaException("Prova não foi encontrada"));
    }
}
