package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
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
public class BuscarNumeroDeVezesQuestoesTecnicasPorEspecificidadeServiceTest {

    @InjectMocks
    BuscarNumeroDeVezesQuestoesTecnicasPorEspecificidadeService buscarNumeroDeVezesQuestoesTecnicasPorEspecificidadeService;

    @Mock
    QuestaoTecnicaRepository repository;

    @Test
    public void deveRetornarUmInteiroComAQuantiaDeVezesQueAQuestaoFoiUsadaQuandoBuscarNumeroDeVezesQuestoesTecnicasPorEspecificidadeServiceForChamado() {

        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        List<QuestaoTecnica> lista = new ArrayList<>();
        lista.add(questaoTecnica);
        questaoTecnica.setVezesUsada(1);
        Mockito.when(repository.findByEspecificidade(Especificidade.JAVASCRIPT)).thenReturn(lista);

        Assert.assertEquals(1, buscarNumeroDeVezesQuestoesTecnicasPorEspecificidadeService.buscar(Especificidade.JAVASCRIPT));
    }
}