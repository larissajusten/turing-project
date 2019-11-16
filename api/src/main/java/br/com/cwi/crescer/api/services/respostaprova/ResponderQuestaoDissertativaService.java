package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdService;
import br.com.cwi.crescer.api.services.questaodissertativa.BuscarQuestaoDissertativaPorIdService;
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

    public RespostasDissertativaProva responder(Long idProva, Long idQuestao, String resposta){
        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();
        respostasDissertativaProva.setResposta(resposta);

        Prova prova = buscarProvaPorIdService.buscar(idProva);
        respostasDissertativaProva.setProva(prova);

        QuestaoDissertativa questaoDissertativa = buscarQuestaoDissertativaPorIdService.buscar(idQuestao);
        respostasDissertativaProva.setQuestaoDissertativa(questaoDissertativa);

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        respostasDissertativaProva.setUsuario(usuario);

        return repository.save(respostasDissertativaProva);
    }
}
