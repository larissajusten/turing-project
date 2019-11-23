package br.com.cwi.crescer.api.services.alternativamultiplaescolha;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.exception.questoes.MultiplaEscolhaException;
import br.com.cwi.crescer.api.repository.questao.AlternativaMultiplaEscolhaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarAlternativaMultiplaEscolhaPorIdServiceTest {

    @InjectMocks
    BuscarAlternativaMultiplaEscolhaPorIdService buscarAlternativaMultiplaEscolhaPorIdService;

    @Mock
    AlternativaMultiplaEscolhaRepository repository;

    @Test
    public void deveChamarAlternativaMultiplaEscolhaRepositoryQuandoBuscarAlternativaMultiplaEscolhaPorIdServiceForChamado() {

        AlternativaMultiplaEscolha alternativaMultiplaEscolha = new AlternativaMultiplaEscolha();

        Mockito.when(repository.findById(alternativaMultiplaEscolha.getId()))
                .thenReturn(Optional.of(alternativaMultiplaEscolha));

        buscarAlternativaMultiplaEscolhaPorIdService.buscar(alternativaMultiplaEscolha.getId());

        Mockito.verify(repository).findById(alternativaMultiplaEscolha.getId());
    }

    @Test(expected = MultiplaEscolhaException.class)
    public void deveDispararUmaExceptionQuandoBuscarAlternativaMultiplaEscolhaPorIdServiceForChamadoENaoAcharUmaAlternativa() {

        AlternativaMultiplaEscolha alternativaMultiplaEscolha = new AlternativaMultiplaEscolha();

        Mockito.when(repository.findById(alternativaMultiplaEscolha.getId()))
                .thenReturn(Optional.empty());

        buscarAlternativaMultiplaEscolhaPorIdService.buscar(alternativaMultiplaEscolha.getId());

    }

    @Test
    public void deveRetornarUmaAlternativaMultiplaEscolhaQuandoBuscarAlternativaMultiplaEscolhaPorIdServiceForChamado() {

        AlternativaMultiplaEscolha alternativaMultiplaEscolha = new AlternativaMultiplaEscolha();

        Mockito.when(repository.findById(alternativaMultiplaEscolha.getId()))
                .thenReturn(Optional.of(alternativaMultiplaEscolha));

        buscarAlternativaMultiplaEscolhaPorIdService.buscar(alternativaMultiplaEscolha.getId());

        Assert.assertEquals(buscarAlternativaMultiplaEscolhaPorIdService
                .buscar(alternativaMultiplaEscolha.getId()), alternativaMultiplaEscolha);
    }


}