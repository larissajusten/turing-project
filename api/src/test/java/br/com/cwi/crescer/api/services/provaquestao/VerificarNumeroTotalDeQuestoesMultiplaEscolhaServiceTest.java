package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
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
public class VerificarNumeroTotalDeQuestoesMultiplaEscolhaServiceTest {

    @InjectMocks
    VerificarNumeroTotalDeQuestoesMultiplaEscolhaService verificarNumeroTotalDeQuestoesMultiplaEscolhaService;

    @Mock
    ProvaQuestaoMultiplaEscolhaRepository repository;

    @Test
    public void deveRetornarUmInteiroQuandoVerificarNumeroTotalDeQuestoesMultiplaEscolhaService() {

        Prova prova = new Prova();
        List<ProvaQuestaoMultiplaEscolha> listaProvaQuestaoMultiplaEscoha = new ArrayList<>();
        ProvaQuestaoMultiplaEscolha provaQuestaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();
        listaProvaQuestaoMultiplaEscoha.add(provaQuestaoMultiplaEscolha);

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(listaProvaQuestaoMultiplaEscoha);

        Assert.assertEquals(1, verificarNumeroTotalDeQuestoesMultiplaEscolhaService.verificar(prova.getId()));

    }

}