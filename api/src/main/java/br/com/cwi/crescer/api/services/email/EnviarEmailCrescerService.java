package br.com.cwi.crescer.api.services.email;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.services.prova.BuscarProvaCriadaPorEmailDoCandidatoService;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorCriadaECrescerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnviarEmailCrescerService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JwtTokenProvider jwt;

    @Autowired
    private BuscarProvaPorCriadaECrescerService buscarProvaPorCriadaECrescerService;

    public void enviar(String emailResponsavel) {

        List<Prova> listaDeProvas = buscarProvaPorCriadaECrescerService.buscar();

        String processedHTMLTemplate = this.constructHTMLTemplate(listaDeProvas);

        MimeMessagePreparator preparator = message -> {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED, "UTF-8");
            helper.setSubject("PROVAS DO CRESCER!");
            helper.setTo(emailResponsavel);
            helper.setText(processedHTMLTemplate, true);
        };

        mailSender.send(preparator);
    }

    private String constructHTMLTemplate(List<Prova> listaDeProvas) {
        Context context = new Context();
        List<String> tokens = new ArrayList<>();

        for (Prova prova: listaDeProvas) {
           tokens.add(jwt.generateToken(prova));
        }
        int quantidade = listaDeProvas.size();
        context.setVariable("quantidade", quantidade);
        context.setVariable("tokens", tokens);

        return templateEngine.process("EmailCrescerHTML", context);
    }
}
