package br.com.cwi.crescer.api.services.questaoDissertativaService;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.mapper.QuestaoDissertativaMapper;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdicionarQuestaoDissertativaServiceTest {

    @InjectMocks
    AdicionarQuestaoDissertativaService adicionarQuestaoDissertativaService;

    @Mock
    QuestaoDissertativaRepository repository;

    @Mock
    QuestaoDissertativaMapper mapper;

    @Test
    public void deveChamarQuestaoDissertativaRepositoryQuandoAdicionarQuestaoDissertativaServiceForChamado() {

        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        QuestaoUnicaAlternativaRequest questaoUnicaAlternativaRequest =
                new QuestaoUnicaAlternativaRequest("O que é?", NivelDeDificuldade.FACIL, Especificidade.JAVASCRIPT);

        Mockito.when(mapper.transformar(questaoUnicaAlternativaRequest)).thenReturn(questaoDissertativa);
        Mockito.when(repository.save(questaoDissertativa)).thenReturn(questaoDissertativa);

        adicionarQuestaoDissertativaService.adicionar(questaoUnicaAlternativaRequest);

        Mockito.verify(repository).save(questaoDissertativa);

    }
}