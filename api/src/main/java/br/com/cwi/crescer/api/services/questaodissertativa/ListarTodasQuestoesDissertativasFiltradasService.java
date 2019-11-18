package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarTodasQuestoesDissertativasFiltradasService {

    @Autowired
    private BuscarQuestaoDissertativaPorEspecificidadeENivelService buscarQuestaoDissertativaPorEspecificidadeENivelService;

    public List<QuestaoDissertativa> listar(BuscaQuestoesRequest request) {
        return buscarQuestaoDissertativaPorEspecificidadeENivelService.buscar(
                request.getEspecificidade(), request.getNivelDeDificuldade());
    }
}
