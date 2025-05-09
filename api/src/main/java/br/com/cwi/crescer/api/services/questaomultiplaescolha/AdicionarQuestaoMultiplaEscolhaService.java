package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.mapper.QuestaoMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.AdicionarAlternativaMultiplaEscolhaService;
import br.com.cwi.crescer.api.validator.UnicaAlternativaCorretaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AdicionarQuestaoMultiplaEscolhaService {

    @Autowired
    private QuestaoMultiplaEscolhaMapper mapper;

    @Autowired
    private QuestaoMultiplaEscolhaRepository repository;

    @Autowired
    private AdicionarAlternativaMultiplaEscolhaService adicionarAlternativaMultiplaEscolha;

    @Autowired
    private UnicaAlternativaCorretaValidator unicaAlternativaCorretaValidator;

    public QuestaoMultiplaEscolha adicionar(QuestaoMultiplaEscolhaRequest questaoMultiplaEscolhaRequest) {

        unicaAlternativaCorretaValidator.validar(questaoMultiplaEscolhaRequest);

        QuestaoMultiplaEscolha questaoMultiplaEscolha = mapper.transformarParaQuestao(questaoMultiplaEscolhaRequest);
        questaoMultiplaEscolha.setDataCriacao(LocalDate.now());

        QuestaoMultiplaEscolha questaoSalva = repository.save(questaoMultiplaEscolha);

        adicionarAlternativaMultiplaEscolha
                .adicionar(questaoMultiplaEscolhaRequest.getAlternativaA(), questaoSalva);
        adicionarAlternativaMultiplaEscolha
                .adicionar(questaoMultiplaEscolhaRequest.getAlternativaB(), questaoSalva);
        adicionarAlternativaMultiplaEscolha
                .adicionar(questaoMultiplaEscolhaRequest.getAlternativaC(), questaoSalva);
        adicionarAlternativaMultiplaEscolha
                .adicionar(questaoMultiplaEscolhaRequest.getAlternativaD(), questaoSalva);
        adicionarAlternativaMultiplaEscolha
                .adicionar(questaoMultiplaEscolhaRequest.getAlternativaE(), questaoSalva);

        return questaoSalva;
    }
}
