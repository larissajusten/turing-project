package br.com.cwi.crescer.api.controller.QuestoesControllers;

import br.com.cwi.crescer.api.controller.requests.BuscaQuestoesTecnicasRequest;
import br.com.cwi.crescer.api.controller.requests.QuestaoTecnicaRequest;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaResponse;
import br.com.cwi.crescer.api.services.QuestaoTecnicaService.AdicionarQuestaoTecnicaService;
import br.com.cwi.crescer.api.services.QuestaoTecnicaService.BuscarQuestoesTecnicasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questao-tecnica")
public class QuestaoTecnicaController {

    @Autowired
    private BuscarQuestoesTecnicasService buscarQuestoesTecnicas;

    @Autowired
    private AdicionarQuestaoTecnicaService adicionarQuestaoTecnica;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<QuestaoTecnica> buscarQuestoesTenicas(BuscaQuestoesTecnicasRequest buscaQuestoes) {
        return buscarQuestoesTecnicas.buscar(buscaQuestoes);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public QuestaoTecnicaResponse adicionarQuestaoTecnica(QuestaoTecnicaRequest questaoTecnica) {
        return adicionarQuestaoTecnica.adicionar(questaoTecnica);
    }

}
