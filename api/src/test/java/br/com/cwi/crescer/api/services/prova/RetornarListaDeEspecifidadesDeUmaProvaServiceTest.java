package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RetornarListaDeEspecifidadesDeUmaProvaServiceTest {
    RetornarListaDeEspecifidadesDeUmaProvaService retornarListaDeEspecifidadesDeUmaProvaService =
            new RetornarListaDeEspecifidadesDeUmaProvaService();

    @Test
    public void deveRetornarListaDeEspecificidades() {
        List<Especificidade> especificidades = new ArrayList<>();
        especificidades.add(Especificidade.JAVASCRIPT);

        List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = new ArrayList<>();
        questoesTecnicas.add(new QuestaoTecnicaComRespostaResponse(Especificidade.JAVASCRIPT, Long.valueOf(1), "resposta",
                "questao", "comentario", 0d));

        List<QuestaoMultiplaEscolhaComRespostaResponse> questoesMultipla = new ArrayList<>();
        questoesMultipla.add(new QuestaoMultiplaEscolhaComRespostaResponse(Long.valueOf(1), new AlternativaMultiplaEscolha(),
                "questao", Especificidade.JAVASCRIPT, 0d));

        List<QuestaoDissertativaComRespostaResponse> questoesDissertativa = new ArrayList<>();
        questoesDissertativa.add(new QuestaoDissertativaComRespostaResponse(Long.valueOf(1), "resposta",
                "comentario", "questao", Especificidade.JAVASCRIPT, 0d));

        List<Especificidade> resultado = retornarListaDeEspecifidadesDeUmaProvaService.retornar(questoesTecnicas,
                questoesDissertativa, questoesMultipla);

        Assert.assertEquals(especificidades, resultado);
    }
}
