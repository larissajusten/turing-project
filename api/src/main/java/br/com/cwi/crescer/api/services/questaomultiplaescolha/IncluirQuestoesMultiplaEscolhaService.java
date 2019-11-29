package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncluirQuestoesMultiplaEscolhaService {

    @Autowired
    private ListarQuestoesMultiplaEscolhaFiltradasService listarQuestoesMultiplaEscolhaFiltradasService;

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorId;

    @Autowired
    private ProvaQuestaoMultiplaEscolhaRepository repository;

    @Autowired
    private AcrescentarQuantasVezesUsadaQuestaoMultiplaEscolhaService acrescentarQuantasVezesUsadaQuestaoMultiplaEscolhaService;

    public void incluir(Long idProva, BuscaQuestoesRequest request) {

        Prova prova = buscarProvaPorId.buscar(idProva);
        List<QuestaoMultiplaEscolha> lista = listarQuestoesMultiplaEscolhaFiltradasService.listar(request);
        acrescentarQuantasVezesUsadaQuestaoMultiplaEscolhaService.acrescentar(lista);

        for (QuestaoMultiplaEscolha questaoMultiplaEscolha : lista) {
            ProvaQuestaoMultiplaEscolha provaQuestaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();
            provaQuestaoMultiplaEscolha.setProva(prova);
            provaQuestaoMultiplaEscolha.setQuestao(questaoMultiplaEscolha);
            repository.save(provaQuestaoMultiplaEscolha);
        }
    }
}
