package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.requests.questoes.CorrecaoProvaRequest;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CorrigirQuestaoDissertativaServiceTest {

    @InjectMocks
    CorrigirQuestaoDissertativaService corrigirQuestaoDissertativaService;

    @Mock
    RespostasDissertativaRepository repository;

    @Test
    public void deveChamarRespostasDissertativaRepositoryMetodoFindByIdQuandoCorrigirQuestaoDissertativaServiceForChamado() {
        CorrecaoProvaRequest correcao = new CorrecaoProvaRequest(10, "Muito bom");
        RespostasDissertativaProva resposta = new RespostasDissertativaProva();

        Mockito.when(repository.findById(resposta.getId())).thenReturn(Optional.of(resposta));
        Mockito.when(repository.save(resposta)).thenReturn(resposta);

        corrigirQuestaoDissertativaService.corrigir(resposta.getId(), correcao);

        Mockito.verify(repository).findById(resposta.getId());
    }

    @Test
    public void deveChamarRespostasDissertativaRepositoryMetodoSaveQuandoCorrigirQuestaoDissertativaServiceForChamado() {
        CorrecaoProvaRequest correcao = new CorrecaoProvaRequest(10, "Muito bom");
        RespostasDissertativaProva resposta = new RespostasDissertativaProva();

        Mockito.when(repository.findById(resposta.getId())).thenReturn(Optional.of(resposta));
        Mockito.when(repository.save(resposta)).thenReturn(resposta);

        corrigirQuestaoDissertativaService.corrigir(resposta.getId(), correcao);

        Mockito.verify(repository).save(resposta);
    }

}