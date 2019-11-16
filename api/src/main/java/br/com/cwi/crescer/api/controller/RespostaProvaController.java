package br.com.cwi.crescer.api.controller;

import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.services.respostaprova.ResponderQuestaoDissertativaService;
import br.com.cwi.crescer.api.services.respostaprova.ResponderQuestaoMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.respostaprova.ResponderQuestaoTecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resposta")
public class RespostaProvaController {

    @Autowired
    private ResponderQuestaoDissertativaService responderQuestaoDissertativaService;

    @Autowired
    private ResponderQuestaoTecnicaService responderQuestaoTecnicaService;

    @Autowired
    private ResponderQuestaoMultiplaEscolhaService responderQuestaoMultiplaEscolhaService;

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/{id-questao}/responder-dissertativa")
    public RespostasDissertativaProva responderQuestaoDissertativa(@PathVariable("id-prova") Long idProva, @PathVariable("id-questao") Long idQuestao,
                                                                   @RequestBody String resposta){
        return responderQuestaoDissertativaService.responder(idProva, idQuestao, resposta);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/{id-questao}/responder-tecnica")
    public RespostasTecnicaProva responderQuestaoTecnica(@PathVariable("id-prova") Long idProva, @PathVariable("id-questao") Long idQuestao,
                                                         @RequestBody String resposta){
        return responderQuestaoTecnicaService.responder(idProva, idQuestao, resposta);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id-prova}/{id-questao}/{id-alternativa}/responder-multipla-escolha")
    public RespostasMultiplaEscolhaProva responderQuestaoMultiplaEscolha(@PathVariable("id-prova") Long idProva,
                                                                         @PathVariable("id-questao") Long idQuestao,
                                                                         @PathVariable("id-alternativa") Long idAlternativa){
        return responderQuestaoMultiplaEscolhaService.responder(idProva, idQuestao, idAlternativa);
    }

}
