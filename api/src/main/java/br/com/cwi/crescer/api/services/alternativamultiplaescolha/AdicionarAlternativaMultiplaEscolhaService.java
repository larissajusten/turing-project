package br.com.cwi.crescer.api.services.alternativamultiplaescolha;

import br.com.cwi.crescer.api.controller.requests.questoes.AlternativaQuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.mapper.AlternativaMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.repository.questao.AlternativaMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionarAlternativaMultiplaEscolhaService {

    @Autowired
    private AlternativaMultiplaEscolhaRepository repository;

    @Autowired
    private AlternativaMultiplaEscolhaMapper mapper;

    public void adicionar(AlternativaQuestaoMultiplaEscolhaRequest alternativarRequest, QuestaoMultiplaEscolha questao) {

        AlternativaMultiplaEscolha alternativa = mapper.transformar(alternativarRequest, questao);

        repository.save(alternativa);
    }
}
