package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcrescentarQuantiaDeVezesUsadaQuestaoDissertativaService {

    @Autowired
    private QuestaoDissertativaRepository questaoDissertativaRepository;

    public void addVezesQuestaoDissertativa(List<QuestaoDissertativa> questoes) {

        questoes.forEach(questao -> {

            questao.setVezesUsada(questao.getVezesUsada() + 1);

            questaoDissertativaRepository.save(questao);

        });
    }

}
