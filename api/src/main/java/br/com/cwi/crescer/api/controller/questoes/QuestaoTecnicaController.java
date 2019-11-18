package br.com.cwi.crescer.api.controller.questoes;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesBaseRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.services.questaotecnica.AdicionarQuestaoTecnicaService;
import br.com.cwi.crescer.api.services.questaotecnica.BuscarQuestoesTecnicasFiltradasService;
import br.com.cwi.crescer.api.services.questaotecnica.ListarQuestoesTecnicasFiltradasService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public List<QuestaoTecnica> buscarQuestoesTecnicas(@Valid @RequestBody BuscaQuestoesRequest request) {
        return buscarQuestoesTecnicas.listar(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adicionarQuestaoTecnica(@Valid @RequestBody QuestaoUnicaAlternativaRequest request) {
        adicionarQuestaoTecnica.adicionar(request);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/todas-questoes-filtradas")
    public List<QuestaoTecnica> buscarTodasQuestoesTecnicasFiltradas(@Valid @RequestBody BuscaQuestoesBaseRequest request) {
        return buscarQuestoesTecnicasFiltradasService.buscar(request.getEspecificidade(), request.getNivelDeDificuldade());
    }

}
