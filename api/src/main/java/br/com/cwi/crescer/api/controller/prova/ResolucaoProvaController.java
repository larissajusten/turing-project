package br.com.cwi.crescer.api.controller.prova;

import br.com.cwi.crescer.api.services.provaquestao.CalcularNumeroDeAcertosMultiplaEscolhaService;
import org.springframework.beans.factory.annotation.Autowired;
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
