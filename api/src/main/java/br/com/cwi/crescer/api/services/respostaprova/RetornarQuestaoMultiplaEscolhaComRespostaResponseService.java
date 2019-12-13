package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.mapper.QuestaoComRespostaMapper;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetornarQuestaoMultiplaEscolhaComRespostaResponseService {

    @Autowired
    private RespostaMultiplaEscolhaRepository respostaMultiplaEscolhaRepository;

    @Autowired
    private QuestaoComRespostaMapper mapper;

    public List<QuestaoMultiplaEscolhaComRespostaResponse> buscar(Prova prova) {

        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        respostaMultiplaEscolhaRepository.findAllByProvaIdEquals(prova.getId())
                .stream()
                .map(questao -> questaoMultiplaEscolha.add(mapper.questaoMultiplaEscolha(questao)))
                .collect(Collectors.toList());
        
        return questaoMultiplaEscolha;
    }
}
