package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcrescentarQuantasVezesUsadaQuestaoDissertativaService {

    @Autowired
    private QuestaoDissertativaRepository repository;

    public void acrescentar(List<QuestaoDissertativa> questoes) {

        questoes.forEach(questao -> {
            questao.setVezesUsada(questao.getVezesUsada() + 1);

            repository.save(questao);
        });
    }

}
