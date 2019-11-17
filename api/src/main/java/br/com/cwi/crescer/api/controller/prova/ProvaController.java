package br.com.cwi.crescer.api.controller.prova;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.responses.ProvaResponse;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
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
    @DeleteMapping("/{id-questao-prova}/excluir-dissertativa")
    public void excluirDissertativa(@PathVariable("id-questao-prova") Long idQuestaoProva){
        excluirQuestaoDissertativaService.excluir(idQuestaoProva);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/incluir-tecnica")
    public void incluirTecnicas(@PathVariable("id-prova") Long idProva, @RequestBody BuscaQuestoesRequest buscaQuestoesRequest){
        incluirQuestoesTecnicasService.incluir(idProva, buscaQuestoesRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id-questao-prova}/excluir-tecnica")
    public void excluirTecnicaProva(@PathVariable("id-questao-prova") Long idQuestaoProva) {
        excluirQuestaoTecnicaService.excluir(idQuestaoProva);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/incluir-multipla-escolha")
    public void incluirMultiplasEscolhas(@PathVariable("id-prova") Long idProva, @RequestBody BuscaQuestoesRequest buscaQuestoesRequest){
        incluirQuestoesMultiplaEscolhaService.incluir(idProva, buscaQuestoesRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id-questao-prova}/excluir-multipla-escolha")
    public void excluirMultiplaEscolha(@PathVariable("id-questao-prova") Long idQuestaoProva){
        excluirQuestaoMultiplaEscolhaService.excluir(idQuestaoProva);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}/buscar-prova")
    public ProvaResponse buscarProva(@PathVariable("id-prova") Long idProva) {
        return buscarProvaComQuestoesService.buscar(idProva);
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
    public StatusProva finalizarTempoDaProva(@PathVariable("id-prova") Long idProva) {
        return finalizarTempoDaProvaService.finalizar(idProva);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}/consultar-status-prova")
        public StatusProva consultarStatusDaProva(@PathVariable("id-prova") Long idProva) {
            return consultarStatusDaProvaService.consultar(idProva);
        }
}
