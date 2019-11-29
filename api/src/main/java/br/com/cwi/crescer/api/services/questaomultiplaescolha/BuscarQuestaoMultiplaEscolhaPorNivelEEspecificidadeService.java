package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService {

    @Autowired
    private QuestaoMultiplaEscolhaRepository repository;

    public List<QuestaoMultiplaEscolha> buscar(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade, int quantidade) {

        Pageable quantos = PageRequest.of(0, quantidade);
        return repository.findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaAsc(especificidade, nivelDeDificuldade, quantos);
    }

}
