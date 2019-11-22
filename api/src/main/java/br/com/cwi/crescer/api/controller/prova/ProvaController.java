package br.com.cwi.crescer.api.controller.prova;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.CorrecaoProvaRequest;
import br.com.cwi.crescer.api.controller.responses.ProvaComRespostasResponse;
import br.com.cwi.crescer.api.controller.responses.ProvaCorrigidaResponse;
import br.com.cwi.crescer.api.controller.responses.ProvaParaCorrecaoResponse;
import br.com.cwi.crescer.api.controller.requests.prova.ProvaRespondidaRequest;
import br.com.cwi.crescer.api.controller.responses.ProvaResponse;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.services.prova.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private FinalizarProvaService finalizarProvaService;

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

    @Autowired
    private CorrigirProvaService corrigirProvaService;

    @Autowired
    private BuscarProvasCorrigidasComNotaService buscarProvasCorrigidasComNotaService;

    @Autowired
    private BuscarProvaComRespostasDoUsuarioService buscarProvaComRespostasDoUsuario;

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long criarProvaERetornarID(@Valid @RequestBody ProvaRequest request) {
        return criarProvaService.criar(request);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/incluir-dissertativa")
    public List<QuestaoDissertativa> incluirDissertativas(@PathVariable("id-prova") Long idProva, @Valid @RequestBody BuscaQuestoesRequest buscaQuestoesRequest) {
        return incluirQuestoesDissertativasService.incluir(idProva, buscaQuestoesRequest);
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
    public StatusProva finalizarProva(@PathVariable("id-prova") Long idProva,
                                             @Valid @RequestBody List<ProvaRespondidaRequest> provaRespondida) {
        return finalizarProvaService.finalizar(idProva, provaRespondida);
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


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}-corrigir")
    public StatusProva corrigirProva(@PathVariable("id-prova") Long idProva, @Valid @RequestBody
                                     List<CorrecaoProvaRequest> listaDeCorrecoes){
        return corrigirProvaService.corrigir(idProva, listaDeCorrecoes);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{nome-ou-email}/provas-corrigidas")
    public List<ProvaCorrigidaResponse> provaCompletaComRespostas(@PathVariable("nome-ou-email") String nomeOuEmail) {
        return buscarProvasCorrigidasComNotaService.buscar(nomeOuEmail);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}-respostas")
    public ProvaComRespostasResponse provaComRespostas(@PathVariable("id-prova") Long idProva) {
        return buscarProvaComRespostasDoUsuario.buscar(idProva);
    }

}
