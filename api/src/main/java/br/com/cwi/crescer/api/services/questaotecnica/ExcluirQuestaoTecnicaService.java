package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ExcluirQuestaoTecnicaService {

    @Autowired
    private ProvaQuestaoTecnicaRepository repository;

    public void excluir(Long idQuestaoProva, Long idProva) {

        repository.deleteByQuestaoIdAndProvaId(idQuestaoProva, idProva);
    }

}
