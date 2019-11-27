package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcularNumeroDeAcertosMultiplaEscolhaService {

    public int calcular(List<RespostasMultiplaEscolhaProva> listaRespostas) {

        int corretas = 0;

        for (RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva : listaRespostas) {
            AlternativaMultiplaEscolha alternativaEscolhida = respostasMultiplaEscolhaProva.getAlternativaMultiplaEscolha();

            if (alternativaEscolhida.isRespostaCorreta()) {
                corretas++;
            }
        }
        return corretas;
    }
}
