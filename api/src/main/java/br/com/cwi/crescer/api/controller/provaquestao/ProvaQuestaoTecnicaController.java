package br.com.cwi.crescer.api.controller.provaquestao;


import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoTecnica;
import br.com.cwi.crescer.api.services.provaquestao.ListarQuestoesTecnicasDaProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/prova-questao-tecnica")
public class ProvaQuestaoTecnicaController {

    @Autowired
    private ListarQuestoesTecnicasDaProvaService listarQuestoesTecnicasDaProvaService;

    @RolesAllowed({"ROLE_ADMIN", "ROLE_ENTREVISTADOR"})
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id-prova}")
    public List<ProvaQuestaoTecnica> listarQuestoesDissertativasDaProva(@PathVariable("id-prova") Long idProva) {
        return listarQuestoesTecnicasDaProvaService.listar(idProva);
    }
}
