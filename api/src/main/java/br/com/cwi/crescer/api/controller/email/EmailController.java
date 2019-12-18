package br.com.cwi.crescer.api.controller.email;

import br.com.cwi.crescer.api.services.email.EnviarEmailCrescerService;
import br.com.cwi.crescer.api.services.email.EnviarEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("crescer/{email-responsavel}")
    public void enviarEmailParaCrescer(@PathVariable("email-responsavel") String emailResponsavel) {
        enviarEmailCrescerService.enviar(emailResponsavel);
    }
}
