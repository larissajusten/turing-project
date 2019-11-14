package br.com.cwi.crescer.api.services.questaoMultiplaEscolhaService;

import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarQuestaoMultiplaEscolhaPorIdService {

    @Autowired
    private QuestaoMultiplaEscolhaRepository repository;

    public QuestaoMultiplaEscolha buscarQuestao(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new QuestaoNaoEncontradaException("Questão de multipla escolha, não encontrada."));
    }
}
