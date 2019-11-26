package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaResponse;
import br.com.cwi.crescer.api.exception.prova.ProvaNaoEncontradaException;
import br.com.cwi.crescer.api.services.email.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarProvaPorTokenComQuestoesService {

    @Autowired
    private BuscarProvaPorIdComQuestoesService buscarProvaPorIdComQuestoesService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public ProvaResponse buscar(String token) {

        Long idProva = jwtTokenProvider.getProvaId(token).orElseThrow(()->
                new ProvaNaoEncontradaException("Prova não encontrada"));

        return buscarProvaPorIdComQuestoesService.buscar(idProva);
    }

}
