package br.com.cwi.crescer.api.services.questaoTecnicaService;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ListarQuestoesTecnicasFiltradasService {

    private final static int TAMANHO_PARA_LANCAR_EXCEPTION_LISTA = 0;

    @Autowired
    private BuscarQuestaoTecnicaPorIdService buscarQuestaoTecnicaService;

    @Autowired
    private BuscarQuestoesTecnicasFiltradasService buscarQuestoesTecnicasFiltradasService;

    public List<QuestaoTecnica> listar(BuscaQuestoesRequest request){
        List<QuestaoTecnica> lista = new ArrayList<>();

        List<QuestaoTecnica> listaQueAtendeRequisitos = buscarQuestoesTecnicasFiltradasService.buscar(
                request.getEspecificidade(), request.getNivelDeDificuldade());

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
