package br.com.cwi.crescer.api.controller.email;

import br.com.cwi.crescer.api.services.email.EnviarEmailCrescerService;
import br.com.cwi.crescer.api.services.email.EnviarEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EnviarEmailService enviarEmailService;

    @Autowired
    private EnviarEmailCrescerService enviarEmailCrescerService;

    @PostMapping("/{email-candidato}")
    public void enviarEmail(@PathVariable("email-candidato") String emailCandidato) {
        enviarEmailService.enviar(emailCandidato);
    }

    @PostMapping("crescer/{email-responsavel}/{numero-de-provas}")
    public void enviarEmailParaCrescer(@PathVariable("email-candidato") String emailResponsavel, @PathVariable("numero-de-provas") int numeroDeProvas) {
        enviarEmailCrescerService.enviar(emailResponsavel, numeroDeProvas);
    }
}
