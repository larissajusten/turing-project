package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.dto.NotasDTO;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerarNotaDasQuestoesDissertativaDeAcordoComPesoService {

    private static final int MULTIPLICADOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_MEDIO = 2;
    private static final int MULTIPLICADOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_DIFICIL = 3;
    @Autowired
    private RespostasDissertativaRepository respostasDissertativaProva;

    public double gerar(Prova prova) {

        int divisor = 0;
        double nota = 0;

        NotasDTO notaQuestoesFaceis = respostasDissertativaProva.buscarQuestoesDissertativasPorProvaENivelDeDificuldade(prova.getId(), NivelDeDificuldade.FACIL);
        if (notaQuestoesFaceis != null) {
            nota += notaQuestoesFaceis.getNota();
            divisor += notaQuestoesFaceis.getQuantidadeDeQuestoes();
        }

        NotasDTO notaQuestoesMedias = respostasDissertativaProva.buscarQuestoesDissertativasPorProvaENivelDeDificuldade(prova.getId(), NivelDeDificuldade.MEDIO);
        if (notaQuestoesMedias != null) {
            nota += calcularNotaPorNivelDeDificuldade(notaQuestoesMedias.getNota(), NivelDeDificuldade.MEDIO);
            divisor += mutiplicarODivisorPorNivelDeDificuldade(notaQuestoesMedias.getQuantidadeDeQuestoes(), NivelDeDificuldade.MEDIO);
        }


        NotasDTO notaQuestoesDificeis = respostasDissertativaProva.buscarQuestoesDissertativasPorProvaENivelDeDificuldade(prova.getId(), NivelDeDificuldade.DIFICIL);
        if (notaQuestoesDificeis != null) {
            nota += calcularNotaPorNivelDeDificuldade(notaQuestoesDificeis.getNota(), NivelDeDificuldade.DIFICIL);
            divisor += mutiplicarODivisorPorNivelDeDificuldade(notaQuestoesDificeis.getQuantidadeDeQuestoes(), NivelDeDificuldade.DIFICIL);
        }

        return (nota != 0 && divisor != 0) ? nota / divisor : 0;

    }

    private double calcularNotaPorNivelDeDificuldade(double nota, NivelDeDificuldade nivelDeDificuldade) {


        if (nivelDeDificuldade.equals(NivelDeDificuldade.MEDIO)) {
            return nota * MULTIPLICADOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_MEDIO;
        }
        return nota * MULTIPLICADOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_DIFICIL;
    }

    private long mutiplicarODivisorPorNivelDeDificuldade(long divisor, NivelDeDificuldade nivelDeDificuldade) {

        if (nivelDeDificuldade.equals(NivelDeDificuldade.MEDIO)) {
            return divisor * MULTIPLICADOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_MEDIO;
        }
        return divisor * MULTIPLICADOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_DIFICIL;
    }
}
