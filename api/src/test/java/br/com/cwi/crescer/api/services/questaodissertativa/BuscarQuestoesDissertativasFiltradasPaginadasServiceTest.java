package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import br.com.cwi.crescer.api.validator.PageDeQuestoesValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestoesDissertativasFiltradasPaginadasServiceTest {

    @InjectMocks
    BuscarQuestoesDissertativasFiltradasPaginadasService buscarQuestoesDissertativasFiltradasPaginadasService;

    @Mock
    QuestaoDissertativaRepository repository;

    @Mock
    PageDeQuestoesValidator validator;

    @Test
    public void deveRetornarUmaPageDeQuestaoDissertativaQuandoBuscarQuestaoDissertativaPorEspecificidadeENivelPaginadasServiceForChamado() {
        PageRequest pageRequest = PageRequest.of(1, 10);
        List<QuestaoDissertativa> questoes = new ArrayList<>();
        Page<QuestaoDissertativa> pagina = new PageImpl<>(questoes, pageRequest, questoes.size());

        Mockito.when(repository.acharPorNivelEEspecificidadePaginado(pageRequest, Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL))
                .thenReturn(pagina);

        Assert.assertEquals(pagina, buscarQuestoesDissertativasFiltradasPaginadasService.buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, pageRequest));
    }

    @Test
    public void deveChamarQuestaoDissertativaRepositoryQuandoBuscarQuestaoDissertativaPorEspecificidadeENivelPaginadasServiceForChamado() {
        PageRequest pageRequest = PageRequest.of(1, 10);
        List<QuestaoDissertativa> questoes = new ArrayList<>();
        Page<QuestaoDissertativa> pagina = new PageImpl<>(questoes, pageRequest, questoes.size());

        Mockito.when(repository.acharPorNivelEEspecificidadePaginado(pageRequest, Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL))
                .thenReturn(pagina);

        buscarQuestoesDissertativasFiltradasPaginadasService.buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, pageRequest);

        Mockito.verify(repository).acharPorNivelEEspecificidadePaginado(pageRequest, Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);
    }

}