package br.com.cwi.crescer.api.controller.provaquestao;


import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoDissertativa;
import br.com.cwi.crescer.api.services.provaquestao.ListarQuestoesDissertativasDaProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prova-questao-dissertativa")
public class ProvaQuestaoDissertativaController {

    @Autowired
    private ListarQuestoesDissertativasDaProvaService listarQuestoesDissertativasDaProvaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}")
    public List<ProvaQuestaoDissertativa> listarQuestoesDissertativasDaProva(@PathVariable("id-prova") Long idProva) {

        return listarQuestoesDissertativasDaProvaService.listar(idProva);

    }

}
