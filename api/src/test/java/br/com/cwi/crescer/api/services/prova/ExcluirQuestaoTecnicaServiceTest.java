package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoTecnica;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoTecnicaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExcluirQuestaoTecnicaServiceTest {

    @InjectMocks
    ExcluirQuestaoTecnicaService excluirQuestaoTecnicaService;

    @Mock
    ProvaQuestaoTecnicaRepository repository;

    @Test
    public void deveChamarProvaQuestaoTecnicaRepositoryQuandoExcluirQuestaoTecnicaServiceForChamado () {

        ProvaQuestaoTecnica provaQuestaoTecnica = new ProvaQuestaoTecnica();
        Prova prova = new Prova();

        excluirQuestaoTecnicaService.excluir(provaQuestaoTecnica.getId(), prova.getId());

        Mockito.verify(repository).deleteByQuestaoIdAndProvaId(provaQuestaoTecnica.getId(), prova.getId());
    }


}