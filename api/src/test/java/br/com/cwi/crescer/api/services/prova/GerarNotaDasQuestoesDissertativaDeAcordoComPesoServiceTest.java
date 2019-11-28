package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.dto.NotasDTO;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GerarNotaDasQuestoesDissertativaDeAcordoComPesoServiceTest {

    @InjectMocks
    GerarNotaDasQuestoesDissertativaDeAcordoComPesoService gerarNotaDasQuestoesDissertativaDeAcordoComPesoService;

    @Mock
    RespostasDissertativaRepository respostasDissertativaProva;


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

        Mockito.when(respostasDissertativaProva.buscarQuestoesDissertativasDeNivelFacilPorProva(prova.getId(), NivelDeDificuldade.FACIL))
                .thenReturn(notaQuestoesFaceis);
        Mockito.when(respostasDissertativaProva.buscarQuestoesDissertativasDeNivelFacilPorProva(prova.getId(), NivelDeDificuldade.MEDIO))
                .thenReturn(notaQuestoesMedias);
        Mockito.when(respostasDissertativaProva.buscarQuestoesDissertativasDeNivelFacilPorProva(prova.getId(), NivelDeDificuldade.DIFICIL))
                .thenReturn(notaQuestoesDificeis);

        Assert.assertEquals(10, gerarNotaDasQuestoesDissertativaDeAcordoComPesoService.gerar(prova), 0);

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

        Mockito.when(respostasDissertativaProva.buscarQuestoesDissertativasDeNivelFacilPorProva(prova.getId(), NivelDeDificuldade.FACIL))
                .thenReturn(notaQuestoesFaceis);
        Mockito.when(respostasDissertativaProva.buscarQuestoesDissertativasDeNivelFacilPorProva(prova.getId(), NivelDeDificuldade.MEDIO))
                .thenReturn(notaQuestoesMedias);
        Mockito.when(respostasDissertativaProva.buscarQuestoesDissertativasDeNivelFacilPorProva(prova.getId(), NivelDeDificuldade.DIFICIL))
                .thenReturn(notaQuestoesDificeis);

        gerarNotaDasQuestoesDissertativaDeAcordoComPesoService.gerar(prova);

        Mockito.verify(respostasDissertativaProva)
                .buscarQuestoesDissertativasDeNivelFacilPorProva(prova.getId(), NivelDeDificuldade.FACIL);
        Mockito.verify(respostasDissertativaProva)
                .buscarQuestoesDissertativasDeNivelFacilPorProva(prova.getId(), NivelDeDificuldade.MEDIO);
        Mockito.verify(respostasDissertativaProva)
                .buscarQuestoesDissertativasDeNivelFacilPorProva(prova.getId(), NivelDeDificuldade.DIFICIL);

    }

}