package br.com.cwi.crescer.api.services.QuestaoTecnicaService;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.exception.ValidacaoDeAplicacaoException;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarQuestaoTecnicaPorNivelEEspecificidadeService {

    @Autowired
    QuestaoTecnicaRepository repository;

    public List<QuestaoTecnica> buscar(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade){
        return repository.acharPorNivelEEspecificidade(especificidade, nivelDeDificuldade);
    }
}
