package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.mapper.QuestaoComRespostaMapper;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import br.com.cwi.crescer.api.services.respostaprova.RetornarQuestaoTecnicaComRespostaResponseService;
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
public class RetornarQuestaoTecnicaComRespostaResponseServiceTest {

    @InjectMocks
    RetornarQuestaoTecnicaComRespostaResponseService retornarQuestaoTecnicaComRespostaResponseService;

    @Mock
    private RespostasTecnicaRepository respostasTecnicaRepository;

    @Mock
    private QuestaoComRespostaMapper mapper;

    @Test
    public void deverRetornarUmaListaDeQuestaoTecnicaComRespostaResponseQuandoRetornarQuestaoTecnicaComRespostaResponseServiceForChamado() {

        Prova prova = new Prova();
        RespostasTecnicaProva respostaTecnicaProva = new RespostasTecnicaProva();
        QuestaoTecnicaComRespostaResponse questaoTecnicaComRespostaResponse = new QuestaoTecnicaComRespostaResponse();
        List<RespostasTecnicaProva> respostasTecnicaProva = new ArrayList<>();
        List<QuestaoTecnicaComRespostaResponse> listaQuestoesTecnicas = new ArrayList<>();

        Mockito.when(respostasTecnicaRepository.findAllByProvaIdEquals(prova.getId())).thenReturn(respostasTecnicaProva);

        retornarQuestaoTecnicaComRespostaResponseService.buscar(prova);

        Assert.assertEquals(listaQuestoesTecnicas, retornarQuestaoTecnicaComRespostaResponseService.buscar(prova));

    }

    @Test
    public void deverChamarRespostasTecnicaRepositoryQuandoRetornarQuestaoTecnicaComRespostaResponseServiceForChamado() {

        Prova prova = new Prova();
        RespostasTecnicaProva respostaTecnicaProva = new RespostasTecnicaProva();
        QuestaoTecnicaComRespostaResponse questaoTecnicaComRespostaResponse = new QuestaoTecnicaComRespostaResponse();
        List<RespostasTecnicaProva> respostasTecnicaProva = new ArrayList<>();
        List<QuestaoTecnicaComRespostaResponse> listaQuestoesTecnicas = new ArrayList<>();

        Mockito.when(respostasTecnicaRepository.findAllByProvaIdEquals(prova.getId())).thenReturn(respostasTecnicaProva);

        retornarQuestaoTecnicaComRespostaResponseService.buscar(prova);

        Mockito.verify(respostasTecnicaRepository).findAllByProvaIdEquals(prova.getId());

    }


}