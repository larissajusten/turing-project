package br.com.cwi.crescer.api.services.alternativaMultiplaEscolhaService;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.repository.questao.AlternativaMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionarAlternativaMultiplaEscolhaService {

    @Autowired
    private AlternativaMultiplaEscolhaRepository repository;

    public void adicionar(AlternativaMultiplaEscolha alternativa, Long idQuestao) {

        alternativa.setId(idQuestao);

        repository.save(alternativa);
    }
}
