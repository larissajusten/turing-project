package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IniciarTempoDaProvaService {

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @Autowired
    private ProvaRepository repository;

    public void iniciar(Long idProva) {
        Prova prova = buscarProvaPorIdService.buscar(idProva);
        prova.setDataInicio(LocalDateTime.now());

        repository.save(prova);
    }

}
