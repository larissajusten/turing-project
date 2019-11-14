package br.com.cwi.crescer.api.services.questaoTecnicaService;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.services.questaoDissertativaService.BuscarQuestaoDissertativaPorEspecificidadeENivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarTodasQuestoesTecnicasFiltradasService {

    @Autowired
   private BuscarQuestoesTecnicasFiltradasService buscarQuestoesTecnicasFiltradasService;

    public List<QuestaoTecnica> buscar(BuscaQuestoesRequest request){
        return buscarQuestoesTecnicasFiltradasService.buscar(
                request.getEspecificidade(), request.getNivelDeDificuldade());
    }
}
