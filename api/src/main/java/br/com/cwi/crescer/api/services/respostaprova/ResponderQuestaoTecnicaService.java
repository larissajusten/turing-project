package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import br.com.cwi.crescer.api.services.questaotecnica.BuscarQuestaoTecnicaPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponderQuestaoTecnicaService {

    @Autowired
    private RespostasTecnicaRepository repository;

    @Autowired
    private BuscarQuestaoTecnicaPorIdService buscarQuestaoTecnicaPorIdService;

    public RespostasTecnicaProva responder(Prova prova, Long idQuestao, String resposta) {

        QuestaoTecnica questaoTecnica = buscarQuestaoTecnicaPorIdService.buscar(idQuestao);

        RespostasTecnicaProva respostasTecnicaProva = new RespostasTecnicaProva();
        respostasTecnicaProva.setQuestaoTecnica(questaoTecnica);
        respostasTecnicaProva.setResposta(resposta);
        respostasTecnicaProva.setProva(prova);

        return repository.save(respostasTecnicaProva);
    }
}
