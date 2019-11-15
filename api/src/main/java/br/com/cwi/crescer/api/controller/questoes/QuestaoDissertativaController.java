package br.com.cwi.crescer.api.controller.questoes;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.services.questaodissertativa.AdicionarQuestaoDissertativaService;
import br.com.cwi.crescer.api.services.questaodissertativa.ListarQuestoesDissertativasFiltradasService;
import br.com.cwi.crescer.api.services.questaodissertativa.ListarTodasQuestoesDissertativasFiltradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questao-dissertativa")
public class QuestaoDissertativaController {

    @Autowired
    private AdicionarQuestaoDissertativaService adicionarQuestaoDissertativaService;

    @Autowired
    private ListarQuestoesDissertativasFiltradasService listarQuestoesDissertativasFiltradas;

    @Autowired
    private ListarTodasQuestoesDissertativasFiltradasService listarTodasQuestoesDissertativasFiltradasService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adicionarQuestaoDissertativa(@RequestBody QuestaoUnicaAlternativaRequest request) {
        adicionarQuestaoDissertativaService.adicionar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public List<QuestaoDissertativa> listarQuestoesDissertativasFiltradas(@RequestBody  BuscaQuestoesRequest request) {
        return listarQuestoesDissertativasFiltradas.listar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/todas-questoes-filtradas")
    public List<QuestaoDissertativa> listarTodasQuestoesDissertativas(@RequestBody BuscaQuestoesRequest request) {
        return listarTodasQuestoesDissertativasFiltradasService.listar(request);
    }
}
