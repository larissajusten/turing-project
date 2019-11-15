package br.com.cwi.crescer.api.controller.prova;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.services.provaservice.CriarProvaService;
import br.com.cwi.crescer.api.services.provaservice.IncluirQuestoesDissertativasService;
import br.com.cwi.crescer.api.services.provaservice.IncluirQuestoesMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.provaservice.IncluirQuestoesTecnicasService;
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

    @Autowired
    private IncluirQuestoesTecnicasService incluirQuestoesTecnicasService;

    @Autowired
    private IncluirQuestoesMultiplaEscolhaService incluirQuestoesMultiplaEscolhaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void criarProva(ProvaRequest request) {
        criarProvaService.criar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/incluir-dissertativa")
    public void incluirDissertativas(@PathVariable("id-prova") Long idProva, BuscaQuestoesRequest buscaQuestoesRequest){
        incluirQuestoesDissertativasService.incluir(idProva, buscaQuestoesRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/incluir-tecnica")
    public void incluirTecnicas(@PathVariable("id-prova") Long idProva, BuscaQuestoesRequest buscaQuestoesRequest){
        incluirQuestoesTecnicasService.incluir(idProva, buscaQuestoesRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/incluir-multipla-escolha")
    public void incluirMultiplasEscolhas(@PathVariable("id-prova") Long idProva, BuscaQuestoesRequest buscaQuestoesRequest){
        incluirQuestoesMultiplaEscolhaService.incluir(idProva, buscaQuestoesRequest);
    }
}
