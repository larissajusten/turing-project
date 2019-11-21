package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.RetornarNotaDaQuestaoMultiplaEscolhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetornarQuestaoMultiplaEscolhaComRespostaResponseService {


    @Autowired
    private RespostaMultiplaEscolhaRepository respostaMultiplaEscolhaRepository;

    @Autowired
    private RetornarNotaDaQuestaoMultiplaEscolhaService retornarNotaDaQuestaoMultiplaEscolhaService;

    public List<QuestaoMultiplaEscolhaComRespostaResponse> buscar(Prova prova) {

        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        respostaMultiplaEscolhaRepository.findAllByProvaIdEquals(prova.getId())
                .forEach(questao -> {
                    QuestaoMultiplaEscolhaComRespostaResponse questaoMultiplaEscolhaComRespostaResponse =
                            new QuestaoMultiplaEscolhaComRespostaResponse();

                    questaoMultiplaEscolhaComRespostaResponse.setIdQuestao(questao.getQuestaoMultiplaEscolha().getId());
                    questaoMultiplaEscolhaComRespostaResponse.setQuestao(questao.getQuestaoMultiplaEscolha().getQuestao());
                    questaoMultiplaEscolhaComRespostaResponse.setNota(retornarNotaDaQuestaoMultiplaEscolhaService
                            .notaQuestaoMultiplaEscolha(questao.getQuestaoMultiplaEscolha().getNivelDeDificuldade()));
                    questaoMultiplaEscolhaComRespostaResponse.setResposta(questao.getAlternativaMultiplaEscolha());

                    questaoMultiplaEscolha.add(questaoMultiplaEscolhaComRespostaResponse);
                });

        return questaoMultiplaEscolha;

    }
}
