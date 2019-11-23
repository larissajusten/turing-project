package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarDuracaoDaProvaService {

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    public int buscar(Long id) {

        Prova prova = buscarProvaPorIdService.buscar(id);

        return prova.getTempoDeDuracaoDaProva();
    }

}
