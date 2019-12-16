package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.requests.prova.CandidatoRequest;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IniciarTempoDaProvaCrescerService {

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @Autowired
    private ProvaRepository repository;

    public void iniciar(Long idProva,  CandidatoRequest request) {

        Prova prova = buscarProvaPorIdService.buscar(idProva);
        prova.setNomeCandidato(request.getNomeCandidato());
        prova.setEmailCandidato(request.getEmail());
        prova.setDataInicio(LocalDateTime.now());
        prova.setStatus(StatusProva.ATIVA);

        repository.save(prova);
    }
}
