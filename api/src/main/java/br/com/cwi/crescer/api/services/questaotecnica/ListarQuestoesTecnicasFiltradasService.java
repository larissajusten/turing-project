package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import br.com.cwi.crescer.api.validator.QuestaoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ListarQuestoesTecnicasFiltradasService {

    @Autowired
    private BuscarQuestaoTecnicaPorIdService buscarQuestaoTecnicaService;

    @Autowired
    private QuestaoValidator validator;

    @Autowired
    private BuscarQuestoesTecnicasFiltradasService buscarQuestoesTecnicasFiltradasService;

    public List<QuestaoTecnica> listar(BuscaQuestoesRequest request) {
        List<QuestaoTecnica> lista = new ArrayList<>();

        List<QuestaoTecnica> listaQueAtendeRequisitos = buscarQuestoesTecnicasFiltradasService
                .buscar(request.getEspecificidade(), request.getNivelDeDificuldade());

        validator.validar(listaQueAtendeRequisitos.size(), request.getQuantidadeDeQuestoes());

        Collections.shuffle(listaQueAtendeRequisitos, new Random());

        int quant = request.getQuantidadeDeQuestoes();
        int cont = 0;
        while (cont < quant) {
            lista.add(listaQueAtendeRequisitos.get(cont));
            cont++;
        }

        return lista;
    }
}
