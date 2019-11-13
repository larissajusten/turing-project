package br.com.cwi.crescer.api.services.QuestaoTecnicaService;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesTecnicasRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
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

    public List<QuestaoTecnica> buscar(BuscaQuestoesTecnicasRequest buscaQuestoes){
        List<QuestaoTecnica> lista = new ArrayList<>();

        List<QuestaoTecnica> listaQueAtendeRequisitos = buscarQuestaoTecnicaPorNivelEEspecificidadeService.buscar(
                buscaQuestoes.getEspecificidade(), buscaQuestoes.getNivelDeDificuldade());

        Collections.shuffle(listaQueAtendeRequisitos, new Random());

        int quant = buscaQuestoes.getQuantidadeDeQuestoes();
        int cont = 0;
        while(cont < quant){
            lista.add(listaQueAtendeRequisitos.get(cont));
            cont++;
        }

        return lista;
    }
}
