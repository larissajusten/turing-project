package br.com.cwi.crescer.api.services.questaoTecnicaService;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ListarQuestoesTecnicasService {

    @Autowired
    private BuscarQuestaoTecnicaPorIdService buscarQuestaoTecnicaService;

    @Autowired
    private BuscarQuestaoTecnicaPorNivelEEspecificidadeService buscarQuestaoTecnicaPorNivelEEspecificidadeService;

    public List<QuestaoTecnica> buscar(BuscaQuestoesRequest request){
        List<QuestaoTecnica> lista = new ArrayList<>();

        List<QuestaoTecnica> listaQueAtendeRequisitos = buscarQuestaoTecnicaPorNivelEEspecificidadeService.buscar(
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
