package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcrescentarQuantasVezesUsadaQuestaoMultiplaEscolhaService {

    @Autowired
    private QuestaoMultiplaEscolhaRepository repository;

    public void acrescentar(List<QuestaoMultiplaEscolha> questoes) {

        questoes.forEach(questao -> {
            questao.setVezesUsada(questao.getVezesUsada() + 1);

            repository.save(questao);
        });
    }
}
