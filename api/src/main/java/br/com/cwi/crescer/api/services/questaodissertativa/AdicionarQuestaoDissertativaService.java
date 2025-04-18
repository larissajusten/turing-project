package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.mapper.QuestaoDissertativaMapper;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AdicionarQuestaoDissertativaService {

    @Autowired
    private QuestaoDissertativaMapper mapper;

    @Autowired
    private QuestaoDissertativaRepository repository;

    public QuestaoDissertativa adicionar(QuestaoUnicaAlternativaRequest request) {

        QuestaoDissertativa questaoDissertativa = mapper.transformar(request);
        questaoDissertativa.setDataCriacao(LocalDate.now());

        repository.save(questaoDissertativa);

        return questaoDissertativa;
    }
}
