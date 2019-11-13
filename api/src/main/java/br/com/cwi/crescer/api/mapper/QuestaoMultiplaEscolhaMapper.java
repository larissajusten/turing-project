package br.com.cwi.crescer.api.mapper;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestaoMultiplaEscolhaMapper {

    @Autowired
    private ModelMapper mapper;

    public QuestaoMultiplaEscolha mapperToQuestao(QuestaoMultiplaEscolhaRequest questaoMultiplaEscolhaRequest) {
        return mapper.map(questaoMultiplaEscolhaRequest, QuestaoMultiplaEscolha.class);
    }

    public QuestaoMultiplaEscolhaResponse mapperToResponse(QuestaoMultiplaEscolha questao, List<AlternativaMultiplaEscolha> alternativas) {

        QuestaoMultiplaEscolhaResponse questaoResponse = new QuestaoMultiplaEscolhaResponse();

        questaoResponse.setId(questao.getId());
        questaoResponse.setQuestao(questao.getQuestao());
        questaoResponse.setDataCriacao(questao.getDataCriacao());
        questaoResponse.setEspecificidade(questao.getEspecificidade());
        questaoResponse.setNivelDeDificuldade(questao.getNivelDeDificuldade());
        questaoResponse.setIdUsuario(questao.getUsuario().getId());
        questaoResponse.setAlternativaA(alternativas.get(0));
        questaoResponse.setAlternativaA(alternativas.get(1));
        questaoResponse.setAlternativaA(alternativas.get(2));
        questaoResponse.setAlternativaA(alternativas.get(3));
        questaoResponse.setAlternativaA(alternativas.get(4));


        return questaoResponse;
    }
}
