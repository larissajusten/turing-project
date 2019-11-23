package br.com.cwi.crescer.api.mapper;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestaoDissertativaMapper {

    @Autowired
    private ModelMapper mapper;

    public QuestaoDissertativa transformar(QuestaoUnicaAlternativaRequest request) {

        return mapper.map(request, QuestaoDissertativa.class);
    }

}