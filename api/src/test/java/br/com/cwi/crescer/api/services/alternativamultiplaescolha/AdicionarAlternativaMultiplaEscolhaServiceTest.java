package br.com.cwi.crescer.api.services.alternativamultiplaescolha;

import br.com.cwi.crescer.api.controller.requests.questoes.AlternativaMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.mapper.AlternativaMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.repository.questao.AlternativaMultiplaEscolhaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdicionarAlternativaMultiplaEscolhaServiceTest {

    @InjectMocks
    AdicionarAlternativaMultiplaEscolhaService adicionarAlternativaMultiplaEscolha;

    @Mock
    AlternativaMultiplaEscolhaRepository repository;

    @Mock
    AlternativaMultiplaEscolhaMapper mapper;

    @Test
    public void deveChamarOMetodoSaveDoAlternativaMultiplaEscolhaRepositoryQuandoAdicionarAlternativaMultiplaEscolhaForChamado() {

        AlternativaMultiplaEscolhaRequest alternativaRequest =
                new AlternativaMultiplaEscolhaRequest("teste", true);

        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();

        AlternativaMultiplaEscolha alternativa = new AlternativaMultiplaEscolha();

        Mockito.when(mapper.transformar(alternativaRequest, questaoMultiplaEscolha)).thenReturn(alternativa);

        adicionarAlternativaMultiplaEscolha.adicionar(alternativaRequest, questaoMultiplaEscolha);

        Mockito.verify(repository).save(alternativa);

    }
}