package br.com.cwi.crescer.api.controller.prova;

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
    private BuscarDuracaoDaProvaService buscarDuracaoDaProvaService;

    @Autowired
    private IniciarTempoDaProvaService iniciarTempoDaProvaService;

    @Autowired
    private FinalizarProvaService finalizarProvaService;

    @Autowired
    private ConsultarStatusDaProvaService consultarStatusDaProvaService;

    @Autowired
    private CorrigirProvaService corrigirProvaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long criarProvaERetornarID(@Valid @RequestBody ProvaRequest request) {
        return criarProvaService.criar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}/duracao")
    public int retornaDuracaoDaProva(@PathVariable("id-prova") Long idProva) {
        return buscarDuracaoDaProvaService.buscar(idProva);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/iniciar-prova")
    public void iniciarTempoDaProva(@PathVariable("id-prova") Long idProva) {
        iniciarTempoDaProvaService.iniciar(idProva);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/finalizar-prova")
    public StatusProva finalizarProva(@PathVariable("id-prova") Long idProva,
                                             @Valid @RequestBody List<ProvaRespondidaRequest> provaRespondida) {
        return finalizarProvaService.finalizar(idProva, provaRespondida);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}/consultar-status-prova")
    public StatusProva consultarStatusDaProva(@PathVariable("id-prova") Long idProva) {
        return consultarStatusDaProvaService.consultar(idProva);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/corrigir-prova")
    public StatusProva corrigirProva(@PathVariable("id-prova") Long idProva, @Valid @RequestBody
                                     List<CorrecaoProvaRequest> listaDeCorrecoes){
        return corrigirProvaService.corrigir(idProva, listaDeCorrecoes);
    }

}
