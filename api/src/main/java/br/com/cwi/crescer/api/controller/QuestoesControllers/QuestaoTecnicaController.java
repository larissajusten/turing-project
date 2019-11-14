package br.com.cwi.crescer.api.controller.QuestoesControllers;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.services.questaoTecnicaService.AdicionarQuestaoTecnicaService;
import br.com.cwi.crescer.api.services.questaoTecnicaService.ListarQuestoesTecnicasFiltradasService;
import br.com.cwi.crescer.api.services.questaoTecnicaService.ListarTodasQuestoesTecnicasFiltradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questao-tecnica")
public class QuestaoTecnicaController {

    @Autowired
    private ListarQuestoesTecnicasFiltradasService buscarQuestoesTecnicas;

    @Autowired
    private AdicionarQuestaoTecnicaService adicionarQuestaoTecnica;

    @Autowired
    private ListarTodasQuestoesTecnicasFiltradasService listarTodasQuestoesTecnicasFiltradasService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<QuestaoTecnica> buscarQuestoesTecnicas(@RequestBody BuscaQuestoesRequest request) {
        return buscarQuestoesTecnicas.listar(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adicionarQuestaoTecnica(@RequestBody QuestaoUnicaAlternativaRequest request) {
        adicionarQuestaoTecnica.adicionar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public List<QuestaoTecnica> buscarQuestoesTecnicasFiltradas(@RequestBody BuscaQuestoesRequest request) {
        return buscarQuestoesTecnicas.listar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/todas-questoes-filtradas")
    public List<QuestaoTecnica> buscarTodasQuestoesTecnicasFiltradas(@RequestBody BuscaQuestoesRequest request) {
        return listarTodasQuestoesTecnicasFiltradasService.buscar(request);
    }

}
