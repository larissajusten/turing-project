package br.com.cwi.crescer.api.controller.prova;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.responses.ProvaResponse;
import br.com.cwi.crescer.api.services.prova.*;
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

    @Autowired
    private BuscarProvaComQuestoesService buscarProvaComQuestoesService;

    @Autowired
    private BuscarDuracaoDaProvaService buscarDuracaoDaProvaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long criarProvaERetornarID(@RequestBody ProvaRequest request) {
        return criarProvaService.criar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/incluir-dissertativa")
    public void incluirDissertativas(@PathVariable("id-prova") Long idProva, @RequestBody BuscaQuestoesRequest buscaQuestoesRequest){
        incluirQuestoesDissertativasService.incluir(idProva, buscaQuestoesRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/incluir-tecnica")
    public void incluirTecnicas(@PathVariable("id-prova") Long idProva, @RequestBody BuscaQuestoesRequest buscaQuestoesRequest){
        incluirQuestoesTecnicasService.incluir(idProva, buscaQuestoesRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/incluir-multipla-escolha")
    public void incluirMultiplasEscolhas(@PathVariable("id-prova") Long idProva, @RequestBody BuscaQuestoesRequest buscaQuestoesRequest){
        incluirQuestoesMultiplaEscolhaService.incluir(idProva, buscaQuestoesRequest);
    }

    @GetMapping("/{id-prova}/buscar-prova")
    public ProvaResponse buscarProva(@PathVariable("id-prova") Long idProva) {
        return buscarProvaComQuestoesService.buscar(idProva);
    }

    @GetMapping("/{id-prova}/duracao")
    public int retornaDuracaoDaProva(@PathVariable("id-prova") Long idProva) {
        return buscarDuracaoDaProvaService.buscar(idProva);
    }

}
