package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaParaCorrecaoResponse;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarProvasParaCorrecaoServiceTest {

    @InjectMocks
    BuscarProvasParaCorrecaoService buscarProvasParaCorrecaoService;

    @Mock
    ProvaRepository provaRepository;

    @Mock
    ModelMapper mapper;

    @Test
    public void deveRetornarUmaListaDeProvasComStatusAguardandoCorrecaoQuandoBuscarProvasParaCorrecaoServiceForChamado() {

        Prova prova = new Prova();
        ProvaParaCorrecaoResponse provaParaCorrecaoResponseProva = new ProvaParaCorrecaoResponse();

        PageRequest page = PageRequest.of(1, 10);

        List<Prova> listaProvasParaCorrecao = new ArrayList<>();
        listaProvasParaCorrecao.add(prova) ;
        List<ProvaParaCorrecaoResponse> listaProvaCorrecaoResponse = new ArrayList<>();
        listaProvaCorrecaoResponse.add(provaParaCorrecaoResponseProva);

        Page<Prova> pageProva = new PageImpl<>(listaProvasParaCorrecao, page, listaProvasParaCorrecao.size());
        Page<ProvaParaCorrecaoResponse> provaParaCorrecaoResponse = new PageImpl<>(listaProvaCorrecaoResponse, page, listaProvaCorrecaoResponse.size());

        Mockito.when(provaRepository.findAllByStatusEquals(page, StatusProva.AGUARDANDO_CORRECAO)).thenReturn(pageProva);
        Mockito.when(mapper.map(prova, ProvaParaCorrecaoResponse.class)).thenReturn(provaParaCorrecaoResponseProva);

        buscarProvasParaCorrecaoService.buscar(page);

        Assert.assertEquals(provaParaCorrecaoResponse, buscarProvasParaCorrecaoService.buscar(page));
    }
}