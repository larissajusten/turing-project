package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.requests.questoes.CorrecaoProvaRequest;
import br.com.cwi.crescer.api.domain.enums.TipoDeQuestao;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.validator.NotaValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CorrigirQuestaoDissertativaServiceTest {

    @InjectMocks
    CorrigirQuestaoDissertativaService corrigirQuestaoDissertativaService;

    @Mock
    RespostasDissertativaRepository repository;

    @Mock
    NotaValidator notaValidator;

    @Mock
    BuscarRespostaDissertativaPorIDService buscarRespostaDissertativaPorIDService;


    @Test
    public void deveChamarBuscarRespostaDissertativaPorIDServiceQuandoCorrigirQuestaoDissertativaServiceForChamado() {
        CorrecaoProvaRequest correcao = new CorrecaoProvaRequest(1L, 1L, TipoDeQuestao.TECNICA, 10, "oi");
        RespostasDissertativaProva resposta = new RespostasDissertativaProva();
        resposta.setNota(correcao.getNota());
        resposta.setComentario(correcao.getComentario());

        Mockito.when(buscarRespostaDissertativaPorIDService.buscar(resposta.getId())).thenReturn(resposta);
        Mockito.when(repository.save(resposta)).thenReturn(resposta);
        Mockito.doNothing().when(notaValidator).validar(correcao.getNota());


        corrigirQuestaoDissertativaService.corrigir(resposta.getId(), correcao);

        Mockito.verify(buscarRespostaDissertativaPorIDService).buscar(resposta.getId());

    }

    @Test
    public void deveChamarRespostasDissertativaRepositoryMetodoSaveQuandoCorrigirQuestaoDissertativaServiceForChamado() {
        CorrecaoProvaRequest correcao = new CorrecaoProvaRequest(1L, 1L, TipoDeQuestao.TECNICA, 10, "oi");
        RespostasDissertativaProva resposta = new RespostasDissertativaProva();

        Mockito.when(buscarRespostaDissertativaPorIDService.buscar(resposta.getId())).thenReturn(resposta);
        Mockito.when(repository.save(resposta)).thenReturn(resposta);
        Mockito.doNothing().when(notaValidator).validar(correcao.getNota());

        corrigirQuestaoDissertativaService.corrigir(resposta.getId(), correcao);

        Mockito.verify(repository).save(resposta);
    }

}