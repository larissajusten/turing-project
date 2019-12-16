package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.enums.TipoDeProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.exception.prova.ProvaNaoEncontradaException;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarProvaPorCriadaECrescerService {

    @Autowired
    private ProvaRepository repository;

    public List<Prova> buscar() {

        return repository.encontrarPorCriadaECrescer(TipoDeProva.CRESCER, StatusProva.CRIADA);
    }
}
