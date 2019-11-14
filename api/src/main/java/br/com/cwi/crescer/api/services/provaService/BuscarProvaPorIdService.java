package br.com.cwi.crescer.api.services.provaService;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.exception.ValidacaoDeAplicacaoException;
import br.com.cwi.crescer.api.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarProvaPorIdService {

    @Autowired
    private ProvaRepository repository;

    public Prova buscar(Long id){
        //TODO MUDAR DEPOIS
        return repository.findById(id).orElseThrow(() -> new ValidacaoDeAplicacaoException("Não foi encontrado"));
    }
}
