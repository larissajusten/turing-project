package br.com.cwi.crescer.api.controller.prova;

import br.com.cwi.crescer.api.services.questaodissertativa.ExcluirQuestaoDissertativaService;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.ExcluirQuestaoMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.questaotecnica.ExcluirQuestaoTecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prova")
public class ExclusaoQuestoesProvaController {

    @Autowired
    private ExcluirQuestaoDissertativaService excluirQuestaoDissertativaService;

    @Autowired
    private ExcluirQuestaoMultiplaEscolhaService excluirQuestaoMultiplaEscolhaService;

    @Autowired
    private ExcluirQuestaoTecnicaService excluirQuestaoTecnicaService;

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id-prova}/dissertativa/{id-questao-prova}")
    public void excluirDissertativa(@PathVariable("id-prova") Long idProva,
                                    @PathVariable("id-questao-prova") Long idQuestaoProva) {
        excluirQuestaoDissertativaService.excluir(idQuestaoProva, idProva);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id-prova}/tecnica/{id-questao-prova}")
    public void excluirTecnicaProva(@PathVariable("id-prova") Long idProva,
                                    @PathVariable("id-questao-prova") Long idQuestaoProva) {
        excluirQuestaoTecnicaService.excluir(idQuestaoProva, idProva);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id-prova}/multipla/{id-questao-prova}")
    public void excluirMultiplaEscolha(@PathVariable("id-prova") Long idProva,
                                       @PathVariable("id-questao-prova") Long idQuestaoProva) {
        excluirQuestaoMultiplaEscolhaService.excluir(idQuestaoProva, idProva);
    }
}
