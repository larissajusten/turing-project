package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadePaginadoService {

    @Autowired
    private QuestaoMultiplaEscolhaRepository respository;


    public Page<QuestaoMultiplaEscolha> buscarQuestoes(Pageable pageable, Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade) {

        return respository.acharPorNivelEEspecificidade(pageable, especificidade, nivelDeDificuldade);
    }
}
