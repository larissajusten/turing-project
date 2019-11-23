package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
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
public class AcrescentarQuantasVezesUsadaQuestaoMultiplaEscolhaServiceTest {

    @InjectMocks
    AcrescentarQuantasVezesUsadaQuestaoMultiplaEscolhaService acrescentarQuantasVezesUsadaQuestaoMultiplaEscolhaService;

    @Mock
    QuestaoMultiplaEscolhaRepository questaoMultiplaEscolhaRepository;


    @Test
    public void deveChamarQuestaoMultiplaEscolhaRepositoryQuandoAcrescentarQuantiaDeVezesUsadaQuestaoMultiplaEscolhaServiceForChamado() {
        List<QuestaoMultiplaEscolha> questoes = new ArrayList<>();
        QuestaoMultiplaEscolha questao = new QuestaoMultiplaEscolha();
        questoes.add(questao);
        questao.setVezesUsada(1);

        Mockito.when(questaoMultiplaEscolhaRepository.save(questao)).thenReturn(questao);

        acrescentarQuantasVezesUsadaQuestaoMultiplaEscolhaService.acrescentar(questoes);

        Mockito.verify(questaoMultiplaEscolhaRepository).save(questao);


    }

    @Test
    public void deveSomarMaisUmAOValorDeVezesUsadaDaQuestaoQuandoAcrescentarQuantiaDeVezesUsadaQuestaoMultiplaEscolhaServiceForChamado() {
        List<QuestaoMultiplaEscolha> questoes = new ArrayList<>();
        QuestaoMultiplaEscolha questao = new QuestaoMultiplaEscolha();
        questoes.add(questao);
        questao.setVezesUsada(1);

        Mockito.when(questaoMultiplaEscolhaRepository.save(questao)).thenReturn(questao);

        acrescentarQuantasVezesUsadaQuestaoMultiplaEscolhaService.acrescentar(questoes);

        Assert.assertEquals(2, questao.getVezesUsada());


    }

}