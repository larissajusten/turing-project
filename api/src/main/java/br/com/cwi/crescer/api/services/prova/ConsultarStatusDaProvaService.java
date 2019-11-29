package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultarStatusDaProvaService {

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    public StatusProva consultar(Long idProva) {

        Prova prova = buscarProvaPorIdService.buscar(idProva);
        return prova.getStatus();
    }
}
