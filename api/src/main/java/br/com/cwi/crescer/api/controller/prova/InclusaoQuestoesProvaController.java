package br.com.cwi.crescer.api.controller.prova;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.services.questaodissertativa.IncluirQuestoesDissertativasService;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.IncluirQuestoesMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.questaotecnica.IncluirQuestoesTecnicasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/incluir")
public class InclusaoQuestoesProvaController {

    @Autowired
    private IncluirQuestoesDissertativasService incluirQuestoesDissertativasService;

    @Autowired
    private IncluirQuestoesTecnicasService incluirQuestoesTecnicasService;

    @Autowired
    private IncluirQuestoesMultiplaEscolhaService incluirQuestoesMultiplaEscolhaService;


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/dissertativa")
    public List<QuestaoDissertativa> incluirDissertativas(@PathVariable("id-prova") Long idProva, @Valid @RequestBody BuscaQuestoesRequest buscaQuestoesRequest) {
        return incluirQuestoesDissertativasService.incluir(idProva, buscaQuestoesRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/tecnica")
    public void incluirTecnicas(@PathVariable("id-prova") Long idProva, @Valid @RequestBody BuscaQuestoesRequest buscaQuestoesRequest) {
        incluirQuestoesTecnicasService.incluir(idProva, buscaQuestoesRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/multipla-escolha")
    public void incluirMultiplasEscolhas(@PathVariable("id-prova") Long idProva, @Valid @RequestBody BuscaQuestoesRequest buscaQuestoesRequest) {
        incluirQuestoesMultiplaEscolhaService.incluir(idProva, buscaQuestoesRequest);
    }
}
