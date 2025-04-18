package br.com.cwi.crescer.api.controller.dashboard;

import br.com.cwi.crescer.api.controller.responses.LinguagensResponse;
import br.com.cwi.crescer.api.controller.responses.RespostaParaDashboardResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.services.dashboard.BuscarQuestoesDissertativasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService;
import br.com.cwi.crescer.api.services.dashboard.BuscarQuestoesTecnicasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService;
import br.com.cwi.crescer.api.services.respostaprova.RetornaErrosEAcertosMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.respostaprova.RetornaLinguagensDoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private BuscarQuestoesDissertativasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService buscarQuestoesDissertativas;

    @Autowired
    private BuscarQuestoesTecnicasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService buscarQuestoesTecnicas;

    @Autowired
    private RetornaErrosEAcertosMultiplaEscolhaService retornaErrosEAcertosMultiplaEscolhaService;

    @Autowired
    private RetornaLinguagensDoUsuarioService retornaLinguagensDoUsuarioService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{especificidade}/dissertativa")
    public List<RespostaParaDashboardResponse> retornaDadosParaGraficoDeQuestoesDissertativas(@PathVariable("especificidade") Especificidade especificidade) {
        return buscarQuestoesDissertativas.buscar(especificidade);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{especificidade}/tecnica")
    public List<RespostaParaDashboardResponse> retornaDadosParaGraficoDeQuestoesTecnicas(@PathVariable("especificidade") Especificidade especificidade) {
        return buscarQuestoesTecnicas.buscar(especificidade);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{especificidade}/multipla")
    public List<Integer> retornaErrosEAcertosDasQuestoesDeMultiplasEscolhas(@PathVariable("especificidade") Especificidade especificidade) {
        return retornaErrosEAcertosMultiplaEscolhaService.retornar(especificidade);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<LinguagensResponse> retornaUsuariosPorLinguagens() {
        return retornaLinguagensDoUsuarioService.retornar();
    }
}
