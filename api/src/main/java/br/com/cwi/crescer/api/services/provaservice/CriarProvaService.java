package br.com.cwi.crescer.api.services.provaservice;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRequest;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.mapper.ProvaMapper;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarProvaService {

    @Autowired
    private ProvaMapper mapper;

    @Autowired
    private ProvaRepository repository;

    public Long criar(ProvaRequest request) {
       Prova prova = mapper.transformar(request);
       repository.save(prova);

       return prova.getId();
    }
}
