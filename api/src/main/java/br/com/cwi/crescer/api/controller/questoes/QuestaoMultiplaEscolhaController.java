package br.com.cwi.crescer.api.controller.questoes;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.BuscarAlternativaQuestaoMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/multipla")
public class QuestaoMultiplaEscolhaController {

    @Autowired
    private AdicionarQuestaoMultiplaEscolhaService adicionarQuestaoMultiplaEscolha;

    @Autowired
    private BuscarQuestoesMultiplaEscolhaService buscarQuestoesMultiplaEscolha;

    @Autowired
    private BuscarAlternativaQuestaoMultiplaEscolhaService buscarAlternativaQuestaoMultiplaEscolhaService;

    @Autowired
    private ListarQuestoesMultiplaEscolhaFiltradasService listarQuestoesMultiplaEscolhaFiltradasService;

    @Autowired
    private BuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService;

    @Autowired
    private BuscarQuestoesMultiplaEscolhasFiltradasPaginadoService buscarPaginado;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public QuestaoMultiplaEscolha adicionarQuestaoMultiplaEscolha(@Valid @RequestBody QuestaoMultiplaEscolhaRequest questaoMultiplaEscolhaRequest) {
        return adicionarQuestaoMultiplaEscolha.adicionar(questaoMultiplaEscolhaRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/buscar")
    public Page<QuestaoMultiplaEscolhaResponse> buscarQuestoesMultiplaEscolha(@PageableDefault Pageable pageable) {
        return buscarQuestoesMultiplaEscolha.buscarTodasQuestoes(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<QuestaoMultiplaEscolha> buscarQuestoesMultiplasFiltradas(@PageableDefault Pageable pageable, @Valid @RequestBody BuscaQuestoesRequest request) {
        return listarQuestoesMultiplaEscolhaFiltradasService.listarPaginado(request, pageable);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filtrar")
    public Page<QuestaoMultiplaEscolha> buscarTodasQuestoesMultiplasFiltradas(@PageableDefault(size = 5) Pageable pageable,
                                                                              @RequestParam("especificidade") Especificidade especificidade,
                                                                              @RequestParam("nivel") NivelDeDificuldade nivelDeDificuldade) {
        return buscarPaginado.buscar(pageable, especificidade, nivelDeDificuldade);
    }
}
