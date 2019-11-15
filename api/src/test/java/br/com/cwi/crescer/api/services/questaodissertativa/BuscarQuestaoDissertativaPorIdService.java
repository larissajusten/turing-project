package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarQuestaoDissertativaPorIdService {

    @Autowired
    QuestaoDissertativaRepository repository;

    public QuestaoDissertativa buscarQuestao(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new QuestaoNaoEncontradaException("Questão dissertativa não encontrada."));
    }

}
