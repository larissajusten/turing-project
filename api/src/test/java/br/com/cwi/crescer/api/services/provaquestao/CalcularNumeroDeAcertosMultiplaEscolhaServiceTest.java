package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class CalcularNumeroDeAcertosMultiplaEscolhaServiceTest {

    @InjectMocks
    CalcularNumeroDeAcertosMultiplaEscolhaService calcularNumeroDeAcertosMultiplaEscolhaService;


    @Test
    public void deve() {
        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();
        List<RespostasMultiplaEscolhaProva> listaRespostas = new ArrayList<>();
        AlternativaMultiplaEscolha alternativaEscolhida = new AlternativaMultiplaEscolha();
        listaRespostas.add(respostasMultiplaEscolhaProva);
        alternativaEscolhida.setRespostaCorreta(true);
        respostasMultiplaEscolhaProva.setAlternativaMultiplaEscolha(alternativaEscolhida);

        Mockito.when(respostasMultiplaEscolhaProva.getAlternativaMultiplaEscolha()).thenReturn(alternativaEscolhida);

        calcularNumeroDeAcertosMultiplaEscolhaService.calcular(listaRespostas);



    }



}