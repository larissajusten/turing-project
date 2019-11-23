package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcrescentarQuantasVezesUsadaQuestaoTecnicaService {

    @Autowired
    private QuestaoTecnicaRepository questaoTecnicaRepository;

    public void acrescentar(List<QuestaoTecnica> questoes) {

        questoes.forEach(questao -> {
            questao.setVezesUsada(questao.getVezesUsada() + 1);

            questaoTecnicaRepository.save(questao);

        });
    }

}
