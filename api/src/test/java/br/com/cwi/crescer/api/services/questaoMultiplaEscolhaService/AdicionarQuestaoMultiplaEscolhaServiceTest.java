package br.com.cwi.crescer.api.services.questaoMultiplaEscolhaService;

import br.com.cwi.crescer.api.controller.requests.questoes.AlternativaQuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.mapper.QuestaoMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.repository.questao.AlternativaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.alternativaMultiplaEscolhaService.AdicionarAlternativaMultiplaEscolhaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdicionarQuestaoMultiplaEscolhaServiceTest {

    @InjectMocks
    AdicionarQuestaoMultiplaEscolhaService adicionarQuestaoMultiplaEscolhaService;

    @Mock
    QuestaoMultiplaEscolhaRepository repository;

    @Mock
    AdicionarAlternativaMultiplaEscolhaService adicionarAlternativaMultiplaEscolhaService;

    @Mock
    AlternativaMultiplaEscolhaRepository repositoryAlternativa;

    @Mock
    QuestaoMultiplaEscolhaMapper mapper;

    @Test
    public void deveChamarAdicionarAlternativaMultiplaEscolhaServiceQuandoAdicionarQuestaoMultiplaEscolhaServiceForChamado() {
        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();
        QuestaoMultiplaEscolhaRequest questaoMultiplaEscolhaRequest =
                new QuestaoMultiplaEscolhaRequest("Teste!", NivelDeDificuldade.FACIL,
                        Especificidade.JAVASCRIPT
                        , new AlternativaQuestaoMultiplaEscolhaRequest("Y", true)
                        , new AlternativaQuestaoMultiplaEscolhaRequest("Y", true)
                        , new AlternativaQuestaoMultiplaEscolhaRequest("Y", true)
                        , new AlternativaQuestaoMultiplaEscolhaRequest("Y", true)
                        , new AlternativaQuestaoMultiplaEscolhaRequest("Y", true));

        Mockito.when(repository.save(questaoMultiplaEscolha)).thenReturn(questaoMultiplaEscolha);
        Mockito.when(mapper.transformarParaQuestao(questaoMultiplaEscolhaRequest)).thenReturn(questaoMultiplaEscolha);
        adicionarQuestaoMultiplaEscolhaService.adicionar(questaoMultiplaEscolhaRequest);

        Mockito.verify(adicionarAlternativaMultiplaEscolhaService)
                .adicionar(questaoMultiplaEscolhaRequest.getAlternativaA(), questaoMultiplaEscolha);

    }
}