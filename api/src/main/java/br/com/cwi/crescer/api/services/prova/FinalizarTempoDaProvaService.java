package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinalizarTempoDaProvaService {

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @Autowired
    private ProvaRepository repository;

    public StatusProva finalizar(Long idProva) {

        Prova prova = buscarProvaPorIdService.buscar(idProva);
        prova.setStatus(StatusProva.AGUARDANDO_CORRECAO);

        repository.save(prova);

        return prova.getStatus();
    }
}
