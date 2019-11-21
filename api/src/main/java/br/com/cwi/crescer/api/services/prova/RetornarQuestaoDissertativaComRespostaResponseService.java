package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetornarQuestaoDissertativaComRespostaResponseService {

    @Autowired
    private RespostasDissertativaRepository respostasDissertativaRepository;

    public List<QuestaoDissertativaComRespostaResponse> buscar(Prova prova) {
        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();

        respostasDissertativaRepository.findAllByProvaIdEquals(prova.getId())
                .forEach(questao -> {
                    QuestaoDissertativaComRespostaResponse questaoDissertativaComRespostaResponse =
                            new QuestaoDissertativaComRespostaResponse();

                    questaoDissertativaComRespostaResponse.setIdQuestao(questao.getQuestaoDissertativa().getId());
                    questaoDissertativaComRespostaResponse.setNota(questao.getNota());
                    questaoDissertativaComRespostaResponse.setQuestao(questao.getQuestaoDissertativa().getQuestao());
                    questaoDissertativaComRespostaResponse.setResposta(questao.getResposta());

                    questaoDissertativa.add(questaoDissertativaComRespostaResponse);
                });

        return questaoDissertativa;
    }
}
