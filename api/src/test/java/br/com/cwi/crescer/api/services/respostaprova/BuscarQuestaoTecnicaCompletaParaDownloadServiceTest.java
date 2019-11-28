package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaCompletaResponse;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestaoTecnicaCompletaParaDownloadServiceTest {

    @InjectMocks
    BuscarQuestaoTecnicaCompletaParaDownloadService buscarQuestaoTecnicaCompletaParaDownloadService;

    @Mock
    BuscarRespostaTecnicaPorIDService buscarRespostaTecnicaPorIDService;

    @Test
    public void deveRetornarQuestaoTecnicaCompletaResponseQuandoBuscarQuestaoTecnicaCompletaParaDownloadServiceForChamado() {

        QuestaoTecnicaCompletaResponse response = new QuestaoTecnicaCompletaResponse();

        RespostasTecnicaProva respostaTecnica = new RespostasTecnicaProva();

        respostaTecnica.setResposta("Teste");
        respostaTecnica.setComentario("Comentario");
        respostaTecnica.setNota(10);
        respostaTecnica.setQuestaoTecnica(new QuestaoTecnica());

        response.setRespostaUsuario(respostaTecnica.getResposta());
        response.setRespostaBase(respostaTecnica.getQuestaoTecnica().getRespostaBase());
        response.setTesteBase(respostaTecnica.getQuestaoTecnica().getTesteBase());
        response.setQuestao(respostaTecnica.getQuestaoTecnica().getQuestao());

        Mockito.when(buscarRespostaTecnicaPorIDService.buscar(respostaTecnica.getId())).thenReturn(respostaTecnica);

        Assert.assertEquals(response, buscarQuestaoTecnicaCompletaParaDownloadService.buscar(respostaTecnica.getId()));
    }

    @Test
    public void deveChamarBuscarRespostaTecnicaPorIDServiceQuandoBuscarQuestaoTecnicaCompletaParaDownloadServiceForChamado() {

        QuestaoTecnicaCompletaResponse response = new QuestaoTecnicaCompletaResponse();

        RespostasTecnicaProva respostaTecnica = new RespostasTecnicaProva();

        respostaTecnica.setResposta("Teste");
        respostaTecnica.setComentario("Comentario");
        respostaTecnica.setNota(10);
        respostaTecnica.setQuestaoTecnica(new QuestaoTecnica());

        response.setRespostaUsuario(respostaTecnica.getResposta());
        response.setRespostaBase(respostaTecnica.getQuestaoTecnica().getRespostaBase());
        response.setTesteBase(respostaTecnica.getQuestaoTecnica().getTesteBase());
        response.setQuestao(respostaTecnica.getQuestaoTecnica().getQuestao());

        Mockito.when(buscarRespostaTecnicaPorIDService.buscar(respostaTecnica.getId())).thenReturn(respostaTecnica);

        buscarQuestaoTecnicaCompletaParaDownloadService.buscar(respostaTecnica.getId());

        Mockito.verify(buscarRespostaTecnicaPorIDService).buscar(respostaTecnica.getId());
    }


}