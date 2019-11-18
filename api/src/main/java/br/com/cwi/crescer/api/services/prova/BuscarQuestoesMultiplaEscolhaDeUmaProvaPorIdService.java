package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.AlternativaMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.mapper.AlternativaMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.mapper.QuestaoMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.BuscarAlternativaQuestaoMultiplaEscolhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService {

    @Autowired
    private ProvaQuestaoMultiplaEscolhaRepository repository;

    @Autowired
    private BuscarAlternativaQuestaoMultiplaEscolhaService buscarAlternativaQuestaoMultiplaEscolhaService;

    @Autowired
    private QuestaoMultiplaEscolhaMapper mapperQuestaoMultiplaEscolha;

    @Autowired
    private AlternativaMultiplaEscolhaMapper mapperAlternativaMultiplaEscolha;

    public List<QuestaoMultiplaEscolhaResponse> buscar(Long idProva) {

        List<QuestaoMultiplaEscolhaResponse> questoes = new ArrayList<>();

        repository.findAllByProvaIdEquals(idProva)
                .forEach(item -> {
                    List<AlternativaMultiplaEscolhaResponse> alternativas = new ArrayList<>();
                    buscarAlternativaQuestaoMultiplaEscolhaService.buscar(item.getQuestao().getId())
                            .forEach(alternativaMultiplaEscolha ->
                                    alternativas.add(mapperAlternativaMultiplaEscolha.transformarEmResponse(alternativaMultiplaEscolha))
                            );
                    questoes.add(mapperQuestaoMultiplaEscolha.transformarParaResponse(item.getQuestao(), alternativas));
                });
        return questoes;
    }
}
