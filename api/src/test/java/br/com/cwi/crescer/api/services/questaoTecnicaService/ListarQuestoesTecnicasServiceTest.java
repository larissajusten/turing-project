package br.com.cwi.crescer.api.services.questaoTecnicaService;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListarQuestoesTecnicasServiceTest {
    @Mock
    BuscarQuestaoTecnicaPorNivelEEspecificidadeService buscarQuestaoTecnicaPorNivelEEspecificidadeService;
    @InjectMocks
    ListarQuestoesTecnicasService listarQuestoesTecnicasService;


    @Test
    public void deveBuscarQuestoesDeMultiplaEscolhaConformeParametros() {

        List<QuestaoTecnica> lista = new ArrayList<>();
        lista.add(new QuestaoTecnica());
        when(buscarQuestaoTecnicaPorNivelEEspecificidadeService.buscar(any(), any())).thenReturn(lista);

        List<QuestaoTecnica> resultado = listarQuestoesTecnicasService.buscar(new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1));
        Assert.assertEquals(lista, resultado);
    }

    @Test(expected = QuestaoNaoEncontradaException.class)
    public void deveLancarQuestaoNaoEncontradaQuandoAListaTiverSizeZero() {

        List<QuestaoTecnica> lista = new ArrayList<>();

        when(buscarQuestaoTecnicaPorNivelEEspecificidadeService.buscar(any(), any())).thenReturn(lista);

        List<QuestaoTecnica> resultado = listarQuestoesTecnicasService.buscar(new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 0));

    }

}
