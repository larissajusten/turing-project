package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import br.com.cwi.crescer.api.validator.PageDeQuestoesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarQuestoesTecnicasFiltradasPaginadoService {

    @Autowired
    private QuestaoTecnicaRepository repository;

    @Autowired
    private PageDeQuestoesValidator validator;

    public Page<QuestaoTecnica> buscar(Pageable pageable, Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade) {

        Page<QuestaoTecnica> page = repository.acharPorNivelEEspecificidadePaginado(pageable, especificidade, nivelDeDificuldade);
        validator.validar(page.getNumberOfElements());

        return page;
    }

}
