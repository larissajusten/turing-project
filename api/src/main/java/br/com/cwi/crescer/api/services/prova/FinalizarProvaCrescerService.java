package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRespondidaRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
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
public class FinalizarProvaCrescerService {

   @Autowired
   private FinalizarProvaService finalizarProvaService;

   @Autowired
   private BuscarProvaPorIdService buscarProvaPorIdService;

    public StatusProva finalizar(Long idProva, List<ProvaRespondidaRequest> request, Especificidade especificidade) {

        Prova prova = buscarProvaPorIdService.buscar(idProva);
        prova.setEspecificidade(especificidade);

        return finalizarProvaService.finalizar(idProva, request);
    }
}
