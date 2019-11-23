package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.security.LoggedUser;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdService;
import br.com.cwi.crescer.api.services.questaodissertativa.BuscarQuestaoDissertativaPorIdService;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPeloEmailService;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPorIdService;
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

    @Autowired
    private LoggedUser loggedUser;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    public RespostasDissertativaProva responder(Prova prova, Long idQuestao, String resposta) {


        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();
        respostasDissertativaProva.setResposta(resposta);

        //TODO mudar quando tiver usuário
        Usuario usuario = buscarUsuarioPeloEmailService.buscar(loggedUser.getLogin());
        respostasDissertativaProva.setUsuario(usuario);

        respostasDissertativaProva.setProva(prova);

        QuestaoDissertativa questaoDissertativa = buscarQuestaoDissertativaPorIdService.buscar(idQuestao);
        respostasDissertativaProva.setQuestaoDissertativa(questaoDissertativa);



        return repository.save(respostasDissertativaProva);
    }
}
