package br.com.cwi.crescer.api.controller;

import br.com.cwi.crescer.api.controller.requests.questoes.CorrecaoProvaRequest;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.services.respostaprova.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/resposta")
public class RespostaProvaController {

    @Autowired
    private CorrigirQuestaoDissertativaService corrigirQuestaoDissertativaService;

    @Autowired
    private CorrigirQuestaoTecnicaService corrigirQuestaoTecnicaService;

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-resposta}/corrigir-dissertativa")
    public void corrigirQuestaoDissertativa(@PathVariable("id-resposta") Long idResposta,
                                            @Valid @RequestBody CorrecaoProvaRequest correcao) {
        corrigirQuestaoDissertativaService.corrigir(idResposta, correcao);
    }

    //@RolesAllowed("Administrator", "Entrevistador")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-resposta}/corrigir-tecnica")
    public void corrigirQuestaoTecnica(@PathVariable("id-resposta") Long idResposta,
                                       @Valid @RequestBody CorrecaoProvaRequest correcao) {
        corrigirQuestaoTecnicaService.corrigir(idResposta, correcao);
    }

}
