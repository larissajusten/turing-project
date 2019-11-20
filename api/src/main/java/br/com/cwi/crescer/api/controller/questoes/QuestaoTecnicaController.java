package br.com.cwi.crescer.api.controller.questoes;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesBaseRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoTecnicaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.services.questaotecnica.AdicionarQuestaoTecnicaService;
import br.com.cwi.crescer.api.services.questaotecnica.BuscarQuestoesTecnicasFiltradasPaginadoService;
import br.com.cwi.crescer.api.services.questaotecnica.BuscarQuestoesTecnicasFiltradasService;
import br.com.cwi.crescer.api.services.questaotecnica.ListarQuestoesTecnicasFiltradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/questao-tecnica")
public class QuestaoTecnicaController {

    @Autowired
    private ListarQuestoesTecnicasFiltradasService buscarQuestoesTecnicas;

    @Autowired
    private AdicionarQuestaoTecnicaService adicionarQuestaoTecnica;

    @Autowired
    private BuscarQuestoesTecnicasFiltradasService buscarQuestoesTecnicasFiltradasService;

    @Autowired
    private BuscarQuestoesTecnicasFiltradasPaginadoService buscarPaginado;
    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public List<QuestaoTecnica> buscarQuestoesTecnicas(@Valid @RequestBody BuscaQuestoesRequest request) {
        return buscarQuestoesTecnicas.listar(request);
    }

    //@RolesAllowed("Administrator")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adicionarQuestaoTecnica(@Valid @RequestBody QuestaoTecnicaRequest request) {
        adicionarQuestaoTecnica.adicionar(request);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/todas-questoes-filtradas")
    public Page<QuestaoTecnica> buscarTodasQuestoesTecnicasFiltradas(@PageableDefault Pageable pageable, @Valid @RequestBody BuscaQuestoesBaseRequest request) {
        return buscarPaginado.buscar(pageable, request.getEspecificidade(), request.getNivelDeDificuldade());
    }

}
