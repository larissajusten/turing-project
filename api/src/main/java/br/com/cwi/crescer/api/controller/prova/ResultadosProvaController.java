package br.com.cwi.crescer.api.controller.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.services.prova.BuscarProvasRanqueadasService;
import br.com.cwi.crescer.api.services.provaquestao.CalcularNumeroDeAcertosMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.provaquestao.VerificarNumeroTotalDeQuestoesMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.respostaprova.CalcularNotaMediaDissertativaService;
import br.com.cwi.crescer.api.services.respostaprova.CalcularNotaMediaGeralDissertativaService;
import br.com.cwi.crescer.api.services.respostaprova.CalcularNotaMediaGeralTecnicaService;
import br.com.cwi.crescer.api.services.respostaprova.CalcularNotaMediaTecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

    @Autowired
    private BuscarProvasRanqueadasService buscarProvasRanqueadasService;




    @GetMapping("/{id-prova}/media-do-candidato-dissertativa")
    public double mediaDeNotaDasQuestoesDissertativa(@PathVariable("id-prova") Long idProva) {
        return calcularNotaMediaDissertativaService.calcular(idProva);
    }

    @GetMapping("/{id-prova}/media-do-candidato-tecnica")
    public double mediaDeNotaDasQuestoesTecnicas(@PathVariable("id-prova") Long idProva) {
        return calcularNotaMediaTecnicaService.calcular(idProva);
    }

    @GetMapping("{id-questao}/media-geral-tecnica")
    public double mediaDeNotaDasQuestoesTecnicasGeral(@PathVariable("id-questao") Long idQuestao) {
        return calcularNotaMediaGeralTecnicaService.calcular(idQuestao);
    }

    @GetMapping("{id-questao}/media-geral-dissertativa")
    public double mediaDeNotaDasQuestoesDissertativasGeral(@PathVariable("id-questao") Long idQuestao) {
        return calcularNotaMediaGeralDissertativaService.calcular(idQuestao);
    }

    @GetMapping("/raking/notas-provas")
    public Page<Prova> rankingDeProvas(@PageableDefault Pageable pageable) {

        return buscarProvasRanqueadasService.buscar(pageable);
    }




}
