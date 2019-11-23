package br.com.cwi.crescer.api.security;

import br.com.cwi.crescer.api.domain.prova.Prova;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import static java.lang.Long.parseLong;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

@Component
public class JwtTokenProvider {


    private String jwtSecret = "cwi-turing";

    // cria token a partir de um usuário autenticado
    public String generateToken(Prova prova) {

        Long provaId = prova.getId();

        return generate(provaId, jwtSecret, prova);
    }

    public static String generate(final Long provaId, final String jwtSecret, final Prova prova) {

        Long nowMili = System.currentTimeMillis();
        Long provaExpiration = Long.valueOf((prova.getTempoParaInicioProva() * 3600) * 1000);
        Date expiryDate = new Date(nowMili + provaExpiration);
        Date now = new Date();

        return Jwts.builder()
                .setSubject(Long.toString(provaId))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)

                .compact();
    }

    // obtém id do usuário a partir de um token
    public Optional<Long> getUserId(String jwt) {
        try {
            Claims claims = parse(jwt).getBody();

            return ofNullable(parseLong(claims.getSubject()));
        } catch (Exception ex) {
            return empty();
        }
    }

    private Jws<Claims> parse(String jwt) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt);
    }
}
