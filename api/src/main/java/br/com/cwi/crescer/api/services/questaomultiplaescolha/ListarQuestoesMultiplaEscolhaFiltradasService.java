package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.validator.QuestaoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ListarQuestoesMultiplaEscolhaFiltradasService {

    @Autowired
    private QuestaoValidator validator;

    @Autowired
    private BuscarQuestoesMultiplaEscolhaFiltradasService BuscarQuestoesMultiplaEscolhaFiltradasService;

    @Autowired
    private BuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService buscarQuestaoMultiplaEscolha;

    public List<QuestaoMultiplaEscolha> listar(BuscaQuestoesRequest request) {
        List<QuestaoMultiplaEscolha> lista = new ArrayList<>();

        List<QuestaoMultiplaEscolha> listaQueAtendeRequisitos = buscarQuestaoMultiplaEscolha
                .buscar(request.getEspecificidade(), request.getNivelDeDificuldade(), request.getQuantidadeDeQuestoes());

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

    public Page<QuestaoMultiplaEscolha> listarPaginado(BuscaQuestoesRequest request, Pageable pageable) {
        Page<QuestaoMultiplaEscolha> lista = new PageImpl<>(Collections.emptyList());

        List<QuestaoMultiplaEscolha> listaQueAtendeRequisitos = BuscarQuestoesMultiplaEscolhaFiltradasService
                .buscar(request.getEspecificidade(), request.getNivelDeDificuldade());

        validator.validar(listaQueAtendeRequisitos.size(), request.getQuantidadeDeQuestoes());

        Collections.shuffle(listaQueAtendeRequisitos, new Random());

        int quant = request.getQuantidadeDeQuestoes();
        int cont = 0;
        while (cont < quant) {
            lista.getContent().add(listaQueAtendeRequisitos.get(cont));
            cont++;
        }
        return lista;
    }
}
