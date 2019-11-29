package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.validator.PageDeQuestoesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarQuestoesMultiplaEscolhasFiltradasPaginadoService {

    @Autowired
    private QuestaoMultiplaEscolhaRepository respository;

    @Autowired
    private PageDeQuestoesValidator validator;

    public Page<QuestaoMultiplaEscolha> buscar(Pageable pageable, Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade) {

        Page<QuestaoMultiplaEscolha> page = respository.acharPorNivelEEspecificidade(pageable, especificidade, nivelDeDificuldade);
        validator.validar(page.getNumberOfElements());

        return page;
    }
}
