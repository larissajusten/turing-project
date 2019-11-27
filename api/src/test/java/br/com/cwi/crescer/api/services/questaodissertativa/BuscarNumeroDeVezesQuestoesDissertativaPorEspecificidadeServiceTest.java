package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
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
public class BuscarNumeroDeVezesQuestoesDissertativaPorEspecificidadeServiceTest {


    @InjectMocks
    BuscarNumeroDeVezesQuestoesDissertativaPorEspecificidadeService buscarNumeroDeVezesQuestoesDissertativaPorEspecificidadeService;

    @Mock
    QuestaoDissertativaRepository repository;

    @Test
    public void deveRetornarUmInteiroComComONumeroDeVezesQueUmaQuestaoFoiUsadaQuandoBuscarNumeroDeVezesQuestoesDissertativaPorEspecificidadeServiceForChamado() {

        QuestaoDissertativa questao = new QuestaoDissertativa();
        questao.setVezesUsada(1);

        List<QuestaoDissertativa> lista = new ArrayList<>();
        lista.add(questao);

        Mockito.when(repository.findByEspecificidade(Especificidade.JAVASCRIPT))
                .thenReturn(lista);

        Assert.assertEquals(1, buscarNumeroDeVezesQuestoesDissertativaPorEspecificidadeService.buscar(Especificidade.JAVASCRIPT));


    }



}