package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcularNumeroDeAcertosMultiplaEscolhaService {

    @Autowired
    private RespostaMultiplaEscolhaRepository repository;


    public int calcular(Long idProva) {
        int corretas = 0;

        List<RespostasMultiplaEscolhaProva> listaRespostas = repository.findAllByProvaIdEquals(idProva);

        for (RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva : listaRespostas) {
            AlternativaMultiplaEscolha alternativaEscolhida = respostasMultiplaEscolhaProva.getAlternativaMultiplaEscolha();

            if (alternativaEscolhida.isRespostaCorreta()) {
                corretas++;
            }
        }

        return corretas;
    }

}
