package br.com.cwi.crescer.api.services.questaoDissertativaService;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ListarQuestoesDissertativasFiltradas {

    @Autowired
    private BuscarQuestaoDissertativaPorEspecificidadeENivelService buscarQuestaoDissertativaPorEspecificidadeENivelService;

    public List<QuestaoDissertativa> listar(BuscaQuestoesRequest request){
        List<QuestaoDissertativa> lista = new ArrayList<>();

        List<QuestaoDissertativa> listaQueAtendeRequisitos = buscarQuestaoDissertativaPorEspecificidadeENivelService.buscar(
                request.getEspecificidade(), request.getNivelDeDificuldade());

        Collections.shuffle(listaQueAtendeRequisitos, new Random());

        int quant = request.getQuantidadeDeQuestoes();
        int cont = 0;
        while(cont < quant){
            lista.add(listaQueAtendeRequisitos.get(cont));
            cont++;
        }
        return lista;
    }
}
