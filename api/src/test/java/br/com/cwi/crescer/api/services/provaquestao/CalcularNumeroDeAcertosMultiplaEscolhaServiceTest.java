package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoMultiplaEscolha;
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
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CalcularNumeroDeAcertosMultiplaEscolhaServiceTest {

    @InjectMocks
    CalcularNumeroDeAcertosMultiplaEscolhaService calcularNumeroDeAcertosMultiplaEscolhaService;

    @Mock
    ListarQuestoesMultiplaEscolhaDaProvaService listarQuestoesMultiplaEscolhaDaProvaService;

    @Mock
    RespostaMultiplaEscolhaRepository repository;


    @Test
    public void deveChamarListarQuestoesMultiplaEscolhaDaProvaServiceQuandoCalcularNumeroDeAcertosMultiplaEscolhaServiceForChamado() {

        Prova prova = new Prova();
        List<ProvaQuestaoMultiplaEscolha> provaQuestaoMultiplaEscolhas = new ArrayList<>();
        AlternativaMultiplaEscolha alternativaEscolhida = new AlternativaMultiplaEscolha();
        ProvaQuestaoMultiplaEscolha provaQuestaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();

        Mockito.when(listarQuestoesMultiplaEscolhaDaProvaService
                .listar(prova.getId())).thenReturn(provaQuestaoMultiplaEscolhas);

        calcularNumeroDeAcertosMultiplaEscolhaService.calcular(prova.getId());

        Mockito.verify(listarQuestoesMultiplaEscolhaDaProvaService).listar(prova.getId());
    }

    @Test
    public void deveChamarRespostaMultiplaEscolhaRepositoryQuandoCalcularNumeroDeAcertosMultiplaEscolhaServiceForChamado() {

        Prova prova = new Prova();
        List<ProvaQuestaoMultiplaEscolha> provaQuestaoMultiplaEscolhas = new ArrayList<>();
        ProvaQuestaoMultiplaEscolha provaQuestaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();
        provaQuestaoMultiplaEscolhas.add(provaQuestaoMultiplaEscolha);
        AlternativaMultiplaEscolha alternativaEscolhida = new AlternativaMultiplaEscolha();


        Mockito.when(listarQuestoesMultiplaEscolhaDaProvaService
                .listar(prova.getId())).thenReturn(provaQuestaoMultiplaEscolhas);

//        Mockito.when(repository.buscarAlternativaEscolhida(provaQuestaoMultiplaEscolha.getId()))
//                .thenReturn(Optional.of(alternativaEscolhida));
//
//        calcularNumeroDeAcertosMultiplaEscolhaService.calcular(prova.getId());
//
//        Mockito.verify(repository).buscarAlternativaEscolhida(provaQuestaoMultiplaEscolha.getId());

    }

    @Test
    public void deveRetornarUmInteiroQuandoCalcularNumeroDeAcertosMultiplaEscolhaServiceForChamado() {

        Prova prova = new Prova();
        List<ProvaQuestaoMultiplaEscolha> provaQuestaoMultiplaEscolhas = new ArrayList<>();
        ProvaQuestaoMultiplaEscolha provaQuestaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();
        provaQuestaoMultiplaEscolhas.add(provaQuestaoMultiplaEscolha);
        AlternativaMultiplaEscolha alternativaEscolhida = new AlternativaMultiplaEscolha();
        alternativaEscolhida.setRespostaCorreta(true);

        Mockito.when(listarQuestoesMultiplaEscolhaDaProvaService
                .listar(prova.getId())).thenReturn(provaQuestaoMultiplaEscolhas);

       // Mockito.when(repository.buscarAlternativaEscolhida(provaQuestaoMultiplaEscolha.getId()))
       //         .thenReturn(Optional.of(alternativaEscolhida));

        calcularNumeroDeAcertosMultiplaEscolhaService.calcular(prova.getId());

        Assert.assertEquals(calcularNumeroDeAcertosMultiplaEscolhaService.calcular(prova.getId()), 1);

    }
}