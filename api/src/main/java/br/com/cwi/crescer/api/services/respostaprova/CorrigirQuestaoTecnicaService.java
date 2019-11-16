package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.requests.questoes.CorrecaoProvaRequest;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.exception.ValidacaoDeAplicacaoException;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorrigirQuestaoTecnicaService {


    @Autowired
    private RespostasTecnicaRepository repository;

    public void corrigir(Long idResposta, CorrecaoProvaRequest correcao){
        RespostasTecnicaProva resposta =  repository.findById(idResposta)
                .orElseThrow(() -> new ValidacaoDeAplicacaoException("Não foi encontrada a resposta"));

        resposta.setNota(correcao.getNota());
        resposta.setComentario(correcao.getComentario());

        repository.save(resposta);
    }
}
