package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdService;
import br.com.cwi.crescer.api.services.questaodissertativa.BuscarQuestaoDissertativaPorIdService;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPorIdService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResponderQuestaoDissertativaServiceTest {

    @InjectMocks
    ResponderQuestaoDissertativaService responderQuestaoDissertativaService;

    @Mock
    RespostasDissertativaRepository repository;

    @Mock
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Mock
    BuscarQuestaoDissertativaPorIdService buscarQuestaoDissertativaPorIdService;

    @Mock
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;


    @Test
    public void deveChamarBuscarQuestaoDissertativaPorIdServiceQuandoResponderQuestaoDissertativaServiceForChamado() {

        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        Prova prova = new Prova();

        Mockito.when(buscarQuestaoDissertativaPorIdService.buscar(questaoDissertativa.getId())).thenReturn(questaoDissertativa);

        responderQuestaoDissertativaService.responder(prova, questaoDissertativa.getId(), "Resposta");

        Mockito.verify(buscarQuestaoDissertativaPorIdService).buscar(questaoDissertativa.getId());

    }


    @Test
    public void deveChamarRespostasDissertativaRepositoryQuandoResponderQuestaoDissertativaServiceForChamado() {

        Prova prova = new Prova();
        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();

        respostasDissertativaProva.setQuestaoDissertativa(questaoDissertativa);
        respostasDissertativaProva.setProva(prova);

        Mockito.when(buscarQuestaoDissertativaPorIdService.buscar(questaoDissertativa.getId())).thenReturn(questaoDissertativa);
        Mockito.when(repository.save(respostasDissertativaProva)).thenReturn(respostasDissertativaProva);

        responderQuestaoDissertativaService.responder(prova, questaoDissertativa.getId(), null);

        Mockito.verify(repository).save(respostasDissertativaProva);

    }


    @Test
    public void deveRetornarRespostasDissertativaProvaQuandoResponderQuestaoDissertativaServiceForChamado() {

        Prova prova = new Prova();
        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();
        respostasDissertativaProva.setQuestaoDissertativa(questaoDissertativa);
        respostasDissertativaProva.setProva(prova);


        Mockito.when(buscarQuestaoDissertativaPorIdService.buscar(questaoDissertativa.getId())).thenReturn(questaoDissertativa);
        Mockito.when(repository.save(respostasDissertativaProva)).thenReturn(respostasDissertativaProva);

        responderQuestaoDissertativaService.responder(prova, questaoDissertativa.getId(), null);

        Assert.assertEquals(responderQuestaoDissertativaService.responder(prova,
                questaoDissertativa.getId(),
                null),
                respostasDissertativaProva);

    }

}