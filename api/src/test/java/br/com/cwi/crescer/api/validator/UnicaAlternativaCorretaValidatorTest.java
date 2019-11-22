package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.controller.requests.questoes.AlternativaMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.exception.questoes.MultiplaEscolhaException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UnicaAlternativaCorretaValidatorTest {

    @InjectMocks
    UnicaAlternativaCorretaValidator unicaAlternativaCorretaValidator;

    @Test(expected = MultiplaEscolhaException.class)
    public void deveLancarExceptionQuandoNaoHouverUmaAlternativaCorreta() {

        AlternativaMultiplaEscolhaRequest alternativaMultiplaEscolhaA = new AlternativaMultiplaEscolhaRequest("A", false);
        AlternativaMultiplaEscolhaRequest alternativaMultiplaEscolhaB = new AlternativaMultiplaEscolhaRequest("B", false);
        AlternativaMultiplaEscolhaRequest alternativaMultiplaEscolhaC = new AlternativaMultiplaEscolhaRequest("C", false);
        AlternativaMultiplaEscolhaRequest alternativaMultiplaEscolhaD = new AlternativaMultiplaEscolhaRequest("D", false);
        AlternativaMultiplaEscolhaRequest alternativaMultiplaEscolhaE = new AlternativaMultiplaEscolhaRequest("E", false);

        QuestaoMultiplaEscolhaRequest questaoMultiplaEscolhaRequest = new QuestaoMultiplaEscolhaRequest(
                "Teste",
                NivelDeDificuldade.DIFICIL,
                Especificidade.JAVA,
                alternativaMultiplaEscolhaA,
                alternativaMultiplaEscolhaB,
                alternativaMultiplaEscolhaC,
                alternativaMultiplaEscolhaD,
                alternativaMultiplaEscolhaE
        );

        unicaAlternativaCorretaValidator.validar(questaoMultiplaEscolhaRequest);
    }

    @Test(expected = MultiplaEscolhaException.class)
    public void deveLancarExceptionQuandoHoverMaisDeUmaOpcaoCorreta() {

        AlternativaMultiplaEscolhaRequest alternativaMultiplaEscolhaA = new AlternativaMultiplaEscolhaRequest("A", true);
        AlternativaMultiplaEscolhaRequest alternativaMultiplaEscolhaB = new AlternativaMultiplaEscolhaRequest("B", true);
        AlternativaMultiplaEscolhaRequest alternativaMultiplaEscolhaC = new AlternativaMultiplaEscolhaRequest("C", true);
        AlternativaMultiplaEscolhaRequest alternativaMultiplaEscolhaD = new AlternativaMultiplaEscolhaRequest("D", true);
        AlternativaMultiplaEscolhaRequest alternativaMultiplaEscolhaE = new AlternativaMultiplaEscolhaRequest("E", true);

        QuestaoMultiplaEscolhaRequest questaoMultiplaEscolhaRequest = new QuestaoMultiplaEscolhaRequest(
                "Teste",
                NivelDeDificuldade.DIFICIL,
                Especificidade.JAVA,
                alternativaMultiplaEscolhaA,
                alternativaMultiplaEscolhaB,
                alternativaMultiplaEscolhaC,
                alternativaMultiplaEscolhaD,
                alternativaMultiplaEscolhaE
        );

        unicaAlternativaCorretaValidator.validar(questaoMultiplaEscolhaRequest);
    }

}