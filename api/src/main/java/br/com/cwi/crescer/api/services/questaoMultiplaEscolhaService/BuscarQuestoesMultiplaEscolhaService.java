package br.com.cwi.crescer.api.services.questaoMultiplaEscolhaService;

import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
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

    private final static int TAMANHO_PARA_LANCAR_EXCEPTION_LISTA = 0;

    @Autowired
    private QuestaoMultiplaEscolhaRepository repository;

    @Autowired
    private BuscarAlternativaQuestaoMultiplaEscolhaService buscarAlternativaQuestaoMultiplaEscolha;

    @Autowired
    private QuestaoMultiplaEscolhaMapper mapper;

    public Page<QuestaoMultiplaEscolhaResponse> buscarTodasQuestoes(Pageable pageable) {

        Page<QuestaoMultiplaEscolha> questoes = repository.findAll(pageable);

        if (questoes.getContent().size() == TAMANHO_PARA_LANCAR_EXCEPTION_LISTA) {
            throw new QuestaoNaoEncontradaException("Nenhuma questão com essa especificidade e nivel de dificuldade foi encontrada.");
        }

        return questoes.map(questao -> {
            List<AlternativaMultiplaEscolha> alternativas = buscarAlternativaQuestaoMultiplaEscolha.buscar(questao.getId());
            return mapper.transformarParaResponse(questao, alternativas);
        });

    }
}
