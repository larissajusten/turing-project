package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdService;
import br.com.cwi.crescer.api.services.questaodissertativa.BuscarQuestaoDissertativaPorIdService;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPeloEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponderQuestaoDissertativaService {

    @Autowired
    private RespostasDissertativaRepository repository;

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @Autowired
    private BuscarQuestaoDissertativaPorIdService buscarQuestaoDissertativaPorIdService;

    @Autowired
    private BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    public RespostasDissertativaProva responder(Prova prova, Long idQuestao, String resposta) {

        QuestaoDissertativa questaoDissertativa = buscarQuestaoDissertativaPorIdService.buscar(idQuestao);

        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();
        respostasDissertativaProva.setQuestaoDissertativa(questaoDissertativa);
        respostasDissertativaProva.setResposta(resposta);
        respostasDissertativaProva.setProva(prova);

        return repository.save(respostasDissertativaProva);
    }

}
