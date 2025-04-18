package br.com.cwi.crescer.api.services.alternativamultiplaescolha;

import br.com.cwi.crescer.api.controller.requests.questoes.AlternativaMultiplaEscolhaRequest;
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

    public void adicionar(AlternativaMultiplaEscolhaRequest request, QuestaoMultiplaEscolha questao) {

        AlternativaMultiplaEscolha alternativa = mapper.transformar(request, questao);

        repository.save(alternativa);
    }
}
