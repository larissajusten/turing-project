package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class GerarNotaDasQuestoesMultiplaEscolhaDeAcordoComPesoServiceTest {


    @InjectMocks
    GerarNotaDasQuestoesMultiplaEscolhaDeAcordoComPesoService gerarNotaDasQuestoesMultiplaEscolhaDeAcordoComPesoService;

    @Mock
    RespostaMultiplaEscolhaRepository respostaMultiplaEscolhaRepository;


    @Test
    public void deveRetornarANotaDasQuestoesMultiplaEscolhaDaProvaComDistincaoDePesoQuandoGerarNotaDasQuestoesMultiplaEscolhaDeAcordoComPesoServiceForChamado() {

        Prova prova = new Prova();

        int quantidadeQuestoesNivelFacil = 2;
        int quantidadeQuestoesNivelMedio = 1;
        int quantidadeQuestoesNivelDificil = 3;

        Mockito.when(respostaMultiplaEscolhaRepository
                .buscarQuestoesCorretasDeMultiplaEscolhaPorProvaFiltradasPorNivelDeDificuldade(prova, NivelDeDificuldade.FACIL))
                .thenReturn(quantidadeQuestoesNivelFacil);

        Mockito.when(respostaMultiplaEscolhaRepository
                .buscarQuestoesCorretasDeMultiplaEscolhaPorProvaFiltradasPorNivelDeDificuldade(prova, NivelDeDificuldade.MEDIO))
                .thenReturn(quantidadeQuestoesNivelMedio);

        Mockito.when(respostaMultiplaEscolhaRepository
                .buscarQuestoesCorretasDeMultiplaEscolhaPorProvaFiltradasPorNivelDeDificuldade(prova, NivelDeDificuldade.DIFICIL))
                .thenReturn(quantidadeQuestoesNivelDificil);

        Assert.assertEquals(10, gerarNotaDasQuestoesMultiplaEscolhaDeAcordoComPesoService.gerar(prova), 0);

    }

    @Test
    public void deveChamarRespostaMultiplaEscolhaRepository3VezesQuandoGerarNotaDasQuestoesMultiplaEscolhaDeAcordoComPesoServiceForChamado() {

        Prova prova = new Prova();

        int quantidadeQuestoesNivelFacil = 2;
        int quantidadeQuestoesNivelMedio = 1;
        int quantidadeQuestoesNivelDificil = 3;

        Mockito.when(respostaMultiplaEscolhaRepository
                .buscarQuestoesCorretasDeMultiplaEscolhaPorProvaFiltradasPorNivelDeDificuldade(prova, NivelDeDificuldade.FACIL))
                .thenReturn(quantidadeQuestoesNivelFacil);

        Mockito.when(respostaMultiplaEscolhaRepository
                .buscarQuestoesCorretasDeMultiplaEscolhaPorProvaFiltradasPorNivelDeDificuldade(prova, NivelDeDificuldade.MEDIO))
                .thenReturn(quantidadeQuestoesNivelMedio);

        Mockito.when(respostaMultiplaEscolhaRepository
                .buscarQuestoesCorretasDeMultiplaEscolhaPorProvaFiltradasPorNivelDeDificuldade(prova, NivelDeDificuldade.DIFICIL))
                .thenReturn(quantidadeQuestoesNivelDificil);

        gerarNotaDasQuestoesMultiplaEscolhaDeAcordoComPesoService.gerar(prova);

        Mockito.verify(respostaMultiplaEscolhaRepository).buscarQuestoesCorretasDeMultiplaEscolhaPorProvaFiltradasPorNivelDeDificuldade(prova, NivelDeDificuldade.FACIL);
        Mockito.verify(respostaMultiplaEscolhaRepository).buscarQuestoesCorretasDeMultiplaEscolhaPorProvaFiltradasPorNivelDeDificuldade(prova, NivelDeDificuldade.MEDIO);
        Mockito.verify(respostaMultiplaEscolhaRepository).buscarQuestoesCorretasDeMultiplaEscolhaPorProvaFiltradasPorNivelDeDificuldade(prova, NivelDeDificuldade.DIFICIL);

    }
 }