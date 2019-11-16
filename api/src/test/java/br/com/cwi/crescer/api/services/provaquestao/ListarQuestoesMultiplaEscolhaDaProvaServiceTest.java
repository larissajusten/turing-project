package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoMultiplaEscolha;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ListarQuestoesMultiplaEscolhaDaProvaServiceTest {

    @InjectMocks
    ListarQuestoesMultiplaEscolhaDaProvaService listarQuestoesMultiplaEscolhaDaProvaService;

    @Mock
    ProvaQuestaoMultiplaEscolhaRepository repository;

    @Test
    public void deveChamar() {

        Prova prova = new Prova();
        List<ProvaQuestaoMultiplaEscolha> provaQuestaoMultiplaEscolhas = new ArrayList<>();

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(provaQuestaoMultiplaEscolhas);

        listarQuestoesMultiplaEscolhaDaProvaService.listar(prova.getId());

        Mockito.verify(repository).findAllByProvaIdEquals(prova.getId());
    }
}