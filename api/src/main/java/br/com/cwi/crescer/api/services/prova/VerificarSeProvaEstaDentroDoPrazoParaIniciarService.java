package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class VerificarSeProvaEstaDentroDoPrazoParaIniciarService {


    public boolean verificar(Prova prova){
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime criacao = prova.getDataCriacao();
        int horasParaIniciar = prova.getTempoParaInicioProva();

        return Duration.between(agora, criacao).toHours() <= horasParaIniciar;
    }
}
