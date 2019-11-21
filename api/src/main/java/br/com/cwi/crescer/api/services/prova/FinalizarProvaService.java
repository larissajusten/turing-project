package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRespondidaRequest;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.enums.TipoDeQuestao;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.services.respostaprova.ResponderQuestaoDissertativaService;
import br.com.cwi.crescer.api.services.respostaprova.ResponderQuestaoMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.respostaprova.ResponderQuestaoTecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalizarProvaService {

    @Autowired
    private FinalizarTempoDaProvaService finalizarTempoDaProvaService;

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @Autowired
    private ResponderQuestaoDissertativaService responderQuestaoDissertativaService;

    @Autowired
    private ResponderQuestaoTecnicaService responderQuestaoTecnicaService;

    @Autowired
    private ResponderQuestaoMultiplaEscolhaService responderQuestaoMultiplaEscolhaService;

    public StatusProva finalizar(Long idProva, List<ProvaRespondidaRequest> request) {
        Prova prova = buscarProvaPorIdService.buscar(idProva);

        for (ProvaRespondidaRequest resposta : request) {
            if (resposta.getTipoDeQuestao().equals(TipoDeQuestao.DISSERTATIVA)) {
                responderQuestaoDissertativaService.responder(prova, resposta.getIdQuestao(), resposta.getResposta());
            } else if (resposta.getTipoDeQuestao().equals(TipoDeQuestao.MULTIPLA)) {
                Long idAlternativa = Long.valueOf(resposta.getResposta());
                responderQuestaoMultiplaEscolhaService.responder(prova, resposta.getIdQuestao(), idAlternativa);
            } else if (resposta.getTipoDeQuestao().equals(TipoDeQuestao.TECNICA)) {
                responderQuestaoTecnicaService.responder(prova, resposta.getIdQuestao(), resposta.getResposta());
            }
        }

        return finalizarTempoDaProvaService.finalizar(idProva);
    }

}
