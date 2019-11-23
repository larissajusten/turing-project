package br.com.cwi.crescer.api.controller.email;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.security.JwtTokenProvider;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Optional;

@RestController
@RequestMapping("/email")
@RolesAllowed({"ROLE_ADMIN", "ROLE_ENTREVISTADOR"})
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private JwtTokenProvider jwt;

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @GetMapping("{email-candidato}/enviar")
    public String enviarEmail(@PathVariable("email-candidato") String emailCandidato) throws MessagingException {

        Prova prova = buscarProvaPorIdService.buscar(75L);

        String token = jwt.generateToken(prova);

        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail);
        helper.setTo(emailCandidato);
        helper.setSubject("Teste Envio de e-mail");
        helper.setText("<a href='http://localhost:8100/cwi-turing/email/prova?token=" + token + "'>Acesse sua prova aqui</a>", true);
        mailSender.send(mail);

        return "OK";
    }

    @GetMapping("/prova")
    public Optional<Long> prova(@RequestParam(value = "token") String token){

        return jwt.getUserId(token);
    }

}
