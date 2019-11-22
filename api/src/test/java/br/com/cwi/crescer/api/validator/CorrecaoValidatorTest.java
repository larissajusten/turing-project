package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.exception.prova.CorrecaoNaoCompletadaException;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CorrecaoValidatorTest {

    @InjectMocks
    CorrecaoValidator correcaoValidator;

    @Mock
    RespostasDissertativaRepository respostasDissertativaRepository;

    @Mock
    RespostasTecnicaRepository respostasTecnicaRepository;

    @Test
    public void deveChamarRespostasTecnicaRepositoryQuandoCorrecaoValidatorForChamado() {

        Prova prova = new Prova();
        RespostasTecnicaProva respostasTecnicaProva = new RespostasTecnicaProva();
        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();

        List<RespostasTecnicaProva> listaTecnicas = new ArrayList<>();
        listaTecnicas.add(respostasTecnicaProva);
        respostasTecnicaProva.setComentario("Corrigido.");

        List<RespostasDissertativaProva> listaDissertativas = new ArrayList<>();
        listaDissertativas.add(respostasDissertativaProva);
        respostasDissertativaProva.setComentario("Corrigido.");

        Mockito.when(respostasTecnicaRepository.findAllByProvaIdEquals(prova.getId())).thenReturn(listaTecnicas);
        Mockito.when(respostasDissertativaRepository.findAllByProvaIdEquals(prova.getId())).thenReturn(listaDissertativas);

        correcaoValidator.validar(prova.getId());

        Mockito.verify(respostasTecnicaRepository).findAllByProvaIdEquals(prova.getId());

    }

    @Test(expected = CorrecaoNaoCompletadaException.class)
    public void deveLancarUmaExceptionQuandoAlgumaRespostaTecnicaNaoTiverComentadaQuandoCorrecaoValidatorForChamado() {

        Prova prova = new Prova();
        RespostasTecnicaProva respostasTecnicaProva = new RespostasTecnicaProva();
        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();

        List<RespostasTecnicaProva> listaTecnicas = new ArrayList<>();
        listaTecnicas.add(respostasTecnicaProva);

        List<RespostasDissertativaProva> listaDissertativas = new ArrayList<>();
        listaDissertativas.add(respostasDissertativaProva);
        respostasDissertativaProva.setComentario("Corrigido.");

        Mockito.when(respostasTecnicaRepository.findAllByProvaIdEquals(prova.getId())).thenReturn(listaTecnicas);
        Mockito.when(respostasDissertativaRepository.findAllByProvaIdEquals(prova.getId())).thenReturn(listaDissertativas);

        correcaoValidator.validar(prova.getId());

    }

    @Test(expected = CorrecaoNaoCompletadaException.class)
    public void deveLancarUmaExceptionQuandoAlgumaRespostasDissertativaNaoTiverComentadaQuandoCorrecaoValidatorForChamado() {

        Prova prova = new Prova();
        RespostasTecnicaProva respostasTecnicaProva = new RespostasTecnicaProva();
        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();

        List<RespostasTecnicaProva> listaTecnicas = new ArrayList<>();
        listaTecnicas.add(respostasTecnicaProva);
        respostasTecnicaProva.setComentario("Corrigido.");

        List<RespostasDissertativaProva> listaDissertativas = new ArrayList<>();
        listaDissertativas.add(respostasDissertativaProva);

        Mockito.when(respostasTecnicaRepository.findAllByProvaIdEquals(prova.getId())).thenReturn(listaTecnicas);
        Mockito.when(respostasDissertativaRepository.findAllByProvaIdEquals(prova.getId())).thenReturn(listaDissertativas);

        correcaoValidator.validar(prova.getId());

    }
}