package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ListarQuestoesMultiplaEscolhaFiltradasService {

    private static final int TAMANHO_PARA_LANCAR_EXCEPTION_LISTA = 0;

    @Autowired
    private BuscarQuestoesMultiplaEscolhaFiltradasService buscarQuestoesMultiplaEscolhaFiltradasService;

    public List<QuestaoMultiplaEscolha> listar(BuscaQuestoesRequest request) {
        List<QuestaoMultiplaEscolha> lista = new ArrayList<>();

        List<QuestaoMultiplaEscolha> listaQueAtendeRequisitos = buscarQuestoesMultiplaEscolhaFiltradasService
                .buscar(request.getEspecificidade(), request.getNivelDeDificuldade());

        //TODO colocar isso em uma validacao e colocar excessao caso o cara peça mais do que tem no banco
        if (listaQueAtendeRequisitos.size() == TAMANHO_PARA_LANCAR_EXCEPTION_LISTA) {
            throw new QuestaoNaoEncontradaException("Nenhuma questão com essa especificidade e nivel de dificuldade foi encontrada.");
        }

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
