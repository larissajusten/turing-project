package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.requests.questoes.CorrecaoProvaRequest;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.exception.ValidacaoDeAplicacaoException;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorrigirQuestaoDissertativaService {


    @Autowired
    private RespostasDissertativaRepository repository;

    public void corrigir(Long idResposta, CorrecaoProvaRequest correcao){
        RespostasDissertativaProva resposta =  repository.findById(idResposta)
                .orElseThrow(() -> new ValidacaoDeAplicacaoException("Não foi encontrada a resposta"));

        resposta.setNota(correcao.getNota());
        resposta.setComentario(correcao.getComentario());

        repository.save(resposta);
    }
}
