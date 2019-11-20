package br.com.cwi.crescer.api.controller.prova;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.responses.ProvaParaCorrecaoResponse;
import br.com.cwi.crescer.api.controller.responses.ProvaResponse;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.services.prova.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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

    @Autowired
    private IniciarTempoDaProvaService iniciarTempoDaProvaService;

    @Autowired
    private FinalizarTempoDaProvaService finalizarTempoDaProvaService;

    @Autowired
    private ConsultarStatusDaProvaService consultarStatusDaProvaService;

    @Autowired
    private ExcluirQuestaoDissertativaService excluirQuestaoDissertativaService;

    @Autowired
    private ExcluirQuestaoMultiplaEscolhaService excluirQuestaoMultiplaEscolhaService;

    @Autowired
    private ExcluirQuestaoTecnicaService excluirQuestaoTecnicaService;

    @Autowired
    private BuscarProvasParaCorrecaoService buscarProvasParaCorrecaoService;

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long criarProvaERetornarID(@Valid @RequestBody ProvaRequest request) {
        return criarProvaService.criar(request);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/incluir-dissertativa")
    public void incluirDissertativas(@PathVariable("id-prova") Long idProva, @Valid @RequestBody BuscaQuestoesRequest buscaQuestoesRequest) {
        incluirQuestoesDissertativasService.incluir(idProva, buscaQuestoesRequest);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id-prova}/excluir-dissertativa/{id-questao-prova}")
    public void excluirDissertativa(@PathVariable("id-prova") Long idProva,
                                    @PathVariable("id-questao-prova") Long idQuestaoProva) {
        excluirQuestaoDissertativaService.excluir(idQuestaoProva, idProva);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/incluir-tecnica")
    public void incluirTecnicas(@PathVariable("id-prova") Long idProva, @Valid @RequestBody BuscaQuestoesRequest buscaQuestoesRequest) {
        incluirQuestoesTecnicasService.incluir(idProva, buscaQuestoesRequest);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id-prova}/excluir-tecnica/{id-questao-prova}")
    public void excluirTecnicaProva(@PathVariable("id-prova") Long idProva,
                                    @PathVariable("id-questao-prova") Long idQuestaoProva) {
        excluirQuestaoTecnicaService.excluir(idQuestaoProva, idProva);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/incluir-multipla-escolha")
    public void incluirMultiplasEscolhas(@PathVariable("id-prova") Long idProva, @Valid @RequestBody BuscaQuestoesRequest buscaQuestoesRequest) {
        incluirQuestoesMultiplaEscolhaService.incluir(idProva, buscaQuestoesRequest);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id-prova}/excluir-multipla-escolha/{id-questao-prova}")
    public void excluirMultiplaEscolha(@PathVariable("id-prova") Long idProva,
                                       @PathVariable("id-questao-prova") Long idQuestaoProva) {
        excluirQuestaoMultiplaEscolhaService.excluir(idQuestaoProva, idProva);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}/buscar-prova")
    public ProvaResponse buscarProva(@PathVariable("id-prova") Long idProva) {
        return buscarProvaComQuestoesService.buscar(idProva);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}/duracao")
    public int retornaDuracaoDaProva(@PathVariable("id-prova") Long idProva) {
        return buscarDuracaoDaProvaService.buscar(idProva);
    }

    //@RolesAllowed("Usuario")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/iniciar-prova")
    public void iniciarTempoDaProva(@PathVariable("id-prova") Long idProva) {
        iniciarTempoDaProvaService.iniciar(idProva);
    }

    //@RolesAllowed("Usuario")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/finalizar-prova")
    public StatusProva finalizarTempoDaProva(@PathVariable("id-prova") Long idProva) {
        return finalizarTempoDaProvaService.finalizar(idProva);
    }

    //@RolesAllowed("Administrator", "Entrevistador", "Usuario")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}/consultar-status-prova")
    public StatusProva consultarStatusDaProva(@PathVariable("id-prova") Long idProva) {
        return consultarStatusDaProvaService.consultar(idProva);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/para-correcao")
    public Page<ProvaParaCorrecaoResponse> buscarProvasParaCorrcao(@PageableDefault Pageable pageable) {

        return buscarProvasParaCorrecaoService.buscar(pageable);
    }


}
