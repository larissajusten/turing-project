package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ListarQuestoesMultiplaEscolhaFiltradasService {

    @Autowired
    private BuscarQuestoesMultiplaEscolhaFiltradasService buscarQuestoesMultiplaEscolhaFiltradasService;

    public List<QuestaoMultiplaEscolha> listar(BuscaQuestoesRequest request) {
        List<QuestaoMultiplaEscolha> lista = new ArrayList<>();

        List<QuestaoMultiplaEscolha> listaQueAtendeRequisitos = buscarQuestoesMultiplaEscolhaFiltradasService.buscar(
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
