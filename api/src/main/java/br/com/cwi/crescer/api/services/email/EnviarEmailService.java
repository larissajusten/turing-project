package br.com.cwi.crescer.api.services.email;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.services.prova.BuscarProvaCriadaPorEmailDoCandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;

@Service
public class EnviarEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JwtTokenProvider jwt;

    @Autowired
    private BuscarProvaCriadaPorEmailDoCandidatoService buscarProvaPorEmail;

    public void enviar(String emailCandidato) {

        Prova prova = buscarProvaPorEmail.buscar(emailCandidato);

        String processedHTMLTemplate = this.constructHTMLTemplate(prova);

        MimeMessagePreparator preparator = message -> {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED, "UTF-8");
            helper.setSubject("CWI TURING TEM UMA PROVA AGUARDANDO VOCÊ!");
            helper.setTo(emailCandidato);
            helper.setText(processedHTMLTemplate, true);
        };

        mailSender.send(preparator);
    }

    private String constructHTMLTemplate(Prova prova) {
        Context context = new Context();

        String nomeCandidato = prova.getNomeCandidato();
        int tempoIniciar = prova.getTempoParaInicioProva();

        LocalDateTime prazo = LocalDateTime.now().plusHours(tempoIniciar);
        String dia = prazo.getDayOfMonth() + "/" + prazo.getMonthValue() + "/" + prazo.getYear();
        String hora = prazo.getHour() + ":" + prazo.getMinute() + ":" + prazo.getMinute();

        int tempoDuracao = prova.getTempoDeDuracaoDaProva();
        String token = jwt.generateToken(prova);

        context.setVariable("nomeCandidato", nomeCandidato);
        context.setVariable("tempoIniciar", tempoIniciar);
        context.setVariable("tempoDuracao", tempoDuracao);
        context.setVariable("dia", dia);
        context.setVariable("hora", hora);
        context.setVariable("token", token);

        return templateEngine.process("EmailHTML", context);
    }
}
