package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AcrescentarQuantiaDeVezesUsadaQuestaoDissertativaServiceTest {

    @InjectMocks
    AcrescentarQuantiaDeVezesUsadaQuestaoDissertativaService acrescentarQuantiaDeVezesUsadaQuestaoDissertativaService;

    @Mock
    QuestaoDissertativaRepository questaoDissertativaRepository;

    @Test
    public void deveChamar() {
        List<QuestaoDissertativa> questoes = new ArrayList<>();
        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        questoes.add(questaoDissertativa);

        acrescentarQuantiaDeVezesUsadaQuestaoDissertativaService.addVezesQuestaoDissertativa(questoes);

        Mockito.verify(questaoDissertativaRepository).save(questaoDissertativa);

    }
}