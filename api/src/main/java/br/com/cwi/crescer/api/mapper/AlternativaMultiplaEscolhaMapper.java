package br.com.cwi.crescer.api.mapper;

import br.com.cwi.crescer.api.controller.requests.questoes.AlternativaQuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import org.springframework.stereotype.Component;

@Component
public class AlternativaMultiplaEscolhaMapper {

    public AlternativaMultiplaEscolha transformar(AlternativaQuestaoMultiplaEscolhaRequest alternativaRequest, QuestaoMultiplaEscolha questao) {

        AlternativaMultiplaEscolha alternativaMultiplaEscolha = new AlternativaMultiplaEscolha();

        alternativaMultiplaEscolha.setResposta(alternativaRequest.getResposta());
        alternativaMultiplaEscolha.setRespostaCorreta(alternativaRequest.isRespostaCorreta());
        alternativaMultiplaEscolha.setQuestaoMultiplaEscolha(questao);

        return alternativaMultiplaEscolha;
    }

}
