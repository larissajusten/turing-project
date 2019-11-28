package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerarNotaDasQuestoesMultiplaEscolhaDeAcordoComPesoService {

    @Autowired
    private RespostaMultiplaEscolhaRepository respostaMultiplaEscolhaRepository;

    private double nota = 0;
    private int divisor = 0;

    private static final int NOTA_BASE_QUESTOES_NIVEL_FACIL = 10;
    private static final int NOTA_BASE_QUESTOES_NIVEL_MEDIO = 20;
    private static final int NOTA_BASE_QUESTOES_NIVEL_DIFICIL = 30;

    private static final int MULTIPLICADOR_DO_DIVISOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_MEDIO = 2;
    private static final int MULTIPLICADOR_DO_DIVISOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_DIFICIL = 3;

    public double gerar(Prova prova) {

        Integer quantidadeQuestoesNivelFacil = respostaMultiplaEscolhaRepository
                .buscarQuestoesCorretasDeMultiplaEscolhaPorProvaFiltradasPorNivelDeDificuldade(prova.getId(), NivelDeDificuldade.FACIL);
        if(quantidadeQuestoesNivelFacil != null){
            nota += quantidadeQuestoesNivelFacil * NOTA_BASE_QUESTOES_NIVEL_FACIL;
            divisor += quantidadeQuestoesNivelFacil;
        }

        Integer quantidadeQuestoesNivelMedio = respostaMultiplaEscolhaRepository
                .buscarQuestoesCorretasDeMultiplaEscolhaPorProvaFiltradasPorNivelDeDificuldade(prova.getId(), NivelDeDificuldade.MEDIO);

        if(quantidadeQuestoesNivelMedio != null){
            nota += quantidadeQuestoesNivelMedio * NOTA_BASE_QUESTOES_NIVEL_MEDIO;
            divisor += mutiplicarODivisorPorNivelDeDificuldade(quantidadeQuestoesNivelMedio, NivelDeDificuldade.MEDIO);
        }

        Integer quantidadeQuestoesNivelDificil = respostaMultiplaEscolhaRepository
                .buscarQuestoesCorretasDeMultiplaEscolhaPorProvaFiltradasPorNivelDeDificuldade(prova.getId(), NivelDeDificuldade.DIFICIL);
        if(quantidadeQuestoesNivelMedio != null){
            nota += quantidadeQuestoesNivelDificil * NOTA_BASE_QUESTOES_NIVEL_DIFICIL;
            divisor += mutiplicarODivisorPorNivelDeDificuldade(quantidadeQuestoesNivelDificil, NivelDeDificuldade.DIFICIL);
        }

        if (nota != 0 && divisor != 0){
            return nota / divisor;
        } else {
            return 0;
        }
    }

    private int mutiplicarODivisorPorNivelDeDificuldade(int divisor, NivelDeDificuldade nivelDeDificuldade) {

        if (nivelDeDificuldade.equals(NivelDeDificuldade.MEDIO)) {
            return divisor * MULTIPLICADOR_DO_DIVISOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_MEDIO;
        }
        return divisor * MULTIPLICADOR_DO_DIVISOR_DA_NOTA_POR_NIVEL_DE_DIFICULDADE_DIFICIL;
    }
}


