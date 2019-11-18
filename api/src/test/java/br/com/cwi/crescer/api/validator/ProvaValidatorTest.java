package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.exception.usuario.UsuariojaTemProvaEmVigorException;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ProvaValidatorTest {

    @InjectMocks
    ProvaValidator provaValidator;

    @Mock
    ProvaRepository provaRepository;


    @Test
    public void deveChamarProvaRepositoryQuandoProvaValidatorMetodoVerificarSeEmailDoCandidatoTemProvaEmAbertoNoSistemaForChamado() {

        Mockito.when(provaRepository.existsByEmailEqualsAndStatusEquals("email@aqui.com", StatusProva.ATIVA))
                .thenReturn(false);

        provaValidator.verificarSeEmailDoCandidatoTemProvaEmAbertoNoSistema("email@aqui.com");

        Mockito.verify(provaRepository).existsByEmailEqualsAndStatusEquals("email@aqui.com", StatusProva.ATIVA);
    }

    @Test(expected = UsuariojaTemProvaEmVigorException.class)
    public void deveDispararUmaExceptionQuandoProvaValidatorMetodoVerificarSeEmailDoCandidatoTemProvaEmAbertoNoSistemaForChamadoEAcharUmaProva() {

        Mockito.when(provaRepository.existsByEmailEqualsAndStatusEquals("email@aqui.com", StatusProva.ATIVA))
                .thenReturn(true);

        provaValidator.verificarSeEmailDoCandidatoTemProvaEmAbertoNoSistema("email@aqui.com");

    }
}