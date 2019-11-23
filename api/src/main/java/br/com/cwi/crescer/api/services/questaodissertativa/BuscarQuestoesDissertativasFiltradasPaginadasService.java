package br.com.cwi.crescer.api.services.questaodissertativa;


import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import br.com.cwi.crescer.api.validator.PageDeQuestoesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarQuestoesDissertativasFiltradasPaginadasService {

    @Autowired
    private QuestaoDissertativaRepository repository;

    @Autowired
    private PageDeQuestoesValidator validator;


    public Page<QuestaoDissertativa> buscar(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade, Pageable pageable) {

        Page<QuestaoDissertativa> page = repository.acharPorNivelEEspecificidadePaginado(pageable, especificidade, nivelDeDificuldade);
        validator.validar(page.getNumberOfElements());

        return page;
    }

}
