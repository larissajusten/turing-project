package br.com.cwi.crescer.api.services.email;

import br.com.cwi.crescer.api.domain.enums.Perfil;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

public class JwtTokenProviderTest {
    private JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();

    @Test
    public void deveGerarToken() {
        String resultado = jwtTokenProvider.generateToken(new Prova(1L, LocalDateTime.of(2019, Month.NOVEMBER, 28, 10, 18, 7), LocalDateTime.of(2019, Month.NOVEMBER, 28, 10, 18, 7), "emailCandidato", 0, 0, StatusProva.ATIVA, 0d, "nomeCandidato", new Usuario(1L, "email", Perfil.ADMINISTRADOR)));
        Assert.assertNotEquals(null, resultado);
    }

    @Test
    public void deveGerarTokensDiferentesComSecretESem() {
        String resultadoComJWTSecret = JwtTokenProvider.generate(1L, "jwtSecret", new Prova(1L, LocalDateTime.of(2019, Month.NOVEMBER, 28, 10, 18, 7), LocalDateTime.of(2019, Month.NOVEMBER, 28, 10, 18, 7), "emailCandidato", 0, 0, StatusProva.ATIVA, 0d, "nomeCandidato", new Usuario(1L, "email", Perfil.ADMINISTRADOR)));
        String resultadoSemJWTSecret = jwtTokenProvider.generateToken(new Prova(1L, LocalDateTime.of(2019, Month.NOVEMBER, 28, 10, 18, 7), LocalDateTime.of(2019, Month.NOVEMBER, 28, 10, 18, 7), "emailCandidato", 0, 0, StatusProva.ATIVA, 0d, "nomeCandidato", new Usuario(1L, "email", Perfil.ADMINISTRADOR)));

        Assert.assertNotEquals(resultadoSemJWTSecret, resultadoComJWTSecret);
    }

}