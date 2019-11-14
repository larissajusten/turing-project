package br.com.cwi.crescer.api.controller.QuestoesControllers;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.services.questaoTecnicaService.AdicionarQuestaoTecnicaService;
import br.com.cwi.crescer.api.services.questaoTecnicaService.ListarQuestoesTecnicasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questao-tecnica")
public class QuestaoTecnicaController {

    @Autowired
    private ListarQuestoesTecnicasService buscarQuestoesTecnicas;

    @Autowired
    private AdicionarQuestaoTecnicaService adicionarQuestaoTecnica;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<QuestaoTecnica> buscarQuestoesTecnicasFiltradas(BuscaQuestoesRequest request) {
        return buscarQuestoesTecnicas.buscar(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adicionarQuestaoTecnica(QuestaoUnicaAlternativaRequest request) {
        adicionarQuestaoTecnica.adicionar(request);
    }

}
