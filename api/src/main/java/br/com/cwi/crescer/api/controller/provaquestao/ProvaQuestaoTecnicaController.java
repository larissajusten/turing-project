package br.com.cwi.crescer.api.controller.provaquestao;


import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoTecnica;
import br.com.cwi.crescer.api.services.provaquestao.ListarQuestoesTecnicasDaProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prova")
public class ProvaQuestaoTecnicaController {

    @Autowired
    private ListarQuestoesTecnicasDaProvaService listarQuestoesTecnicasDaProvaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}/questao/tecnica")
    public List<ProvaQuestaoTecnica> listarQuestoesDissertativasDaProva(@PathVariable("id-prova") Long idProva) {
        return listarQuestoesTecnicasDaProvaService.listar(idProva);
    }
}
