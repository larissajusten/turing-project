package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.dto.NotasDTO;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class GerarNotaDasQuestoesTecnicaDeAcordoComPesoServiceTest {

    @InjectMocks
    GerarNotaDasQuestoesTecnicaDeAcordoComPesoService gerarNotaDasQuestoesTecnicaDeAcordoComPesoService;

    @Mock
    RespostasTecnicaRepository respostasTecnicaProva;

    @Test
    public void deveRetornarANotaDasQuestoesDissertativasQuandoGerarNotaDasQuestoesDissertativaDeAcordoComPesoServiceForChamado() {

        Prova prova = new Prova();

        NotasDTO notaQuestoesFaceis = new NotasDTO();
        notaQuestoesFaceis.setNota(20);
        notaQuestoesFaceis.setQuantidadeDeQuestoes(2L);

        NotasDTO notaQuestoesMedias = new NotasDTO();
        notaQuestoesMedias.setNota(20);
        notaQuestoesMedias.setQuantidadeDeQuestoes(2L);

        NotasDTO notaQuestoesDificeis = new NotasDTO();
        notaQuestoesDificeis.setNota(20);
        notaQuestoesDificeis.setQuantidadeDeQuestoes(2L);

        Mockito.when(respostasTecnicaProva.buscarQuestoesTecnicasFiltradasPorNivelEPorProva(prova, NivelDeDificuldade.FACIL))
                .thenReturn(notaQuestoesFaceis);
        Mockito.when(respostasTecnicaProva.buscarQuestoesTecnicasFiltradasPorNivelEPorProva(prova, NivelDeDificuldade.MEDIO))
                .thenReturn(notaQuestoesMedias);
        Mockito.when(respostasTecnicaProva.buscarQuestoesTecnicasFiltradasPorNivelEPorProva(prova, NivelDeDificuldade.DIFICIL))
                .thenReturn(notaQuestoesDificeis);

        Assert.assertEquals(10, gerarNotaDasQuestoesTecnicaDeAcordoComPesoService.gerar(prova), 0);

    }

    @Test
    public void deveChamarRespostasDissertativaRepository3VezesQuandoGerarNotaDasQuestoesDissertativaDeAcordoComPesoServiceForChamado() {

        Prova prova = new Prova();

        NotasDTO notaQuestoesFaceis = new NotasDTO();
        notaQuestoesFaceis.setNota(20);
        notaQuestoesFaceis.setQuantidadeDeQuestoes(2L);

        NotasDTO notaQuestoesMedias = new NotasDTO();
        notaQuestoesMedias.setNota(20);
        notaQuestoesMedias.setQuantidadeDeQuestoes(2L);

        NotasDTO notaQuestoesDificeis = new NotasDTO();
        notaQuestoesDificeis.setNota(20);
        notaQuestoesDificeis.setQuantidadeDeQuestoes(2L);

        Mockito.when(respostasTecnicaProva.buscarQuestoesTecnicasFiltradasPorNivelEPorProva(prova, NivelDeDificuldade.FACIL))
                .thenReturn(notaQuestoesFaceis);
        Mockito.when(respostasTecnicaProva.buscarQuestoesTecnicasFiltradasPorNivelEPorProva(prova, NivelDeDificuldade.MEDIO))
                .thenReturn(notaQuestoesMedias);
        Mockito.when(respostasTecnicaProva.buscarQuestoesTecnicasFiltradasPorNivelEPorProva(prova, NivelDeDificuldade.DIFICIL))
                .thenReturn(notaQuestoesDificeis);

        gerarNotaDasQuestoesTecnicaDeAcordoComPesoService.gerar(prova);

        Mockito.verify(respostasTecnicaProva)
                .buscarQuestoesTecnicasFiltradasPorNivelEPorProva(prova, NivelDeDificuldade.FACIL);
        Mockito.verify(respostasTecnicaProva)
                .buscarQuestoesTecnicasFiltradasPorNivelEPorProva(prova, NivelDeDificuldade.MEDIO);
        Mockito.verify(respostasTecnicaProva)
                .buscarQuestoesTecnicasFiltradasPorNivelEPorProva(prova, NivelDeDificuldade.DIFICIL);

    }
}