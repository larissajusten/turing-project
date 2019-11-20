package br.com.cwi.crescer.api.controller.questoes;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesBaseRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
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
import java.util.List;


@RestController
@RequestMapping("/questao-multipla-escolha")
public class QuestaoMultiplaEscolhaController {

    @Autowired
    private AdicionarQuestaoMultiplaEscolhaService adicionarQuestaoMultiplaEscolha;

    @Autowired
    private BuscarQuestoesMultiplaEscolhaService buscarQuestoesMultiplaEscolha;

    @Autowired
    private BuscarAlternativaQuestaoMultiplaEscolhaService buscarAlternativaQuestaoMultiplaEscolhaService;

//    @Autowired
//    private BuscarQuestoesMultiplaEscolhaFiltradasService buscarQuestoesMultiplaEscolhaFiltradasService;

    @Autowired
    private ListarQuestoesMultiplaEscolhaFiltradasService listarQuestoesMultiplaEscolhaFiltradasService;

    @Autowired
    private BuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService;

    @Autowired
    private BuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadePaginadoService buscarPaginado;
    //@RolesAllowed("Administrator")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public QuestaoMultiplaEscolha adicionarQuestaoMultiplaEscolha(@Valid @RequestBody QuestaoMultiplaEscolhaRequest questaoMultiplaEscolhaRequest) {
        return adicionarQuestaoMultiplaEscolha.adicionar(questaoMultiplaEscolhaRequest);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/buscar-todas")
    public Page<QuestaoMultiplaEscolhaResponse> buscarQuestoesMultiplaEscolha(@PageableDefault Pageable pageable) {
        return buscarQuestoesMultiplaEscolha.buscarTodasQuestoes(pageable);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/buscar-questoes-filtrado")
    public Page<QuestaoMultiplaEscolha> buscarQuestoesMultiplasFiltradas(@PageableDefault Pageable pageable, @Valid @RequestBody BuscaQuestoesRequest request) {
        return listarQuestoesMultiplaEscolhaFiltradasService.listarPaginado(request, pageable);
    }


    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/todas-questoes-filtradas")
    public Page<QuestaoMultiplaEscolha> buscarTodasQuestoesMultiplasFiltradas(@PageableDefault Pageable pageable, @Valid @RequestBody BuscaQuestoesBaseRequest request) {
        return buscarPaginado.buscarQuestoes(pageable, request.getEspecificidade(), request.getNivelDeDificuldade());
    }

//    //@RolesAllowed("Administrator", "Entrevistador")
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/{id-questao}/buscar-alternativas")
//    public List<AlternativaMultiplaEscolha> buscarQuestoesMultiplasFiltradas(@PathVariable("id-questao") Long idQuestao) {
//        return buscarAlternativaQuestaoMultiplaEscolhaService.buscar(idQuestao);
//    }

}
