package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.controller.requests.questoes.AlternativaMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.mapper.QuestaoMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.repository.questao.AlternativaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.security.LoggedUser;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.AdicionarAlternativaMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.autenticacao.VerificarPerfilUsuarioLogadoService;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPorIdService;
import br.com.cwi.crescer.api.validator.UnicaAlternativaCorretaValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdicionarQuestaoMultiplaEscolhaServiceTest {

    @InjectMocks
    AdicionarQuestaoMultiplaEscolhaService adicionarQuestaoMultiplaEscolhaService;

    @Mock
    QuestaoMultiplaEscolhaRepository repository;

    @Mock
    AdicionarAlternativaMultiplaEscolhaService adicionarAlternativaMultiplaEscolhaService;

    @Mock
    AlternativaMultiplaEscolhaRepository repositoryAlternativa;

    @Mock
    QuestaoMultiplaEscolhaMapper mapper;

    @Mock
    UnicaAlternativaCorretaValidator unicaAlternativaCorretaValidator;

    @Mock
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Mock
    VerificarPerfilUsuarioLogadoService verificarPerfilUsuarioLogadoService;

    @Mock
    LoggedUser loggedUser;


    @Test
    public void deveChamarAdicionarAlternativaMultiplaEscolhaServiceQuandoAdicionarQuestaoMultiplaEscolhaServiceForChamado() {
        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();
        QuestaoMultiplaEscolhaRequest questaoMultiplaEscolhaRequest =
                new QuestaoMultiplaEscolhaRequest("Teste!", NivelDeDificuldade.FACIL,
                        Especificidade.JAVASCRIPT
                        , new AlternativaMultiplaEscolhaRequest("Y", true)
                        , new AlternativaMultiplaEscolhaRequest("Y", true)
                        , new AlternativaMultiplaEscolhaRequest("Y", true)
                        , new AlternativaMultiplaEscolhaRequest("Y", true)
                        , new AlternativaMultiplaEscolhaRequest("Y", true));

        Mockito.doNothing().when(unicaAlternativaCorretaValidator).validar(questaoMultiplaEscolhaRequest);
        Mockito.when(repository.save(questaoMultiplaEscolha)).thenReturn(questaoMultiplaEscolha);
        Mockito.when(mapper.transformarParaQuestao(questaoMultiplaEscolhaRequest)).thenReturn(questaoMultiplaEscolha);
        Mockito.doNothing().when(verificarPerfilUsuarioLogadoService).verificar(loggedUser);

        Usuario usuario = new Usuario();
        Mockito.when(buscarUsuarioPorIdService.buscar(1L)).thenReturn(usuario);

        adicionarQuestaoMultiplaEscolhaService.adicionar(questaoMultiplaEscolhaRequest);

        Mockito.verify(adicionarAlternativaMultiplaEscolhaService)
                .adicionar(questaoMultiplaEscolhaRequest.getAlternativaA(), questaoMultiplaEscolha);

    }
}