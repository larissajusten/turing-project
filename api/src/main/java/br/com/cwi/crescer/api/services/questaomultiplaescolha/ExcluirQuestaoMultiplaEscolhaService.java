package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ExcluirQuestaoMultiplaEscolhaService {

    @Autowired
    private ProvaQuestaoMultiplaEscolhaRepository repository;

    public void excluir(Long idQuestaoProva, Long idProva) {
        repository.deleteByQuestaoIdAndProvaId(idQuestaoProva, idProva);
    }

}
