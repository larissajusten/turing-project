package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AcrescentarQuantasVezesUsadaQuestaoTecnicaServiceTest {

    @InjectMocks
    AcrescentarQuantasVezesUsadaQuestaoTecnicaService acrescentarQuantasVezesUsadaQuestaoTecnicaService;

    @Mock
    QuestaoTecnicaRepository questaoTecnicaRepository;

    @Test
    public void deveAcrescentar1AoValorTotalDeVezesQueFoiUsadaAQuestaoQuandoAcrescentarQuantiaDeVezesUsadaQuestaoTecnicaServiceForChamado() {
        List<QuestaoTecnica> questoesTecnicas = new ArrayList<>();
        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        questaoTecnica.setVezesUsada(1);
        questoesTecnicas.add(questaoTecnica);

        Mockito.when(questaoTecnicaRepository.save(questaoTecnica)).thenReturn(questaoTecnica);
        acrescentarQuantasVezesUsadaQuestaoTecnicaService.acrescentar(questoesTecnicas);

        Assert.assertEquals(2, questaoTecnica.getVezesUsada());
    }

    @Test
    public void deveChamarQuestaoTecnicaRepositoryQuandoAcrescentarQuantiaDeVezesUsadaQuestaoTecnicaServiceForChamado() {
        List<QuestaoTecnica> questoesTecnicas = new ArrayList<>();
        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        questaoTecnica.setVezesUsada(1);
        questoesTecnicas.add(questaoTecnica);

        Mockito.when(questaoTecnicaRepository.save(questaoTecnica)).thenReturn(questaoTecnica);
        acrescentarQuantasVezesUsadaQuestaoTecnicaService.acrescentar(questoesTecnicas);

        Mockito.verify(questaoTecnicaRepository).save(questaoTecnica);
    }

}