package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
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
public class BuscarNumeroDeVezesQuestoesMultiplaPorEspecificidadeServiceTest {

    @InjectMocks
    BuscarNumeroDeVezesQuestoesMultiplaPorEspecificidadeService buscarNumeroDeVezesQuestoesMultiplaPorEspecificidadeService;

    @Mock
    QuestaoMultiplaEscolhaRepository repository;

    @Test
    public void deveRetornarUmValorInteiroReferenteAQuantiaDeVezesQueAQuestaoFoiUsadaQuandoBuscarNumeroDeVezesQuestoesMultiplaPorEspecificidadeServiceForChamado() {

        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();
        List<QuestaoMultiplaEscolha> lista = new ArrayList<>();
        questaoMultiplaEscolha.setVezesUsada(2);
        lista.add(questaoMultiplaEscolha);

        Mockito.when(repository.findByEspecificidade(Especificidade.JAVASCRIPT)).thenReturn(lista);
        Assert.assertEquals(1, buscarNumeroDeVezesQuestoesMultiplaPorEspecificidadeService.buscar(Especificidade.JAVASCRIPT));

    }

}