package br.com.cwi.crescer.api.services.provaservice;

import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoDissertativa;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestoesDissertativasDeUmaProvaPorIdServiceTest {

    @InjectMocks
    BuscarQuestoesDissertativasDeUmaProvaPorIdService buscarQuestoesDissertativasDeUmaProvaPorIdService;

    @Mock
    ProvaQuestaoDissertativaRepository repository;

    @Mock
    ModelMapper mapper;

    @Test
    public void deveChamarProvaQuestaoDissertativaRepositoryQuandoBuscarQuestoesDissertativasDeUmaProvaPorIdServiceForChamado() {

        Prova prova = new Prova();

        List<ProvaQuestaoDissertativa> questoesDissertativasDaProva = new ArrayList<>();

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(questoesDissertativasDaProva);

        buscarQuestoesDissertativasDeUmaProvaPorIdService.buscar(prova.getId());

        Mockito.verify(repository).findAllByProvaIdEquals(prova.getId());

    }


    @Test
    public void deveChamarModelMapperQuandoBuscarQuestoesDissertativasDeUmaProvaPorIdServiceForChamado() {

        QuestaoDissertativaResponse questaoDissertativaResponse = new QuestaoDissertativaResponse();
        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        ProvaQuestaoDissertativa provaQuestaoDissertativa = new ProvaQuestaoDissertativa();

        Prova prova = new Prova();
        Usuario usuario = new Usuario();

        List<ProvaQuestaoDissertativa> provaQuestaoDissertativas = new ArrayList<>();

        questaoDissertativaResponse.setIdUsuario(usuario.getId());
        provaQuestaoDissertativas.add(provaQuestaoDissertativa);
        provaQuestaoDissertativa.setQuestao(questaoDissertativa);

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(provaQuestaoDissertativas);
        Mockito.when(mapper.map(provaQuestaoDissertativa.getQuestao(), QuestaoDissertativaResponse.class)).thenReturn(questaoDissertativaResponse);

        buscarQuestoesDissertativasDeUmaProvaPorIdService.buscar(prova.getId());

        Mockito.verify(mapper).map(questaoDissertativa, QuestaoDissertativaResponse.class);

    }
}