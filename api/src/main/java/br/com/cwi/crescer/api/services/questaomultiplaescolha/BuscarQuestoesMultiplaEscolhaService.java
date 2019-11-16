package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.controller.responses.AlternativaMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import br.com.cwi.crescer.api.mapper.AlternativaMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.mapper.QuestaoMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.BuscarAlternativaQuestaoMultiplaEscolhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarQuestoesMultiplaEscolhaService {

    private static final int TAMANHO_PARA_LANCAR_EXCEPTION_LISTA = 0;

    @Autowired
    private QuestaoMultiplaEscolhaRepository repository;

    @Autowired
    private BuscarAlternativaQuestaoMultiplaEscolhaService buscarAlternativaQuestaoMultiplaEscolha;

    @Autowired
    private QuestaoMultiplaEscolhaMapper mapper;

    @Autowired
    private AlternativaMultiplaEscolhaMapper alternativaMapper;

    public Page<QuestaoMultiplaEscolhaResponse> buscarTodasQuestoes(Pageable pageable) {

        Page<QuestaoMultiplaEscolha> questoes = repository.findAll(pageable);

        if (questoes.getContent().size() == TAMANHO_PARA_LANCAR_EXCEPTION_LISTA) {
            throw new QuestaoNaoEncontradaException("Nenhuma questão com essa especificidade e nivel de dificuldade foi encontrada.");
        }

        return questoes.map(questao -> {
            List<AlternativaMultiplaEscolhaResponse> alternativasResponse = new ArrayList<>();

            buscarAlternativaQuestaoMultiplaEscolha.buscar(questao.getId())
                    .forEach(item -> {
                        alternativasResponse.add(alternativaMapper.transformarEmResponse(item));
                    });

            return mapper.transformarParaResponse(questao, alternativasResponse);
        });

    }
}
