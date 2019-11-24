package br.com.cwi.crescer.api.services.email;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.security.JwtTokenProvider;
import br.com.cwi.crescer.api.services.prova.BuscarProvaAtivaPorEmailDoCandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EnviarEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private JwtTokenProvider jwt;

    @Autowired
    private BuscarProvaAtivaPorEmailDoCandidatoService buscarProvaPorEmail;

    public void enviar(String emailCandidato) throws MessagingException {

        Prova prova = buscarProvaPorEmail.buscar(emailCandidato);

        String token = jwt.generateToken(prova);

        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail);

        helper.setTo(emailCandidato);
        helper.setSubject("CWI TURING TEM UMA PROVA AGUARDANDO VOCÊ!");
        helper.setText("<a href='http://localhost:3000/resolver-prova?token=" + token + "'>Acesse sua prova aqui</a>", true);

        mailSender.send(mail);
    }

}
