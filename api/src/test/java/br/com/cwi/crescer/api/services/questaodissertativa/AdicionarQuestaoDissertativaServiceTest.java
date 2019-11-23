package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.mapper.QuestaoDissertativaMapper;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import br.com.cwi.crescer.api.security.LoggedUser;
import br.com.cwi.crescer.api.services.autenticacao.VerificarPerfilUsuarioLogadoService;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPeloEmailService;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPorIdService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdicionarQuestaoDissertativaServiceTest {

    @InjectMocks
    AdicionarQuestaoDissertativaService adicionarQuestaoDissertativaService;

    @Mock
    QuestaoDissertativaRepository repository;

    @Mock
    QuestaoDissertativaMapper mapper;

    @Mock
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Mock
    VerificarPerfilUsuarioLogadoService verificarPerfilUsuarioLogadoService;

    @Mock
    BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    @Mock
    LoggedUser loggedUser;

    @Test
    public void deveChamarQuestaoDissertativaRepositoryQuandoAdicionarQuestaoDissertativaServiceForChamado() {

        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        QuestaoUnicaAlternativaRequest questaoUnicaAlternativaRequest =
                new QuestaoUnicaAlternativaRequest("O que é?", Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);

        Mockito.when(mapper.transformar(questaoUnicaAlternativaRequest)).thenReturn(questaoDissertativa);

        adicionarQuestaoDissertativaService.adicionar(questaoUnicaAlternativaRequest);

       Mockito.verify(repository).save(questaoDissertativa);

    }
}