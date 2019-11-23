package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.requests.questoes.CorrecaoProvaRequest;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.validator.NotaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorrigirQuestaoDissertativaService {

    @Autowired
    private RespostasDissertativaRepository repository;

    @Autowired
    private BuscarRespostaDissertativaPorIDService buscarRespostaDissertativaPorIDService;

    @Autowired
    private NotaValidator notaValidator;

    public void corrigir(Long idResposta, CorrecaoProvaRequest correcao) {

        notaValidator.validar(correcao.getNota());
        RespostasDissertativaProva resposta = buscarRespostaDissertativaPorIDService.buscar(idResposta);

        resposta.setNota(correcao.getNota());
        resposta.setComentario(correcao.getComentario());

        repository.save(resposta);
    }

}
