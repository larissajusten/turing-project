package br.com.cwi.crescer.api.controller.QuestoesControllers;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.services.questaoDissertativaService.AdicionarQuestaoDissertativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questao-dissertativa")
public class QuestaoDissertativaController {

    @Autowired
    private AdicionarQuestaoDissertativaService adicionarQuestaoDissertativaService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adicionarQuestaoDissertativa(QuestaoUnicaAlternativaRequest request) {
        adicionarQuestaoDissertativaService.adicionar(request);
    }
}
