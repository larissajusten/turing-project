package br.com.cwi.crescer.api.controller.provaController;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.services.provaService.CriarProvaService;
import br.com.cwi.crescer.api.services.provaService.IncluirQuestoesDissertativasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/prova")
public class ProvaController {

    @Autowired
    private CriarProvaService criarProvaService;

    @Autowired
    private IncluirQuestoesDissertativasService incluirQuestoesDissertativasService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void criarProva(ProvaRequest request) {
        criarProvaService.criar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/incluir-dissertativa")
    public void incluirDissertativas(@PathVariable("id-prova") Long idProva,  BuscaQuestoesRequest buscaQuestoesRequest){
        incluirQuestoesDissertativasService.incluir(idProva, buscaQuestoesRequest);
    }
}
