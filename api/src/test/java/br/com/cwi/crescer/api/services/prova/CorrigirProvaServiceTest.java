package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.requests.questoes.CorrecaoProvaRequest;
import br.com.cwi.crescer.api.domain.enums.TipoDeQuestao;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import br.com.cwi.crescer.api.services.respostaprova.CorrigirQuestaoDissertativaService;
import br.com.cwi.crescer.api.services.respostaprova.CorrigirQuestaoTecnicaService;
import br.com.cwi.crescer.api.validator.CorrecaoValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CorrigirProvaServiceTest {

    @InjectMocks
    CorrigirProvaService corrigirProvaService;

    @Mock
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Mock
    CorrigirQuestaoDissertativaService corrigirQuestaoDissertativaService;

    @Mock
    CorrigirQuestaoTecnicaService corrigirQuestaoTecnicaService;

    @Mock
    CorrecaoValidator validator;

    @Mock
    ProvaRepository repository;

    @Test
    public void deveChamarCorrigirQuestaoDissertativaServiceQuandoCorrigirProvaServiceForChamado() {

        Prova prova = new Prova();
        CorrecaoProvaRequest correcaoProvaRequest = new CorrecaoProvaRequest(1L,
                1L,
                TipoDeQuestao.DISSERTATIVA,
                10,
                "Muito bom");
        List<CorrecaoProvaRequest> correcaoProvaRequests = new ArrayList<>();
        correcaoProvaRequests.add(correcaoProvaRequest);

        when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.doNothing().when(validator).validar(prova.getId());

        corrigirProvaService.corrigir(prova.getId(),correcaoProvaRequests);

        Mockito.verify(corrigirQuestaoDissertativaService)
                .corrigir(correcaoProvaRequest.getIdResposta(), correcaoProvaRequest);

    }

    @Test
    public void deveChamarCorrigirQuestaoTecnicaServiceQuandoCorrigirProvaServiceForChamado() {

        Prova prova = new Prova();
        CorrecaoProvaRequest correcaoProvaRequest = new CorrecaoProvaRequest(1L,
                1L,
                TipoDeQuestao.TECNICA,
                10,
                "Muito bom");
        List<CorrecaoProvaRequest> correcaoProvaRequests = new ArrayList<>();
        correcaoProvaRequests.add(correcaoProvaRequest);

        when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.doNothing().when(validator).validar(prova.getId());

        corrigirProvaService.corrigir(prova.getId(),correcaoProvaRequests);

        Mockito.verify(corrigirQuestaoTecnicaService)
                .corrigir(correcaoProvaRequest.getIdResposta(), correcaoProvaRequest);

    }


}