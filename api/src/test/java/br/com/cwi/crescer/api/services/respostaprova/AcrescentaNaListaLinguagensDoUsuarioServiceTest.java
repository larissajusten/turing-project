package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.responses.LinguagensResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AcrescentaNaListaLinguagensDoUsuarioServiceTest {

    @InjectMocks
    AcrescentaNaListaLinguagensDoUsuarioService acrescentaNaListaLinguagensDoUsuarioService;

    @Mock
    RetornaTotalPorLinguagemService retornaTotalPorLinguagemService;

    @Test
    public void deveChamarRetornaTotalPorLinguagemServiceQuandoAcrescentaNaListaLinguagensDoUsuarioServiceForChamado() {
        LinguagensResponse linguagensResponse = new LinguagensResponse();
        List<LinguagensResponse> lista = new ArrayList<>();

        Mockito.when(retornaTotalPorLinguagemService.retornar(Especificidade.JAVASCRIPT)).thenReturn(1);

        acrescentaNaListaLinguagensDoUsuarioService.retornar(lista, Especificidade.JAVASCRIPT);

        Mockito.verify(retornaTotalPorLinguagemService).retornar(Especificidade.JAVASCRIPT);
    }
}