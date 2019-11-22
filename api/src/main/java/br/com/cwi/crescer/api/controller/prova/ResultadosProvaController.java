package br.com.cwi.crescer.api.controller.prova;

import br.com.cwi.crescer.api.services.provaquestao.CalcularNumeroDeAcertosMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.provaquestao.VerificarNumeroTotalDeQuestoesMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.respostaprova.CalcularNotaMediaDissertativaService;
import br.com.cwi.crescer.api.services.respostaprova.CalcularNotaMediaGeralDissertativaService;
import br.com.cwi.crescer.api.services.respostaprova.CalcularNotaMediaGeralTecnicaService;
import br.com.cwi.crescer.api.services.respostaprova.CalcularNotaMediaTecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;


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

    @Autowired
    private CalcularNotaMediaGeralDissertativaService calcularNotaMediaGeralDissertativaService;

    @RolesAllowed({"ROLE_ADMIN", "ROLE_ENTREVISTADOR"})
    @GetMapping("/{id-prova}/numero-acertos-multipla-escolha")
    public int numeroDeAcertosDasQuestoesMultiplaEscolha(@PathVariable("id-prova") Long idProva) {
        return calcularNumeroDeAcertosMultiplaEscolhaService.calcular(idProva);
    }

    @RolesAllowed({"ROLE_ADMIN", "ROLE_ENTREVISTADOR"})
    @GetMapping("/{id-prova}/numero-total-de-multipla-escolha")
    public int numeroTotalDeQuestoesMultiplaEscolhaDeUmaProva(@PathVariable("id-prova") Long idProva) {
        return verificarNumeroTotalDeQuestoesMultiplaEscolhaService.verificar(idProva);
    }

    @RolesAllowed({"ROLE_ADMIN", "ROLE_ENTREVISTADOR"})
    @GetMapping("/{id-prova}/media-do-candidato-dissertativa")
    public double mediaDeNotaDasQuestoesDissertativa(@PathVariable("id-prova") Long idProva) {
        return calcularNotaMediaDissertativaService.calcular(idProva);
    }

    @RolesAllowed({"ROLE_ADMIN", "ROLE_ENTREVISTADOR"})
    @GetMapping("/{id-prova}/media-do-candidato-tecnica")
    public double mediaDeNotaDasQuestoesTecnicas(@PathVariable("id-prova") Long idProva) {
        return calcularNotaMediaTecnicaService.calcular(idProva);
    }

    @RolesAllowed({"ROLE_ADMIN", "ROLE_ENTREVISTADOR"})
    @GetMapping("{id-questao}/media-geral-tecnica")
    public double mediaDeNotaDasQuestoesTecnicasGeral(@PathVariable("id-questao") Long idQuestao) {
        return calcularNotaMediaGeralTecnicaService.calcular(idQuestao);
    }

    @RolesAllowed({"ROLE_ADMIN", "ROLE_ENTREVISTADOR"})
    @GetMapping("{id-questao}/media-geral-dissertativa")
    public double mediaDeNotaDasQuestoesDissertativasGeral(@PathVariable("id-questao") Long idQuestao) {
        return calcularNotaMediaGeralDissertativaService.calcular(idQuestao);
    }

}
