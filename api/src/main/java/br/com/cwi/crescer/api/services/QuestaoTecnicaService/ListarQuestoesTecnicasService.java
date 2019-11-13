package br.com.cwi.crescer.api.services.QuestaoTecnicaService;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesTecnicasRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ListarQuestoesTecnicasService {

    @Autowired
    private QuestaoTecnicaRepository repository;

    @Autowired
    private BuscarQuestaoTecnicaPorIdService buscarQuestaoTecnicaService;

    @Autowired
    private BuscarQuestaoTecnicaPorNivelEEspecificidadeService buscarQuestaoTecnicaPorNivelEEspecificidadeService;

    public List<QuestaoTecnica> buscar(BuscaQuestoesTecnicasRequest buscaQuestoes){
        List<QuestaoTecnica> lista = new ArrayList<>();
        int quant = buscaQuestoes.getQuantidadeDeQuestoes();
        int cont = 0;
        List<QuestaoTecnica> listaQueAtendeRequisitos = buscarQuestaoTecnicaPorNivelEEspecificidadeService.buscar(
                buscaQuestoes.getEspecificidade(), buscaQuestoes.getNivelDeDificuldade());

        Collections.shuffle(listaQueAtendeRequisitos);

        while(cont <= quant){
            lista.add(listaQueAtendeRequisitos.get(cont));
            cont++;
        }

        return lista;
    }
}
