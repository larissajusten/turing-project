package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.exception.prova.ProvaNaoEncontradaException;
import br.com.cwi.crescer.api.security.JwtTokenProvider;
import br.com.cwi.crescer.api.services.provaquestao.BuscarQuestoesDissertativasDeUmaProvaPorIdService;
import br.com.cwi.crescer.api.services.provaquestao.BuscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService;
import br.com.cwi.crescer.api.services.provaquestao.BuscarQuestoesTecnicasDeUmaProvaPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.stereotype.Service;

@Service
public class BuscarProvaPorTokenComQuestoesService {

    @Autowired
    private BuscarProvaPorIdComQuestoesService buscarProvaPorIdComQuestoesService;

    @Autowired
    br.com.cwi.crescer.api.security.JwtTokenProvider JwtTokenProvider;

    public ProvaResponse buscar(String token) {

        Long idProva = JwtTokenProvider.getUserId(token).orElseThrow(()->
                new ProvaNaoEncontradaException("Prova não encontrada"));

        return buscarProvaPorIdComQuestoesService.buscar(idProva);
    }

}
