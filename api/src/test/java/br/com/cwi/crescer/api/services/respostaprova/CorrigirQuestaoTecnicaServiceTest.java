package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.requests.questoes.CorrecaoProvaRequest;
import br.com.cwi.crescer.api.domain.enums.TipoDeQuestao;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import br.com.cwi.crescer.api.validator.NotaValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CorrigirQuestaoTecnicaServiceTest {

    @InjectMocks
    CorrigirQuestaoTecnicaService corrigirQuestaoTecnicaService;

    @Mock
    RespostasTecnicaRepository repository;

    @Mock
    NotaValidator notaValidator;

    @Mock
    BuscarRespostaTecnicaPorIDService buscarRespostaTecnicaPorIDService;

    @Test
    public void deveChamarBuscarRespostaTecnicaPorIDServiceQuandoCorrigirQuestaoTecnicaServiceForChamado() {

        RespostasTecnicaProva resposta = new RespostasTecnicaProva();
        CorrecaoProvaRequest correcao = new CorrecaoProvaRequest(1L, 1L, TipoDeQuestao.TECNICA, 10, "oi");

        Mockito.when(buscarRespostaTecnicaPorIDService.buscar(resposta.getId())).thenReturn(resposta);
        Mockito.doNothing().when(notaValidator).validar(correcao.getNota());
        corrigirQuestaoTecnicaService.corrigir(resposta.getId(), correcao);

        Mockito.verify(buscarRespostaTecnicaPorIDService).buscar(resposta.getId());
    }

    @Test
    public void deveChamarRespostasTecnicaRepositorySaveQuandoCorrigirQuestaoTecnicaServiceForChamado() {

        RespostasTecnicaProva resposta = new RespostasTecnicaProva();
        CorrecaoProvaRequest correcao = new CorrecaoProvaRequest(1L, 1L, TipoDeQuestao.TECNICA, 10, "oi");

        Mockito.when(buscarRespostaTecnicaPorIDService.buscar(resposta.getId())).thenReturn(resposta);
        Mockito.doNothing().when(notaValidator).validar(correcao.getNota());
        corrigirQuestaoTecnicaService.corrigir(resposta.getId(), correcao);

        Mockito.verify(repository).save(resposta);
    }
}