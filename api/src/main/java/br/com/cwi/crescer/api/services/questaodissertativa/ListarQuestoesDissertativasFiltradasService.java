package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
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
public class ListarQuestoesDissertativasFiltradasService {

    @Autowired
    private QuestaoValidator validator;

    @Autowired
    private BuscarQuestaoDissertativaPorEspecificidadeENivelService buscarQuestaoDissertativaPorEspecificidadeENivelService;

    public Page<QuestaoDissertativa> listarPaginado(Pageable pageable, BuscaQuestoesRequest request) {
        Page<QuestaoDissertativa> lista = new PageImpl<>(Collections.emptyList());

        Page<QuestaoDissertativa> listaQueAtendeRequisitos = buscarQuestaoDissertativaPorEspecificidadeENivelService
                .buscarPaginado(request.getEspecificidade(), request.getNivelDeDificuldade(), pageable);

        validator.validar(listaQueAtendeRequisitos.getContent().size(), request.getQuantidadeDeQuestoes());

        Collections.shuffle(listaQueAtendeRequisitos.getContent(), new Random());

        int quant = request.getQuantidadeDeQuestoes();
        int cont = 0;

        while (cont < quant) {
            lista.getContent().add(listaQueAtendeRequisitos.getContent().get(cont));
            cont++;
        }

        return lista;
    }

    public List<QuestaoDissertativa> listarSemPaginar(BuscaQuestoesRequest request) {
        List<QuestaoDissertativa> lista = new ArrayList<>();

        List<QuestaoDissertativa> listaQueAtendeRequisitos = buscarQuestaoDissertativaPorEspecificidadeENivelService
                .buscarListado(request.getEspecificidade(), request.getNivelDeDificuldade());

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
