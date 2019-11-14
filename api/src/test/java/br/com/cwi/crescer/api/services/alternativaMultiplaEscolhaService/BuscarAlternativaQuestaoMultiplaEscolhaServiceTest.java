package br.com.cwi.crescer.api.services.alternativaMultiplaEscolhaService;

import br.com.cwi.crescer.api.repository.questao.AlternativaMultiplaEscolhaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BuscarAlternativaQuestaoMultiplaEscolhaServiceTest {

    @InjectMocks
    BuscarAlternativaQuestaoMultiplaEscolhaService buscarAlternativaQuestaoMultiplaEscolhaService;

    @Mock
    AlternativaMultiplaEscolhaRepository repository;


    @Test
    public void deveChamarFindAllByQuestaoMultiplaEscolhaEqualsDoRepositoryQuandoBuscarAlternativaQuestaoMultiplaEscolhaServiceForChamado() {

        buscarAlternativaQuestaoMultiplaEscolhaService.buscar(1L);

        Mockito.verify(repository).findAllByQuestaoMultiplaEscolhaEquals(1L);
    }
}