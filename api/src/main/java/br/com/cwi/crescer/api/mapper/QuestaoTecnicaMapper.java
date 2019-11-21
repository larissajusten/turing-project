package br.com.cwi.crescer.api.mapper;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoTecnicaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestaoTecnicaMapper {

    @Autowired
    private ModelMapper mapper;

    public QuestaoTecnica transformar(QuestaoTecnicaRequest request) {
        return mapper.map(request, QuestaoTecnica.class);
    }
}
