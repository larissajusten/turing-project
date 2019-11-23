package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarProvasRanqueadasService {

    @Autowired
    private ProvaRepository repository;


    public Page<Prova> buscar(Pageable pageable) {

        return repository.findAllByOrderByNotaDesc(pageable);
    }
}
