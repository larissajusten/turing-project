package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.mapper.QuestaoComRespostaMapper;
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

    @Autowired
    private QuestaoComRespostaMapper mapper;

    public List<QuestaoMultiplaEscolhaComRespostaResponse> buscar(Prova prova) {

        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        respostaMultiplaEscolhaRepository.findAllByProvaIdEquals(prova.getId())
                .forEach(questao -> questaoMultiplaEscolha.add(mapper.questaoMultiplaEscolha(questao)));

        return questaoMultiplaEscolha;
    }

}
