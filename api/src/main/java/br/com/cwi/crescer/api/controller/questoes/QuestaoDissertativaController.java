package br.com.cwi.crescer.api.controller.questoes;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.services.questaodissertativa.AdicionarQuestaoDissertativaService;
import br.com.cwi.crescer.api.services.questaodissertativa.BuscarQuestaoDissertativaPorEspecificidadeENivelPaginadasService;
import br.com.cwi.crescer.api.services.questaodissertativa.BuscarQuestaoDissertativaPorEspecificidadeENivelService;
import br.com.cwi.crescer.api.services.questaodissertativa.ListarQuestoesDissertativasFiltradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
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

    @Autowired
    private BuscarQuestaoDissertativaPorEspecificidadeENivelPaginadasService buscarPaginado;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adicionarQuestaoDissertativa(@Valid @RequestBody QuestaoUnicaAlternativaRequest request) {

        adicionarQuestaoDissertativaService.adicionar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public List<QuestaoDissertativa> listarQuestoesDissertativasFiltradas(@Valid @RequestBody BuscaQuestoesRequest request) {
        return listarQuestoesDissertativasFiltradas.listar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todas-questoes-filtradas")
    public Page<QuestaoDissertativa> listarTodasQuestoesDissertativas(@PageableDefault(size=5) Pageable pageable,
                                                                      @RequestParam("especificidade") Especificidade especificidade,
                                                                      @RequestParam("nivel") NivelDeDificuldade nivelDeDificuldade) {
        return buscarPaginado.buscar(especificidade, nivelDeDificuldade, pageable);
    }

}
