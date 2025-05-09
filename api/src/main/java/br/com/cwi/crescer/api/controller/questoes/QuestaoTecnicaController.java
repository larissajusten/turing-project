package br.com.cwi.crescer.api.controller.questoes;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoTecnicaRequest;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaCompletaResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.services.questaotecnica.AdicionarQuestaoTecnicaService;
import br.com.cwi.crescer.api.services.questaotecnica.BuscarQuestoesTecnicasFiltradasPaginadoService;
import br.com.cwi.crescer.api.services.questaotecnica.BuscarQuestoesTecnicasFiltradasService;
import br.com.cwi.crescer.api.services.questaotecnica.ListarQuestoesTecnicasFiltradasService;
import br.com.cwi.crescer.api.services.respostaprova.BuscarQuestaoTecnicaCompletaParaDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tecnica")
public class QuestaoTecnicaController {

    @Autowired
    private ListarQuestoesTecnicasFiltradasService buscarQuestoesTecnicas;

    @Autowired
    private AdicionarQuestaoTecnicaService adicionarQuestaoTecnica;

    @Autowired
    private BuscarQuestoesTecnicasFiltradasService buscarQuestoesTecnicasFiltradasService;

    @Autowired
    private BuscarQuestoesTecnicasFiltradasPaginadoService buscarPaginado;

    @Autowired
    private BuscarQuestaoTecnicaCompletaParaDownloadService buscarQuestaoTecnicaCompletaParaDownloadService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<QuestaoTecnica> buscarQuestoesTecnicas(@Valid @RequestBody BuscaQuestoesRequest request) {
        return buscarQuestoesTecnicas.listar(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adicionarQuestaoTecnica(@Valid @RequestBody QuestaoTecnicaRequest request) {

        adicionarQuestaoTecnica.adicionar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filtrar")
    public Page<QuestaoTecnica> buscarTodasQuestoesTecnicasFiltradas(@PageableDefault(size = 5) Pageable pageable,
                                                                     @RequestParam("especificidade") Especificidade especificidade,
                                                                     @RequestParam("nivel") NivelDeDificuldade nivelDeDificuldade) {
        return buscarPaginado.buscar(pageable, especificidade, nivelDeDificuldade);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/download/{id-resposta}")
    public QuestaoTecnicaCompletaResponse buscarQuestaoTecnicaParaBaixar(@PathVariable("id-resposta") Long idResposta) {
        return buscarQuestaoTecnicaCompletaParaDownloadService.buscar(idResposta);
    }
}
