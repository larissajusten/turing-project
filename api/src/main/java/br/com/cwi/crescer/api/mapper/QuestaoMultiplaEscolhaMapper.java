package br.com.cwi.crescer.api.mapper;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.controller.responses.AlternativaMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestaoMultiplaEscolhaMapper {

    @Autowired
    private ModelMapper mapper;

    public QuestaoMultiplaEscolha transformarParaQuestao(QuestaoMultiplaEscolhaRequest questaoMultiplaEscolhaRequest) {
        return mapper.map(questaoMultiplaEscolhaRequest, QuestaoMultiplaEscolha.class);
    }

    public QuestaoMultiplaEscolhaResponse transformarParaResponse(QuestaoMultiplaEscolha questao, List<AlternativaMultiplaEscolhaResponse> alternativas) {

        QuestaoMultiplaEscolhaResponse questaoResponse = mapper.map(questao, QuestaoMultiplaEscolhaResponse.class);

        questaoResponse.setAlternativaA(alternativas.get(0));
        questaoResponse.setAlternativaB(alternativas.get(1));
        questaoResponse.setAlternativaC(alternativas.get(2));
        questaoResponse.setAlternativaD(alternativas.get(3));
        questaoResponse.setAlternativaE(alternativas.get(4));

        return questaoResponse;
    }
}
