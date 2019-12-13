package br.com.cwi.crescer.api.controller.email;

import br.com.cwi.crescer.api.services.email.EnviarEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EnviarEmailService enviarEmailService;

    @PostMapping("{email-candidato}/enviar")
    public void enviarEmail(@PathVariable("email-candidato") String emailCandidato) {

        enviarEmailService.enviar(emailCandidato);
    }
}
