package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.exception.prova.CorrecaoNaoCompletadaException;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CorrecaoValidator {

    @Autowired
    private RespostasDissertativaRepository respostasDissertativaRepository;

    @Autowired
    private RespostasTecnicaRepository respostasTecnicaRepository;

    public void validar(Long idProva) {

        boolean todasCorrigidas = true;
        List<RespostasTecnicaProva> listaTecnicas = respostasTecnicaRepository.findAllByProvaIdEquals(idProva);
        List<RespostasDissertativaProva> listaDissertativas = respostasDissertativaRepository.findAllByProvaIdEquals(idProva);

        for (RespostasTecnicaProva respostasTecnicaProva : listaTecnicas) {
            if (respostasTecnicaProva.getComentario() == null) {
                todasCorrigidas = false;
                break;
            }
        }

        for (RespostasDissertativaProva respostasDissertativaProva : listaDissertativas) {
            if (respostasDissertativaProva.getComentario() == null) {
                todasCorrigidas = false;
                break;
            }
        }

        if (!todasCorrigidas) {
            throw new CorrecaoNaoCompletadaException("Correções feitas salvas, porém nem todas as questões" +
                    "dessa prova foram corrigidas.");
        }
    }
}
