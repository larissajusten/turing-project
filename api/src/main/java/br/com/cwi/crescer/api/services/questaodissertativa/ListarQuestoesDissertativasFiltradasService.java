package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.validator.QuestaoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ListarQuestoesDissertativasFiltradasService {

    @Autowired
    private QuestaoValidator validator;

    @Autowired
    private BuscarQuestaoDissertativaPorEspecificidadeENivelService buscarQuestaoDissertativaPorEspecificidadeENivelService;

    public List<QuestaoDissertativa> listar(BuscaQuestoesRequest request) {

        List<QuestaoDissertativa> listaQueAtendeRequisitos = buscarQuestaoDissertativaPorEspecificidadeENivelService
                .buscar(request.getEspecificidade(), request.getNivelDeDificuldade(), request.getQuantidadeDeQuestoes());

        validator.validar(listaQueAtendeRequisitos.size(), request.getQuantidadeDeQuestoes());

        return listaQueAtendeRequisitos;
    }
}
