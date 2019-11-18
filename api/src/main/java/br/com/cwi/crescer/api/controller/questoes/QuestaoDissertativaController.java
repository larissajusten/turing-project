package br.com.cwi.crescer.api.controller.questoes;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesBaseRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.services.questaodissertativa.AdicionarQuestaoDissertativaService;
import br.com.cwi.crescer.api.services.questaodissertativa.BuscarQuestaoDissertativaPorEspecificidadeENivelService;
import br.com.cwi.crescer.api.services.questaodissertativa.ListarQuestoesDissertativasFiltradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/questao-dissertativa")
public class QuestaoDissertativaController {

    @Autowired
    private AdicionarQuestaoDissertativaService adicionarQuestaoDissertativaService;

    @Autowired
    private ListarQuestoesDissertativasFiltradasService listarQuestoesDissertativasFiltradas;

    @Autowired
    private BuscarQuestaoDissertativaPorEspecificidadeENivelService buscarQuestaoDissertativaPorEspecificidadeENivelService;

    //@RolesAllowed("Administrator")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adicionarQuestaoDissertativa(@Valid @RequestBody QuestaoUnicaAlternativaRequest request) {
        adicionarQuestaoDissertativaService.adicionar(request);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public List<QuestaoDissertativa> listarQuestoesDissertativasFiltradas(@Valid @RequestBody BuscaQuestoesRequest request) {
        return listarQuestoesDissertativasFiltradas.listar(request);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/todas-questoes-filtradas")
    public List<QuestaoDissertativa> listarTodasQuestoesDissertativas(@Valid @RequestBody BuscaQuestoesBaseRequest request) {
        return buscarQuestaoDissertativaPorEspecificidadeENivelService.buscar(request.getEspecificidade(), request.getNivelDeDificuldade());
    }

}
