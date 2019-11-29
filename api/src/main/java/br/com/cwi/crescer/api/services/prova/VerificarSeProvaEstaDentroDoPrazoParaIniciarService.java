package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class VerificarSeProvaEstaDentroDoPrazoParaIniciarService {


    public boolean verificar(Prova prova) {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime criacao = prova.getDataCriacao();
        int horasParaIniciar = prova.getTempoParaInicioProva();

        if (Duration.between(criacao, agora).toHours() > horasParaIniciar) {
            prova.setStatus(StatusProva.FORA_DO_PRAZO_PARA_REALIZAR_PROVA);
        }

        return Duration.between(criacao, agora).toHours() <= horasParaIniciar;
    }
}
