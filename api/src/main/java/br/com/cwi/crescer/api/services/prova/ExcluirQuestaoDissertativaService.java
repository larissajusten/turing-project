package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ExcluirQuestaoDissertativaService {

    @Autowired
    private ProvaQuestaoDissertativaRepository repository;

    public void excluir(Long idQuestaoProva, Long idProva) {
        repository.deleteByQuestaoIdAndProvaId(idQuestaoProva, idProva);
    }
}
