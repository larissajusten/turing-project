package br.com.cwi.crescer.api.mapper;

import br.com.cwi.crescer.api.controller.requests.questoes.AlternativaMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.controller.responses.AlternativaMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import org.springframework.stereotype.Component;

@Component
public class AlternativaMultiplaEscolhaMapper {

    public AlternativaMultiplaEscolha transformar(AlternativaMultiplaEscolhaRequest alternativaRequest, QuestaoMultiplaEscolha questao) {

        AlternativaMultiplaEscolha alternativaMultiplaEscolha = new AlternativaMultiplaEscolha();

        alternativaMultiplaEscolha.setResposta(alternativaRequest.getResposta());
        alternativaMultiplaEscolha.setRespostaCorreta(alternativaRequest.isRespostaCorreta());
        alternativaMultiplaEscolha.setQuestaoMultiplaEscolha(questao);

        return alternativaMultiplaEscolha;
    }

    public AlternativaMultiplaEscolhaResponse transformarEmResponse(AlternativaMultiplaEscolha alternativa) {

        AlternativaMultiplaEscolhaResponse alternativaResponse = new AlternativaMultiplaEscolhaResponse();

        alternativaResponse.setIdQuestao(alternativa.getQuestaoMultiplaEscolha().getId());
        alternativaResponse.setResposta(alternativa.getResposta());
        alternativaResponse.setRespostaCorreta(alternativa.isRespostaCorreta());

        return  alternativaResponse;


    }

}
