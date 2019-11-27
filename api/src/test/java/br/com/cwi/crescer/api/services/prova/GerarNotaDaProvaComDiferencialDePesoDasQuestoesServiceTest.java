package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GerarNotaDaProvaComDiferencialDePesoDasQuestoesServiceTest {

    @InjectMocks
    GerarNotaDaProvaComDiferencialDePesoDasQuestoesService gerarNotaDaProvaComDiferencialDePesoDasQuestoesService;

    @Mock
    GerarNotaDasQuestoesDissertativaDeAcordoComPesoService gerarNotasDissertativas;

    @Mock
    GerarNotaDasQuestoesTecnicaDeAcordoComPesoService gerarNotasTecnicas;

    @Mock
    GerarNotaDasQuestoesMultiplaEscolhaDeAcordoComPesoService gerarNotasMutiplaEscolha;

    @Mock
    GerarDivisorFinalParaNotaDaProvaService gerarDivisorFinalParaNotaDaProvaService;

    @Test
    public void deveChamarGerarNotaDasQuestoesDissertativaDeAcordoComPesoServiceQuandoGerarNotaDaProvaComDiferencialDePesoDasQuestoesServiceForChamado() {
        Prova prova = new Prova();

        gerarNotaDaProvaComDiferencialDePesoDasQuestoesService.gerarNotaDaProva(prova);

        Mockito.verify(gerarNotasDissertativas).gerar(prova);
    }

    @Test
    public void deveChamarGerarNotaDasQuestoesTecnicaDeAcordoComPesoServiceQuandoGerarNotaDaProvaComDiferencialDePesoDasQuestoesServiceForChamado() {
        Prova prova = new Prova();

        gerarNotaDaProvaComDiferencialDePesoDasQuestoesService.gerarNotaDaProva(prova);

        Mockito.verify(gerarNotasTecnicas).gerar(prova);

    }

    @Test
    public void deveChamarRespostaMultiplaEscolhaRepositoryQuandoGerarNotaDaProvaComDiferencialDePesoDasQuestoesServiceForChamado() {
        Prova prova = new Prova();

        gerarNotaDaProvaComDiferencialDePesoDasQuestoesService.gerarNotaDaProva(prova);

        Mockito.verify(gerarNotasMutiplaEscolha).gerar(prova);
    }

    @Test
    public void deveRetornarUmaNotaQuandoGerarNotaDaProvaComDiferencialDePesoDasQuestoesServiceForChamado() {

        Prova prova = new Prova();

        Mockito.when(gerarNotasDissertativas.gerar(prova))
                .thenReturn(10.0);
        Mockito.when(gerarNotasTecnicas.gerar(prova))
                .thenReturn(10.0);
        Mockito.when(gerarNotasMutiplaEscolha.gerar(prova))
                .thenReturn(10.0);
        Mockito.when(gerarDivisorFinalParaNotaDaProvaService.retornarTotalDeQuestoesDaProva(prova))
                .thenReturn(3);

        gerarNotaDaProvaComDiferencialDePesoDasQuestoesService.gerarNotaDaProva(prova);


        Assert.assertEquals(10.0, gerarNotaDaProvaComDiferencialDePesoDasQuestoesService.gerarNotaDaProva(prova), 0);
    }

}