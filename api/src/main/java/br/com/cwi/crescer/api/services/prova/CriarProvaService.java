package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRequest;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.mapper.ProvaMapper;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import br.com.cwi.crescer.api.validator.ProvaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarProvaService {

    @Autowired
    private ProvaMapper mapper;

    @Autowired
    private ProvaRepository repository;

    @Autowired
    private ProvaValidator provaValidator;

    public Long criar(ProvaRequest request) {

        provaValidator.verificarSeEmailDoCandidatoTemProvaEmAbertoNoSistema(request.getEmail());

        Prova prova = mapper.transformar(request);
        Prova provaSalva = repository.save(prova);

        return provaSalva.getId();
    }
}
