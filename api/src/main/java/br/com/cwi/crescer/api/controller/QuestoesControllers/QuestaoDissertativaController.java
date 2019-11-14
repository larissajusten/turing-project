package br.com.cwi.crescer.api.controller.QuestoesControllers;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.services.questaoDissertativaService.AdicionarQuestaoDissertativaService;
import br.com.cwi.crescer.api.services.questaoDissertativaService.BuscarQuestaoDissertativaPorEspecificidadeENivelService;
import br.com.cwi.crescer.api.services.questaoDissertativaService.ListarQuestoesDissertativasFiltradas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questao-dissertativa")
public class QuestaoDissertativaController {

    @Autowired
    AdicionarQuestaoDissertativaService adicionarQuestaoDissertativaService;

    @Autowired
    ListarQuestoesDissertativasFiltradas listarQuestoesDissertativasFiltradas;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adicionarQuestaoDissertativa(QuestaoUnicaAlternativaRequest request) {
        adicionarQuestaoDissertativaService.adicionar(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public List<QuestaoDissertativa> buscarQuestoesDissertativasFiltradas(BuscaQuestoesRequest request) {
        return listarQuestoesDissertativasFiltradas.listar(request);
    }
}
