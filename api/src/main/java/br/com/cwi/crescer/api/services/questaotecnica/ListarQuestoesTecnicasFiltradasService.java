package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.validator.QuestaoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarQuestoesTecnicasFiltradasService {

    @Autowired
    private BuscarQuestaoTecnicaPorIdService buscarQuestaoTecnicaService;

    @Autowired
    private QuestaoValidator validator;

    @Autowired
    private BuscarQuestoesTecnicasFiltradasService buscarQuestoesTecnicasFiltradasService;

    public List<QuestaoTecnica> listar(BuscaQuestoesRequest request) {

        List<QuestaoTecnica> listaQueAtendeRequisitos = buscarQuestoesTecnicasFiltradasService
                .buscar(request.getEspecificidade(), request.getNivelDeDificuldade(), request.getQuantidadeDeQuestoes());

        validator.validar(listaQueAtendeRequisitos.size(), request.getQuantidadeDeQuestoes());

        return listaQueAtendeRequisitos;
    }

}
