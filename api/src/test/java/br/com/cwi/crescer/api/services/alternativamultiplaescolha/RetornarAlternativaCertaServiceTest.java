package br.com.cwi.crescer.api.services.alternativamultiplaescolha;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.repository.questao.AlternativaMultiplaEscolhaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RetornarAlternativaCertaServiceTest {

    @InjectMocks
    RetornarAlternativaCertaService retornarAlternativaCertaService;

    @Mock
    AlternativaMultiplaEscolhaRepository repository;

    @Test
    public void deveChamarAlternativaMultiplaEscolhaRepositoryQuandoRetornarAlternativaCertaService() {

        AlternativaMultiplaEscolha alternativa = new AlternativaMultiplaEscolha();
        alternativa.setRespostaCorreta(true);

        Mockito.when(repository.isAlternativaCerta(alternativa.getId())).thenReturn(true);

        retornarAlternativaCertaService.retornar(alternativa.getId());

        Mockito.verify(repository).isAlternativaCerta(alternativa.getId());
    }

    @Test
    public void deveRetornarFalseQuandoAlternativaNaoForACorreta() {

        AlternativaMultiplaEscolha alternativa = new AlternativaMultiplaEscolha();
        alternativa.setRespostaCorreta(false);

        Mockito.when(repository.isAlternativaCerta(alternativa.getId())).thenReturn(false);

        retornarAlternativaCertaService.retornar(alternativa.getId());

        Assert.assertFalse(retornarAlternativaCertaService.retornar(alternativa.getId()));

    }
    @Test
    public void deveRetornarTrueQuandoAlternativaForACorreta() {

        AlternativaMultiplaEscolha alternativa = new AlternativaMultiplaEscolha();
        alternativa.setRespostaCorreta(true);

        Mockito.when(repository.isAlternativaCerta(alternativa.getId())).thenReturn(true);

        retornarAlternativaCertaService.retornar(alternativa.getId());

        Assert.assertTrue(retornarAlternativaCertaService.retornar(alternativa.getId()));

    }



}