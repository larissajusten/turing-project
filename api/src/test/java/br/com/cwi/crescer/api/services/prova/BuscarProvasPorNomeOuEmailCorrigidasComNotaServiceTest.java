package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaCorrigidaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import br.com.cwi.crescer.api.services.respostaprova.RetornarQuestaoDissertativaComRespostaResponseService;
import br.com.cwi.crescer.api.services.respostaprova.RetornarQuestaoMultiplaEscolhaComRespostaResponseService;
import br.com.cwi.crescer.api.services.respostaprova.RetornarQuestaoTecnicaComRespostaResponseService;
import br.com.cwi.crescer.api.validator.ProvasVaziaValidador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BuscarProvasPorNomeOuEmailCorrigidasComNotaServiceTest {
    @Mock
    ProvaRepository repository;
    @Mock
    RetornarQuestaoTecnicaComRespostaResponseService retornarQuestaoTecnicaComRespostaResponseService;
    @Mock
    RetornarQuestaoDissertativaComRespostaResponseService retornarQuestaoDissertativaComRespostaResponseService;
    @Mock
    RetornarQuestaoMultiplaEscolhaComRespostaResponseService retornarQuestaoMultiplaEscolhaComRespostaResponseService;
    @Mock
    RetornarListaDeEspecifidadesDeUmaProvaService retornarListaDeEspecifidadesDeUmaProvaService;
    @Mock
    BuscarProvaPorIdCorrigidaService buscarProvaPorIdCorrigidaService;
    @Mock
    ProvasVaziaValidador validator;
    @InjectMocks
    BuscarProvasPorNomeOuEmailCorrigidasComNotaService buscarProvasPorNomeOuEmailCorrigidasComNotaService;

    @Test
    public void deveBuscarProvaDeNomeOuEmail() {
        Prova prova = new Prova();
        prova.setId(1L);
        prova.setStatus(StatusProva.ATIVA);

        List<Prova> listaDeProva = new ArrayList<>();
        listaDeProva.add(prova);
        when(repository.acharPorNomeOuEmail(anyString(), anyString(),
                any())).thenReturn(listaDeProva);

        ProvaCorrigidaResponse provaCorrigidaResponse = new ProvaCorrigidaResponse();
        provaCorrigidaResponse.setId(1L);

        when(buscarProvaPorIdCorrigidaService.buscar(anyLong())).thenReturn(provaCorrigidaResponse);

        List<ProvaCorrigidaResponse> resultado = buscarProvasPorNomeOuEmailCorrigidasComNotaService.buscar("nomeOuEmail");

        Assert.assertEquals(provaCorrigidaResponse, resultado.get(0));
    }
}
