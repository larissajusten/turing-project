package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService {

    private static final int TAMANHO_PARA_LANCAR_EXCEPTION_LISTA = 0;

    @Autowired
    private QuestaoMultiplaEscolhaRepository multiplaEscolhaRepository;

    public List<QuestaoMultiplaEscolha> buscarQuestoes(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade) {

        if (multiplaEscolhaRepository.acharPorNivelEEspecificidade(especificidade, nivelDeDificuldade).size() == TAMANHO_PARA_LANCAR_EXCEPTION_LISTA) {
            throw new QuestaoNaoEncontradaException("Nenhuma questão com essa especificidade e nivel de dificuldade foi encontrada.");
        }
        return multiplaEscolhaRepository.acharPorNivelEEspecificidade(especificidade, nivelDeDificuldade);
    }

}
