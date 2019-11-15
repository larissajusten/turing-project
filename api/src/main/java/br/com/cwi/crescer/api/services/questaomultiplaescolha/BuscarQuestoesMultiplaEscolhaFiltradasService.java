package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarQuestoesMultiplaEscolhaFiltradasService {
    @Autowired
    QuestaoMultiplaEscolhaRepository repository;

    public List<QuestaoMultiplaEscolha> buscar(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade){
        return repository.acharPorNivelEEspecificidade(especificidade, nivelDeDificuldade);
    }
}
