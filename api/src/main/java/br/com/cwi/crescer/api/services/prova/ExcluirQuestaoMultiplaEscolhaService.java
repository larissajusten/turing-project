package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcluirQuestaoMultiplaEscolhaService {

    @Autowired
    private ProvaQuestaoMultiplaEscolhaRepository repository;

    public void excluir( Long idQuestaoProva) {
        repository.deleteById(idQuestaoProva);
    }
}
