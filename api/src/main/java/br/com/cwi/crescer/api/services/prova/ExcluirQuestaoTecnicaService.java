package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcluirQuestaoTecnicaService {

    @Autowired
    private ProvaQuestaoTecnicaRepository repository;

    public void excluir( Long idQuestaoProva) {
        repository.deleteById(idQuestaoProva);
    }
}
