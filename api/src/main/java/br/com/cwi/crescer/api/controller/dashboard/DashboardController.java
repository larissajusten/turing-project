package br.com.cwi.crescer.api.controller.dashboard;

import br.com.cwi.crescer.api.controller.responses.RespostaParaDashboardResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.services.dashboard.BuscarQuestoesDissertativasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService;
import br.com.cwi.crescer.api.services.dashboard.BuscarQuestoesTecnicasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private BuscarQuestoesDissertativasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService buscarQuestoesDissertativas;

    @Autowired
    private BuscarQuestoesTecnicasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService buscarQuestoesTecnicas;
    @PutMapping("/dissertativas")
    public List<RespostaParaDashboardResponse> discursivas(@RequestBody Especificidade especificidade) {
        return  buscarQuestoesDissertativas.buscar(especificidade);
    }

    @PutMapping("/tecnicas")
    public List<RespostaParaDashboardResponse> tecnicas(@RequestBody Especificidade especificidade) {
        return  buscarQuestoesTecnicas.buscar(especificidade);
    }

}
