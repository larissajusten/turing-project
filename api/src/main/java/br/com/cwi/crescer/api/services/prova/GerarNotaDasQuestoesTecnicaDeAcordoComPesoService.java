package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.dto.NotasDTO;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerarNotaDasQuestoesTecnicaDeAcordoComPesoService {

    @Autowired
    private RespostasTecnicaRepository respostasTecnicaProva;

    private static final int MULTIPLICADOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_MEDIO = 2;
    private static final int MULTIPLICADOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_DIFICIL = 3;

    public double gerar(Prova prova) {

        int divisor = 0;
        double nota = 0;

        NotasDTO notaQuestoesFaceis = respostasTecnicaProva.buscarQuestoesTecnicasFiltradasPorNivelEPorProva(prova, NivelDeDificuldade.FACIL);
        nota += notaQuestoesFaceis.getNota();
        divisor += notaQuestoesFaceis.getQuantidadeDeQuestoes();

        NotasDTO notaQuestoesMedias = respostasTecnicaProva.buscarQuestoesTecnicasFiltradasPorNivelEPorProva(prova, NivelDeDificuldade.MEDIO);
        nota += calcularNotaPorNivelDeDificuldade(notaQuestoesMedias.getNota(), NivelDeDificuldade.MEDIO);
        divisor += mutiplicarODivisorPorNivelDeDificuldade(notaQuestoesMedias.getQuantidadeDeQuestoes(), NivelDeDificuldade.MEDIO);

        NotasDTO notaQuestoesDificeis = respostasTecnicaProva.buscarQuestoesTecnicasFiltradasPorNivelEPorProva(prova, NivelDeDificuldade.DIFICIL);
        nota += calcularNotaPorNivelDeDificuldade(notaQuestoesDificeis.getNota(), NivelDeDificuldade.DIFICIL);
        divisor += mutiplicarODivisorPorNivelDeDificuldade(notaQuestoesDificeis.getQuantidadeDeQuestoes(), NivelDeDificuldade.DIFICIL);

        return nota / divisor;
    }

    private double calcularNotaPorNivelDeDificuldade(double nota, NivelDeDificuldade nivelDeDificuldade) {

        if (nivelDeDificuldade.equals(NivelDeDificuldade.MEDIO)) {
            return nota * MULTIPLICADOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_MEDIO;
        }
        return nota * MULTIPLICADOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_DIFICIL;
    }

    private Long mutiplicarODivisorPorNivelDeDificuldade(Long divisor, NivelDeDificuldade nivelDeDificuldade) {

        if (nivelDeDificuldade.equals(NivelDeDificuldade.MEDIO)) {
            return divisor * MULTIPLICADOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_MEDIO;
        }
        return divisor * MULTIPLICADOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_DIFICIL;
    }

}
