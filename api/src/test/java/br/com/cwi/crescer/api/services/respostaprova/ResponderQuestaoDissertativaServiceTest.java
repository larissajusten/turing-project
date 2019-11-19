package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdService;
import br.com.cwi.crescer.api.services.questaodissertativa.BuscarQuestaoDissertativaPorIdService;
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

    @Test
    public void deveChamarBuscarProvaPorIdServiceQuandoResponderQuestaoDissertativaServiceForChamado() {

        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        Prova prova = new Prova();
        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(buscarQuestaoDissertativaPorIdService.buscar(questaoDissertativa.getId())).thenReturn(questaoDissertativa);

        responderQuestaoDissertativaService.responder(prova.getId(), questaoDissertativa.getId(), "Resposta");

        Mockito.verify(buscarProvaPorIdService).buscar(prova.getId());

    }

    @Test
    public void deveChamarBuscarQuestaoDissertativaPorIdServiceQuandoResponderQuestaoDissertativaServiceForChamado() {

        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        Prova prova = new Prova();
        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(buscarQuestaoDissertativaPorIdService.buscar(questaoDissertativa.getId())).thenReturn(questaoDissertativa);

        responderQuestaoDissertativaService.responder(prova.getId(), questaoDissertativa.getId(), "Resposta");

        Mockito.verify(buscarQuestaoDissertativaPorIdService).buscar(questaoDissertativa.getId());

    }


    @Test
    public void deveChamarRespostasDissertativaRepositoryQuandoResponderQuestaoDissertativaServiceForChamado() {

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        Prova prova = new Prova();
        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();
        respostasDissertativaProva.setQuestaoDissertativa(questaoDissertativa);
        respostasDissertativaProva.setUsuario(usuario);
        respostasDissertativaProva.setProva(prova);
        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(buscarQuestaoDissertativaPorIdService.buscar(questaoDissertativa.getId())).thenReturn(questaoDissertativa);
        Mockito.when(repository.save(respostasDissertativaProva)).thenReturn(respostasDissertativaProva);

        responderQuestaoDissertativaService.responder(prova.getId(), questaoDissertativa.getId(), null);

        Mockito.verify(repository).save(respostasDissertativaProva);

    }


    @Test
    public void deveRetornarRespostasDissertativaProvaQuandoResponderQuestaoDissertativaServiceForChamado() {

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        Prova prova = new Prova();
        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();
        respostasDissertativaProva.setQuestaoDissertativa(questaoDissertativa);
        respostasDissertativaProva.setUsuario(usuario);
        respostasDissertativaProva.setProva(prova);
        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(buscarQuestaoDissertativaPorIdService.buscar(questaoDissertativa.getId())).thenReturn(questaoDissertativa);
        Mockito.when(repository.save(respostasDissertativaProva)).thenReturn(respostasDissertativaProva);

        responderQuestaoDissertativaService.responder(prova.getId(), questaoDissertativa.getId(), null);

        Assert.assertEquals(responderQuestaoDissertativaService.responder(prova.getId(),
                questaoDissertativa.getId(),
                null),
                respostasDissertativaProva);

    }

}