package br.com.cwi.crescer.api.controller.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("/email")
@RolesAllowed({"ROLE_ADMIN", "ROLE_ENTREVISTADOR"})
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("{email-candidato}/enviar")
    public String enviarEmail(@PathVariable("email-candidato") String emailCandidato) throws MessagingException {

        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper( mail );
        helper.setTo(emailCandidato);
        helper.setSubject( "Teste Envio de e-mail" );
        helper.setText("<p>Hello from Spring Boot Application</p>", true);
        mailSender.send(mail);

        return "OK";
    }
}
