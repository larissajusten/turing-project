package br.com.cwi.crescer.api.controller.provaquestao;


import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.services.provaquestao.ListarQuestoesMultiplaEscolhaDaProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prova")
public class ProvaQuestaoMultiplaEscolhaController {

    @Autowired
    private ListarQuestoesMultiplaEscolhaDaProvaService listarQuestoesMultiplaEscolhaDaProvaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}/questao/multipla")
    public List<ProvaQuestaoMultiplaEscolha> listarQuestoesMultiplaEscolhaDaProva(@PathVariable("id-prova") Long idProva) {
        return listarQuestoesMultiplaEscolhaDaProvaService.listar(idProva);
    }
}
