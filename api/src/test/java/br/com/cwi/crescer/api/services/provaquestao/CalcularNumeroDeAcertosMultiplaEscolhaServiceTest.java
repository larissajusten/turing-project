package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CalcularNumeroDeAcertosMultiplaEscolhaServiceTest {

    @InjectMocks
    CalcularNumeroDeAcertosMultiplaEscolhaService calcularNumeroDeAcertosMultiplaEscolhaService;

    @Mock
    ListarQuestoesMultiplaEscolhaDaProvaService listarQuestoesMultiplaEscolhaDaProvaService;

    @Mock
    RespostaMultiplaEscolhaRepository repository;


    @Test
    public void deveChamarRespostaMultiplaEscolhaRepositoryQuandoCalcularNumeroDeAcertosMultiplaEscolhaServiceForChamado() {

        Prova prova = new Prova();
        List<ProvaQuestaoMultiplaEscolha> provaQuestaoMultiplaEscolhas = new ArrayList<>();
        AlternativaMultiplaEscolha alternativaEscolhida = new AlternativaMultiplaEscolha();
        ProvaQuestaoMultiplaEscolha provaQuestaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();
        List<RespostasMultiplaEscolhaProva> listaRespostas = new ArrayList<>();
        alternativaEscolhida.setRespostaCorreta(true);


        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(listaRespostas);

        //calcularNumeroDeAcertosMultiplaEscolhaService.calcular(prova.getId());

        Mockito.verify(repository).findAllByProvaIdEquals(prova.getId());
    }

    @Test
    public void deveRetornarUmInteiroQuandoCalcularNumeroDeAcertosMultiplaEscolhaServiceForChamado() {

        Prova prova = new Prova();
        AlternativaMultiplaEscolha alternativaEscolhida = new AlternativaMultiplaEscolha();
        List<RespostasMultiplaEscolhaProva> listaRespostas = new ArrayList<>();
        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();
        respostasMultiplaEscolhaProva.setAlternativaMultiplaEscolha(alternativaEscolhida);
        alternativaEscolhida.setRespostaCorreta(true);
        listaRespostas.add(respostasMultiplaEscolhaProva);


        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(listaRespostas);

        //calcularNumeroDeAcertosMultiplaEscolhaService.calcular(prova.getId());

        Mockito.verify(repository).findAllByProvaIdEquals(prova.getId());

        //Assert.assertEquals(1, calcularNumeroDeAcertosMultiplaEscolhaService.calcular(prova.getId()));

    }
}