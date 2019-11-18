package br.com.cwi.crescer.api.controller.prova;

import br.com.cwi.crescer.api.services.respostaprova.CalcularNotaMediaDissertativaService;
import br.com.cwi.crescer.api.services.respostaprova.CalcularNotaMediaTecnicaService;
import br.com.cwi.crescer.api.services.provaquestao.VerificarNumeroTotalDeQuestoesMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.provaquestao.CalcularNumeroDeAcertosMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.respostaprova.CalcularNotaMediaGeralTecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/resultadoprova")
public class ResultadosProvaController {

    @Autowired
    private CalcularNumeroDeAcertosMultiplaEscolhaService calcularNumeroDeAcertosMultiplaEscolhaService;

    @Autowired
    private VerificarNumeroTotalDeQuestoesMultiplaEscolhaService verificarNumeroTotalDeQuestoesMultiplaEscolhaService;

    @Autowired
    private CalcularNotaMediaDissertativaService calcularNotaMediaDissertativaService;

    @Autowired
    private CalcularNotaMediaTecnicaService calcularNotaMediaTecnicaService;

    @Autowired
    private CalcularNotaMediaGeralTecnicaService calcularNotaMediaGeralTecnicaService;

    //@RolesAllowed("Administrator", "Entrevistador", "Usuario")
    @GetMapping("/{id-prova}/acertos-multipla-escolha")
    public int numeroDeAcertosDasQuestoesMultiplaEscolha(@PathVariable("id-prova") Long idProva) {
        return calcularNumeroDeAcertosMultiplaEscolhaService.calcular(idProva);
    }

    //@RolesAllowed("Administrator", "Entrevistador", "Usuario")
    @GetMapping("/{id-prova}/total-de-multipla-escolha")
    public int numeroTotalDeQuestoesMultiplaEscolhaDeUmaProva(@PathVariable("id-prova") Long idProva) {
        return verificarNumeroTotalDeQuestoesMultiplaEscolhaService.verificar(idProva);
    }

    //@RolesAllowed("Administrator", "Entrevistador", "Usuario")
    @GetMapping("/{id-prova}/media-dissertativa")
    public double mediaDeNotaDasQuestoesDissertativa(@PathVariable("id-prova") Long idProva) {
        return calcularNotaMediaDissertativaService.calcular(idProva);
    }

    //@RolesAllowed("Administrator", "Entrevistador", "Usuario")
    @GetMapping("/{id-prova}/media-tecnica")
    public double mediaDeNotaDasQuestoesTecnicas(@PathVariable("id-prova") Long idProva) {
        return calcularNotaMediaTecnicaService.calcular(idProva);
    }

    //@RolesAllowed("Administrator", "Entrevistador", "Usuario")
    @GetMapping("{id-questao}/media-tecnica")
    public double mediaDeNotaDasQuestoesTecnicasGeral(@PathVariable("id-questao") Long idQuestao) {
        return calcularNotaMediaGeralTecnicaService.calcular(idQuestao);
    }
}
