package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
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
public class BuscarQuestoesTecnicasFiltradasPaginadoServiceTest {

    @InjectMocks
    BuscarQuestoesTecnicasFiltradasPaginadoService buscarQuestoesTecnicasFiltradasPaginadoService;

    @Mock
    QuestaoTecnicaRepository repository;

    @Test
    public void deveRetornarUmaPaginaDeQuestoesTecnicasQuandoBuscarQuestoesTecnicasFiltradasPaginadoServiceForChamado() {

        PageRequest page = PageRequest.of(1, 10);
        List<QuestaoTecnica> questoesTecnicas = new ArrayList<>();

        Page<QuestaoTecnica> questoesPaginadas = new PageImpl<>(questoesTecnicas, page, questoesTecnicas.size());

        Mockito.when(repository.acharPorNivelEEspecificidadePaginado(page, Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL))
            .thenReturn(questoesPaginadas);

        Assert.assertEquals(questoesPaginadas,
                buscarQuestoesTecnicasFiltradasPaginadoService
                        .buscar(page, Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL));
    }

    @Test
    public void deveChamarQuestaoTecnicaRepositoryQuandoBuscarQuestoesTecnicasFiltradasPaginadoServiceForChamado() {

        PageRequest page = PageRequest.of(1, 10);
        List<QuestaoTecnica> questoesTecnicas = new ArrayList<>();

        Page<QuestaoTecnica> questoesPaginadas = new PageImpl<>(questoesTecnicas, page, questoesTecnicas.size());

        Mockito.when(repository.acharPorNivelEEspecificidadePaginado(page, Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL))
                .thenReturn(questoesPaginadas);

        buscarQuestoesTecnicasFiltradasPaginadoService.buscar(page, Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);

        Mockito.verify(repository).acharPorNivelEEspecificidadePaginado(page, Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);

    }

}