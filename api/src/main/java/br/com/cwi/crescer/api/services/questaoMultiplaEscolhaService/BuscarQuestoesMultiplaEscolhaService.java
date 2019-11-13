package br.com.cwi.crescer.api.services.questaoMultiplaEscolhaService;

import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.mapper.QuestaoMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.alternativaMultiplaEscolhaService.BuscarAlternativaQuestaoMultiplaEscolhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarQuestoesMultiplaEscolhaService {

    @Autowired
    private QuestaoMultiplaEscolhaRepository repository;

    @Autowired
    private BuscarAlternativaQuestaoMultiplaEscolhaService buscarAlternativaQuestaoMultiplaEscolha;

    @Autowired
    private QuestaoMultiplaEscolhaMapper mapper;
    public Page<QuestaoMultiplaEscolhaResponse> buscarTodasQuestoes(Pageable pageable) {

        Page<QuestaoMultiplaEscolha> questoes = repository.findAll(pageable);

        return questoes.map(questao -> {
            List<AlternativaMultiplaEscolha> alternativas = buscarAlternativaQuestaoMultiplaEscolha.buscar(questao.getId());

            return mapper.mapperToResponse(questao, alternativas);
        });
    }
}
