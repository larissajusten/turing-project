package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
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
public class BuscarProvasRanqueadasServiceTest {

    @InjectMocks
    BuscarProvasRanqueadasService buscarProvasRanqueadasService;

    @Mock
    ProvaRepository repository;

    @Test
    public void deveRetornarUmaPaginaComProvasQuandoBuscarProvasRanqueadasServiceForChamado() {
        Prova provaNotaRuim = new Prova();
        provaNotaRuim.setNota(4);
        Prova provaNotaBoa = new Prova();
        provaNotaBoa.setNota(10);

        PageRequest page = PageRequest.of(1, 10);
        List<Prova> provas = new ArrayList<>();
        provas.add(provaNotaRuim);
        provas.add(provaNotaBoa);

        Page<Prova> pageProvas = new PageImpl<>(provas, page, provas.size());

        Mockito.when(repository.findAllByOrderByNotaDesc(page)).thenReturn(pageProvas);
        Assert.assertEquals(pageProvas, buscarProvasRanqueadasService.buscar(page));

    }
}