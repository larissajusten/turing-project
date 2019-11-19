package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.validator.QuestaoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService {

    @Autowired
    private QuestaoMultiplaEscolhaRepository multiplaEscolhaRepository;

    public List<QuestaoMultiplaEscolha> buscarQuestoes(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade){

        return multiplaEscolhaRepository.acharPorNivelEEspecificidade(especificidade, nivelDeDificuldade);
    }

}
