package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import br.com.cwi.crescer.api.validator.QuestaoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarQuestoesTecnicasFiltradasService {

    @Autowired
    private QuestaoTecnicaRepository repository;

    @Autowired
    private QuestaoValidator validator;

    public List<QuestaoTecnica> buscar(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade) {



        return repository.acharPorNivelEEspecificidade(especificidade, nivelDeDificuldade);
    }
}
