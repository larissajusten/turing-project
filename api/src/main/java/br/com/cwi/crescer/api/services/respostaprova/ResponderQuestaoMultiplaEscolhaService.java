package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.BuscarAlternativaMultiplaEscolhaPorIdService;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdService;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.BuscarQuestaoMultiplaEscolhaPorIdService;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponderQuestaoMultiplaEscolhaService {

    @Autowired
    private RespostaMultiplaEscolhaRepository repository;

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @Autowired
    private BuscarQuestaoMultiplaEscolhaPorIdService buscarQuestaoMultiplaEscolhaPorIdService;

    @Autowired
    private BuscarAlternativaMultiplaEscolhaPorIdService buscarAlternativaMultiplaEscolhaPorIdService;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    public RespostasMultiplaEscolhaProva responder(Prova prova, Long idQuestao, Long idAlternativa) {

        AlternativaMultiplaEscolha alternativaMultiplaEscolha = buscarAlternativaMultiplaEscolhaPorIdService.buscar(idAlternativa);
        QuestaoMultiplaEscolha questaoMultiplaEscolha = buscarQuestaoMultiplaEscolhaPorIdService.buscar(idQuestao);

        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();
        respostasMultiplaEscolhaProva.setAlternativaMultiplaEscolha(alternativaMultiplaEscolha);
        respostasMultiplaEscolhaProva.setQuestaoMultiplaEscolha(questaoMultiplaEscolha);
        respostasMultiplaEscolhaProva.setProva(prova);

        return repository.save(respostasMultiplaEscolhaProva);
    }

}
