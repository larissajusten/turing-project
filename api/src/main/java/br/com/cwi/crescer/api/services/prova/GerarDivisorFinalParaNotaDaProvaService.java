package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerarDivisorFinalParaNotaDaProvaService {

    @Autowired
    private ProvaQuestaoDissertativaRepository provaQuestaoDissertativaRepository;

    @Autowired
    private ProvaQuestaoMultiplaEscolhaRepository provaQuestaoMultiplaEscolhaRepository;

    @Autowired
    private ProvaQuestaoTecnicaRepository provaQuestaoTecnicaRepository;

    public int retornarTotalDeQuestoesDaProva(Prova prova) {

        int divisorFinal = 0;

        if (!provaQuestaoDissertativaRepository.findAllByProvaIdEquals(prova.getId()).isEmpty()) {
            divisorFinal += 1;
        }

        if (!provaQuestaoMultiplaEscolhaRepository.findAllByProvaIdEquals(prova.getId()).isEmpty()) {
            divisorFinal += 1;
        }

        if (!provaQuestaoTecnicaRepository.findAllByProvaIdEquals(prova.getId()).isEmpty()) {
            divisorFinal += 1;
        }

        return divisorFinal;
    }
}
