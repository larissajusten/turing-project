package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import org.junit.Assert;
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
    public void deveRetornarONumeroDeAcertosDeMultiplaEscolhaQuandoCalcularNumeroDeAcertosMultiplaEscolhaServiceForChamado() {

        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();
        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva2 = new RespostasMultiplaEscolhaProva();
        List<RespostasMultiplaEscolhaProva> listaRespostas = new ArrayList<>();
        AlternativaMultiplaEscolha alternativaEscolhida = new AlternativaMultiplaEscolha();
        AlternativaMultiplaEscolha alternativaEscolhida2 = new AlternativaMultiplaEscolha();

        listaRespostas.add(respostasMultiplaEscolhaProva);
        listaRespostas.add(respostasMultiplaEscolhaProva2);

        alternativaEscolhida.setRespostaCorreta(true);
        alternativaEscolhida2.setRespostaCorreta(false);

        respostasMultiplaEscolhaProva.setAlternativaMultiplaEscolha(alternativaEscolhida);
        respostasMultiplaEscolhaProva2.setAlternativaMultiplaEscolha(alternativaEscolhida2);

        Assert.assertEquals(1,calcularNumeroDeAcertosMultiplaEscolhaService.calcular(listaRespostas));



    }



}