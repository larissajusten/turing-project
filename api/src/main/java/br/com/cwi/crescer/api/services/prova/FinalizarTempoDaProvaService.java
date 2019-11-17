package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

@Service
public class FinalizarTempoDaProvaService {

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @Autowired
    private ProvaRepository repository;

    public StatusProva finalizar(Long idProva){
        Prova prova = buscarProvaPorIdService.buscar(idProva);
        LocalDateTime agora = LocalDateTime.now();

        if(Duration.between(prova.getDataInicio(), agora).toMinutes() > prova.getTempoDeDuracaoDaProva() ){
            prova.setStatus(StatusProva.FORA_DO_PRAZO_DE_DURACAO);
        } else {
            prova.setStatus(StatusProva.AGUARDANDO_CORRECAO);
        }

        repository.save(prova);

        return prova.getStatus();
    }

}
