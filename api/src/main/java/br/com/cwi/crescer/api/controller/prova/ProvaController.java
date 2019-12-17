package br.com.cwi.crescer.api.controller.prova;

import br.com.cwi.crescer.api.controller.requests.prova.CandidatoRequest;
import br.com.cwi.crescer.api.controller.requests.prova.ProvaCrescerRequest;
import br.com.cwi.crescer.api.controller.requests.prova.ProvaRequest;
import br.com.cwi.crescer.api.controller.requests.prova.ProvaRespondidaRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.CorrecaoProvaRequest;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.services.prova.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/prova")
public class ProvaController {

    @Autowired
    private CriarProvaService criarProvaService;

    @Autowired
    private CriarProvaParaCrescerService criarProvaParaCrescerService;

    @Autowired
    private BuscarDuracaoDaProvaService buscarDuracaoDaProvaService;

    @Autowired
    private IniciarTempoDaProvaService iniciarTempoDaProvaService;

    @Autowired
    private IniciarTempoDaProvaCrescerService iniciarTempoDaProvaCrescerService;

    @Autowired
    private FinalizarProvaService finalizarProvaService;

    @Autowired
    private ConsultarStatusDaProvaService consultarStatusDaProvaService;

    @Autowired
    private CorrigirProvaService corrigirProvaService;

    @Autowired
    private CancelarProvaService cancelarProvaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long criarProvaERetornarID(@Valid @RequestBody ProvaRequest request) {
        return criarProvaService.criar(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crescer")
    public void criarProvaParaCrescerERetornarID(@Valid @RequestBody ProvaCrescerRequest request) {
        criarProvaParaCrescerService.criar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}/duracao")
    public int retornaDuracaoDaProva(@PathVariable("id-prova") Long idProva) {
        return buscarDuracaoDaProvaService.buscar(idProva);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/iniciar")
    public void iniciarTempoDaProva(@PathVariable("id-prova") Long idProva) {
        iniciarTempoDaProvaService.iniciar(idProva);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/crescer")
    public void iniciarTempoDaProva(@PathVariable("id-prova") Long idProva, @RequestBody CandidatoRequest request) {
        iniciarTempoDaProvaCrescerService.iniciar(idProva, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/finalizar")
    public StatusProva finalizarProva(@PathVariable("id-prova") Long idProva,
                                      @Valid @RequestBody List<ProvaRespondidaRequest> provaRespondida) {
        return finalizarProvaService.finalizar(idProva, provaRespondida);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}/status")
    public StatusProva consultarStatusDaProva(@PathVariable("id-prova") Long idProva) {

        return consultarStatusDaProvaService.consultar(idProva);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/corrigir")
    public StatusProva corrigirProva(@PathVariable("id-prova") Long idProva, @Valid @RequestBody
            List<CorrecaoProvaRequest> listaDeCorrecoes) {
        return corrigirProvaService.corrigir(idProva, listaDeCorrecoes);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/cancelar")
    public StatusProva cancelarProva(@PathVariable("id-prova") Long idProva) {
        return cancelarProvaService.cancelar(idProva);
    }
}
