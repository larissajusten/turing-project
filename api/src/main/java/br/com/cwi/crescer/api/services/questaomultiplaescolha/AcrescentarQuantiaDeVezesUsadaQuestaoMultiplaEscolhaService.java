package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcrescentarQuantiaDeVezesUsadaQuestaoMultiplaEscolhaService {

    @Autowired
    private QuestaoMultiplaEscolhaRepository questaoMultiplaEscolhaRepository;

    public void addVezesQuestaoMultiplaEscolha(List<QuestaoMultiplaEscolha> questoes) {

        questoes.forEach(questao -> {

            questao.setVezesUsada(questao.getVezesUsada() + 1);

            questaoMultiplaEscolhaRepository.save(questao);

        });
    }
}
