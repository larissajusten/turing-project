package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.responses.LinguagensResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.questaodissertativa.BuscarNumeroDeVezesQuestoesDissertativaPorEspecificidadeService;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.BuscarNumeroDeVezesQuestoesMultiplaPorEspecificidadeService;
import br.com.cwi.crescer.api.services.questaotecnica.BuscarNumeroDeVezesQuestoesTecnicasPorEspecificidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetornaTotalPorLinguagemService {

    @Autowired
    private BuscarNumeroDeVezesQuestoesDissertativaPorEspecificidadeService buscarNumeroDeVezesQuestoesDissertativaPorEspecificidadeService;

    @Autowired
    private BuscarNumeroDeVezesQuestoesMultiplaPorEspecificidadeService buscarNumeroDeVezesQuestoesMultiplaPorEspecificidadeService;

    @Autowired
    private BuscarNumeroDeVezesQuestoesTecnicasPorEspecificidadeService buscarNumeroDeVezesQuestoesTecnicasPorEspecificidadeService;


    public int retornar(Especificidade especificidade){
       int numeroTotal = 0;

       numeroTotal += buscarNumeroDeVezesQuestoesDissertativaPorEspecificidadeService.buscar(especificidade);
       numeroTotal += buscarNumeroDeVezesQuestoesMultiplaPorEspecificidadeService.buscar(especificidade);
       numeroTotal += buscarNumeroDeVezesQuestoesTecnicasPorEspecificidadeService.buscar(especificidade);

       return numeroTotal;
    }

}
