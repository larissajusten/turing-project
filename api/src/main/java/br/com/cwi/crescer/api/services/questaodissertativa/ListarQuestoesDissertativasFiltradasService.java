package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ListarQuestoesDissertativasFiltradasService {

    private static final int TAMANHO_PARA_LANCAR_EXCEPTION_LISTA = 0;

    @Autowired
    private BuscarQuestaoDissertativaPorEspecificidadeENivelService buscarQuestaoDissertativaPorEspecificidadeENivelService;

    public List<QuestaoDissertativa> listar(BuscaQuestoesRequest request){
        List<QuestaoDissertativa> lista = new ArrayList<>();

        List<QuestaoDissertativa> listaQueAtendeRequisitos = buscarQuestaoDissertativaPorEspecificidadeENivelService
                .buscar(request.getEspecificidade(), request.getNivelDeDificuldade());

        if (listaQueAtendeRequisitos.size() == TAMANHO_PARA_LANCAR_EXCEPTION_LISTA) {
            throw new QuestaoNaoEncontradaException("Nenhuma questão com essa especificidade e nivel de dificuldade foi encontrada.");
        }

        Collections.shuffle(listaQueAtendeRequisitos, new Random());

        //TODO colocar exception quando a lista não tiver nada
        int quant = request.getQuantidadeDeQuestoes();
        int cont = 0;

        while(cont < quant){
            lista.add(listaQueAtendeRequisitos.get(cont));
            cont++;
        }

        return lista;
    }
}
