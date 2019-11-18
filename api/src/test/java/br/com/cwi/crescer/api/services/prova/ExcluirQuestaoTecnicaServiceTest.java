package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoTecnicaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoTecnica;

@RunWith(MockitoJUnitRunner.class)
public class ExcluirQuestaoTecnicaServiceTest {

    @InjectMocks
    ExcluirQuestaoTecnicaService excluirQuestaoTecnicaService;

    @Mock
    ProvaQuestaoTecnicaRepository repository;

    @Test
    public void deveChamarProvaQuestaoTecnicaRepositoryQuandoExcluirQuestaoTecnicaServiceForChamado () {

        ProvaQuestaoTecnica provaQuestaoTecnica = new ProvaQuestaoTecnica();

        excluirQuestaoTecnicaService.excluir(provaQuestaoTecnica.getId());

        Mockito.verify(repository).deleteById(provaQuestaoTecnica.getId());
    }


}