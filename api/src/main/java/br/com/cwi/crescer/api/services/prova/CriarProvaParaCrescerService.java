package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaCrescerRequest;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.mapper.ProvaMapper;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import br.com.cwi.crescer.api.validator.ProvaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarProvaParaCrescerService {

    @Autowired
    private ProvaMapper mapper;

    @Autowired
    private ProvaRepository repository;

    @Autowired
    private ProvaValidator provaValidator;

    public void criar(ProvaCrescerRequest request) {

        for (int i = 0; i < request.getQuantidade(); i++) {
            Prova prova = mapper.transformarParaCrescer(request);
            repository.save(prova);
        }
    }
}
