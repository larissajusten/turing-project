package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.mapper.QuestaoTecnicaMapper;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdicionarQuestaoTecnicaServiceTest {

    @InjectMocks
    AdicionarQuestaoTecnicaService adicionarQuestaoTecnicaService;

    @Mock
    QuestaoTecnicaRepository repository;

    @Mock
    QuestaoTecnicaMapper mapper;

    @Test
    public void deveChamarQuestaoTecnicaRepositorySaveQuandoAdicionarQuestaoTecnicaServiceForChamada() {
        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        QuestaoUnicaAlternativaRequest questaoUnicaAlternativaRequest =
                new QuestaoUnicaAlternativaRequest("Bla bla...",
                        Especificidade.JAVASCRIPT,
                        NivelDeDificuldade.FACIL);

        Mockito.when(mapper.transformar(questaoUnicaAlternativaRequest)).thenReturn(questaoTecnica);

        adicionarQuestaoTecnicaService.adicionar(questaoUnicaAlternativaRequest);

        Mockito.verify(repository).save(questaoTecnica);
    }

    @Test
    public void deveChamarQuestaoTecnicaMapperQuandoAdicionarQuestaoTecnicaServiceForChamada() {
        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        QuestaoUnicaAlternativaRequest questaoUnicaAlternativaRequest =
                new QuestaoUnicaAlternativaRequest("Bla bla...",
                        Especificidade.JAVASCRIPT,
                        NivelDeDificuldade.FACIL);

        Mockito.when(mapper.transformar(questaoUnicaAlternativaRequest)).thenReturn(questaoTecnica);

        adicionarQuestaoTecnicaService.adicionar(questaoUnicaAlternativaRequest);

        Mockito.verify(mapper).transformar(questaoUnicaAlternativaRequest);
    }


}