package br.com.cwi.crescer.api.controller.questoes;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.BuscarAlternativaQuestaoMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.AdicionarQuestaoMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.BuscarQuestoesMultiplaEscolhaFiltradasService;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.ListarQuestoesMultiplaEscolhaFiltradasService;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.BuscarQuestoesMultiplaEscolhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private BuscarQuestoesMultiplaEscolhaFiltradasService buscarQuestoesMultiplaEscolhaFiltradasService;

    @Autowired
    private ListarQuestoesMultiplaEscolhaFiltradasService listarQuestoesMultiplaEscolhaFiltradasService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public QuestaoMultiplaEscolha adicionarQuestaoMultiplaEscolha(@RequestBody QuestaoMultiplaEscolhaRequest questaoMultiplaEscolhaRequest) {
        return adicionarQuestaoMultiplaEscolha.adicionar(questaoMultiplaEscolhaRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/buscar-todas")
    public Page<QuestaoMultiplaEscolhaResponse> buscarQuestoesMultiplaEscolha(@PageableDefault Pageable pageable) {
        return buscarQuestoesMultiplaEscolha.buscarTodasQuestoes(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/buscar-questoes-filtrado")
    public List<QuestaoMultiplaEscolha> buscarQuestoesMultiplasFiltradas(@RequestBody BuscaQuestoesRequest request) {
        return listarQuestoesMultiplaEscolhaFiltradasService.listar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/todas-questoes-filtradas")
    public List<QuestaoMultiplaEscolha> buscarTodasQuestoesMultiplasFiltradas(@RequestBody BuscaQuestoesRequest request) {
        return buscarQuestoesMultiplaEscolhaFiltradasService.buscar(request.getEspecificidade(), request.getNivelDeDificuldade());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-questao}/buscar-alternativas")
    public List<AlternativaMultiplaEscolha> buscarQuestoesMultiplasFiltradas(@PathVariable ("id-questao") Long idQuestao) {
        return buscarAlternativaQuestaoMultiplaEscolhaService.buscar(idQuestao);
    }

}
