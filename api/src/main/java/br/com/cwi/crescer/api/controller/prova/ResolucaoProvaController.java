package br.com.cwi.crescer.api.controller.prova;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.responses.ProvaResponse;
import br.com.cwi.crescer.api.services.provaquestao.CalcularNumeroDeAcertosMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.provaservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/resolucaoprova")
public class ResolucaoProvaController {

    @Autowired
    private CalcularNumeroDeAcertosMultiplaEscolhaService calcularNumeroDeAcertosMultiplaEscolhaService;

    @GetMapping("/{id-prova}/acertos-multipla-escolha")
    public int numeroDeAcertosDasQuestoesMultiplaEscolha(@PathVariable("id-prova") Long idProva) {
        return calcularNumeroDeAcertosMultiplaEscolhaService.calcular(idProva);
    }
}
