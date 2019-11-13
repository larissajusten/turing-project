package br.com.cwi.crescer.api.services.QuestaoTecnicaService;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesTecnicasRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ListarQuestoesTecnicasServiceTest {
    @Mock
    BuscarQuestaoTecnicaPorNivelEEspecificidadeService buscarQuestaoTecnicaPorNivelEEspecificidadeService;
    @InjectMocks
    ListarQuestoesTecnicasService listarQuestoesTecnicasService;


    @Test
    public void deveBuscarQuestoesDeMultiplaEscolhaConformeParametros() {
        List<QuestaoTecnica> lista = new ArrayList<>();

        when(buscarQuestaoTecnicaPorNivelEEspecificidadeService.buscar(any(), any())).thenReturn(lista);

        List<QuestaoTecnica> resultado = listarQuestoesTecnicasService.buscar(new BuscaQuestoesTecnicasRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 0));
        Assert.assertEquals(lista, resultado);
    }
}
