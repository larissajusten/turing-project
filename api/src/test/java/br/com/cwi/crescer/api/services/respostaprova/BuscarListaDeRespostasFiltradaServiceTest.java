package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.enums.Perfil;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BuscarListaDeRespostasFiltradaServiceTest {

    @Mock
    RespostaMultiplaEscolhaRepository repository;

    @Mock
    QuestaoMultiplaEscolhaRepository questaoRepository;

    @InjectMocks
    BuscarListaDeRespostasFiltradaService buscarListaDeRespostasFiltradaService;

    @Test
    public void testRetornar() {

        String email = "email";

        Prova prova = new Prova(1L, LocalDateTime.of(2019, Month.NOVEMBER, 28, 11,
                16, 26), LocalDateTime.of(2019, Month.NOVEMBER, 28, 11, 16,
                26), "emailCandidato", 0, 0, StatusProva.ATIVA,
                0d, "nomeCandidato");

        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva(Long.valueOf(1),
                new AlternativaMultiplaEscolha(), new QuestaoMultiplaEscolha(Long.valueOf(1), LocalDate.of(2019, Month.NOVEMBER,
                28), "questao", Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 0), prova);


        List<QuestaoMultiplaEscolha> questoes = new ArrayList<>();
        questoes.add(new QuestaoMultiplaEscolha(Long.valueOf(1), LocalDate.of(2019, Month.NOVEMBER, 28),
                "questao", Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 0));

        List<RespostasMultiplaEscolhaProva> respostas = new ArrayList<>();

        respostas.add(respostasMultiplaEscolhaProva);

        when(repository.findAllByQuestaoMultiplaEscolhaIdEquals(anyLong())).thenReturn(respostas);
        when(questaoRepository.acharPorNivelEEspecificidadeListado(any(), any())).thenReturn(questoes);

        List<RespostasMultiplaEscolhaProva> result = buscarListaDeRespostasFiltradaService.retornar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);
        Assert.assertEquals(respostas, result);
    }
}
