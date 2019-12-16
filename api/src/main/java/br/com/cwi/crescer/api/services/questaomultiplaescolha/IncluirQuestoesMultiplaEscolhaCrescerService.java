package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorCriadaECrescerService;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdComQuestoesService;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdService;
import br.com.cwi.crescer.api.services.questaodissertativa.AcrescentarQuantasVezesUsadaQuestaoDissertativaService;
import br.com.cwi.crescer.api.services.questaodissertativa.ListarQuestoesDissertativasFiltradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncluirQuestoesMultiplaEscolhaCrescerService {

    @Autowired
    private ListarQuestoesMultiplaEscolhaFiltradasService listarQuestoesMultiplaEscolhaFiltradasService;

    @Autowired
    private BuscarProvaPorCriadaECrescerService buscarProvaPorCriadaECrescerService;

    @Autowired
    private ProvaQuestaoMultiplaEscolhaRepository repository;

    @Autowired
    private AcrescentarQuantasVezesUsadaQuestaoMultiplaEscolhaService acrescentarQuantasVezesUsadaQuestaoMultiplaEscolhaService;


    public void incluir(BuscaQuestoesRequest request) {
        List<QuestaoMultiplaEscolha> lista = listarQuestoesMultiplaEscolhaFiltradasService.listar(request);

        List<Prova> listaDeProvas = buscarProvaPorCriadaECrescerService.buscar();

        for (Prova prova: listaDeProvas) {
            for (QuestaoMultiplaEscolha questaoMultiplaEscolha : lista) {
                ProvaQuestaoMultiplaEscolha provaQuestaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();
                provaQuestaoMultiplaEscolha.setProva(prova);
                acrescentarQuantasVezesUsadaQuestaoMultiplaEscolhaService.acrescentar(lista);
                provaQuestaoMultiplaEscolha.setQuestao(questaoMultiplaEscolha);
                repository.save(provaQuestaoMultiplaEscolha);
            }
        }

    }
}
