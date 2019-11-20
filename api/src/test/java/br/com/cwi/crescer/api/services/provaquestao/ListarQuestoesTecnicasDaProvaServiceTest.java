package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoTecnica;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoTecnicaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ListarQuestoesTecnicasDaProvaServiceTest {

    @InjectMocks
    ListarQuestoesTecnicasDaProvaService listarQuestoesTecnicasDaProvaService;

    @Mock
    ProvaQuestaoTecnicaRepository repository;


    @Test
    public void deveChamarProvaQuestaoTecnicaRepositoryQuandoListarQuestoesTecnicasDaProvaServiceForChamado() {
        Prova prova = new Prova();
        List<ProvaQuestaoTecnica> provaQuestaoMultiplaEscolhas = new ArrayList<>();

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(provaQuestaoMultiplaEscolhas);

        listarQuestoesTecnicasDaProvaService.listar(prova.getId());

        Mockito.verify(repository).findAllByProvaIdEquals(prova.getId());

    }

}