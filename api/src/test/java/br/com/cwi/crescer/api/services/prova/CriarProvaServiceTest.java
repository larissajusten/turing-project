package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRequest;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.mapper.ProvaMapper;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import br.com.cwi.crescer.api.validator.ProvaValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CriarProvaServiceTest {

    @InjectMocks
    CriarProvaService criarProvaService;

    @Mock
    ProvaMapper mapper;

    @Mock
    ProvaRepository repository;

    @Mock
    ProvaValidator provaValidator;

    @Test
    public void deveChamarProvaRepositoryQuandoCriarProvaServiceForChamado() {

        ProvaRequest provaRequest =
                new ProvaRequest("teste@mail.com", 1, 5);
        Prova prova = new Prova();

        Mockito.when(mapper.transformar(provaRequest)).thenReturn(prova);
        Mockito.when(repository.save(prova)).thenReturn(prova);
        Mockito.doNothing().when(provaValidator).verificarSeEmailDoCandidatoTemProvaEmAbertoNoSistema(provaRequest.getEmail());
        criarProvaService.criar(provaRequest);

        Mockito.verify(repository).save(prova);

    }

    @Test
    public void deveChamarProvaMapperQuandoCriarProvaServiceForChamado() {
        ProvaRequest provaRequest =
                new ProvaRequest("teste@mail.com", 1, 5);
        Prova prova = new Prova();

        Mockito.when(mapper.transformar(provaRequest)).thenReturn(prova);
        Mockito.when(repository.save(prova)).thenReturn(prova);
        Mockito.doNothing().when(provaValidator).verificarSeEmailDoCandidatoTemProvaEmAbertoNoSistema(provaRequest.getEmail());

        criarProvaService.criar(provaRequest);

        Mockito.verify(mapper).transformar(provaRequest);
    }
    
}