package br.com.cwi.crescer.api.controller.provaquestao;


import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoDissertativa;
import br.com.cwi.crescer.api.services.provaquestao.ListarQuestoesDissertativasDaProvaService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
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
