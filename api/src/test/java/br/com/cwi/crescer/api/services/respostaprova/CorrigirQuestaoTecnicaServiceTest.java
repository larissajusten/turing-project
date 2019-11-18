package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.requests.questoes.CorrecaoProvaRequest;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CorrigirQuestaoTecnicaServiceTest {

    @InjectMocks
    CorrigirQuestaoTecnicaService corrigirQuestaoTecnicaService;

    @Mock
    RespostasTecnicaRepository repository;

    @Test
    public void deveChamarRespostasTecnicaRepositoryFindByIdQuandoCorrigirQuestaoTecnicaServiceForChamado() {

        RespostasTecnicaProva resposta = new RespostasTecnicaProva();
        CorrecaoProvaRequest correcao = new CorrecaoProvaRequest(10, "Muito bom");

        Mockito.when(repository.findById(resposta.getId())).thenReturn(Optional.of(resposta));

        corrigirQuestaoTecnicaService.corrigir(resposta.getId(), correcao);

        Mockito.verify(repository).findById(resposta.getId());
    }

    @Test
    public void deveChamarRespostasTecnicaRepositorySaveQuandoCorrigirQuestaoTecnicaServiceForChamado() {

        RespostasTecnicaProva resposta = new RespostasTecnicaProva();
        CorrecaoProvaRequest correcao = new CorrecaoProvaRequest(10, "Muito bom");

        Mockito.when(repository.findById(resposta.getId())).thenReturn(Optional.of(resposta));

        corrigirQuestaoTecnicaService.corrigir(resposta.getId(), correcao);

        Mockito.verify(repository).save(resposta);
    }
}