package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaParaCorrecaoResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaParaCorrecaoResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
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
public class BuscarProvaPorIdParaCorrecaoServiceTest {

    @InjectMocks
    BuscarProvaPorIdParaCorrecaoService buscarProvaPorIdParaCorrecaoService;

    @Mock
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Mock
    RespostasDissertativaRepository respostasDissertativaRepository;

    @Mock
    RespostasTecnicaRepository respostasTecnicaRepository;

    @Mock
    RespostaMultiplaEscolhaRepository respostaMultiplaEscolhaRepository;

    @Test
    public void deveChamarbuscarProvaPorIdServiceQuandoBuscarProvaComRespostasDoUsuarioServiceForChamado() {
        Prova prova = new Prova();


        List<RespostasDissertativaProva> respostasDissertativas = new ArrayList<>();
        List<RespostasTecnicaProva> respostasTecnicas = new ArrayList<>();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(respostasDissertativaRepository.findAllByProvaIdEquals(prova.getId()))
                .thenReturn(respostasDissertativas);
        Mockito.when(respostasTecnicaRepository.findAllByProvaIdEquals(prova.getId()))
                .thenReturn(respostasTecnicas);


        buscarProvaPorIdParaCorrecaoService.buscar(prova.getId());

        Mockito.verify(buscarProvaPorIdService).buscar(prova.getId());
    }

    @Test
    public void deveChamarRespostasDissertativaRepositoryQuandoBuscarProvaComRespostasDoUsuarioServiceForChamado() {

        Prova prova = new Prova();

        List<RespostasDissertativaProva> respostasDissertativas = new ArrayList<>();
        List<RespostasTecnicaProva> respostasTecnicas = new ArrayList<>();

        RespostasDissertativaProva questaoDissertativa = new RespostasDissertativaProva();
        questaoDissertativa.setNota(10);
        questaoDissertativa.setProva(prova);
        questaoDissertativa.setQuestaoDissertativa(new QuestaoDissertativa());
        questaoDissertativa.setResposta("Errei");
        questaoDissertativa.setComentario("Acertou");
        QuestaoDissertativaParaCorrecaoResponse respostaDissertativaResponse = new QuestaoDissertativaParaCorrecaoResponse();

        respostaDissertativaResponse.setQuestao(questaoDissertativa.getQuestaoDissertativa().getQuestao());
        respostaDissertativaResponse.setIdResposta(questaoDissertativa.getId());
        respostaDissertativaResponse.setIdQuestao(questaoDissertativa.getQuestaoDissertativa().getId());
        respostaDissertativaResponse.setResposta(questaoDissertativa.getResposta());

        respostasDissertativas.add(questaoDissertativa);

        QuestaoTecnicaParaCorrecaoResponse respostaTecnicaResponse = new QuestaoTecnicaParaCorrecaoResponse();

        RespostasTecnicaProva respostasTecnicaProva = new RespostasTecnicaProva();
        respostasTecnicaProva.setNota(10);
        respostasTecnicaProva.setProva(prova);
        respostasTecnicaProva.setQuestaoTecnica(new QuestaoTecnica());
        respostasTecnicaProva.setResposta("Errei");
        respostasTecnicaProva.setComentario("Acertou");

        respostaTecnicaResponse.setQuestao(respostasTecnicaProva.getQuestaoTecnica().getQuestao());
        respostaTecnicaResponse.setIdQuestao(respostasTecnicaProva.getQuestaoTecnica().getId());
        respostaTecnicaResponse.setIdResposta(respostasTecnicaProva.getId());
        respostaTecnicaResponse.setResposta(respostasTecnicaProva.getResposta());

        respostasTecnicas.add(respostasTecnicaProva);

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(respostasDissertativaRepository.findAllByProvaIdEquals(prova.getId()))
                .thenReturn(respostasDissertativas);
        Mockito.when(respostasTecnicaRepository.findAllByProvaIdEquals(prova.getId()))
                .thenReturn(respostasTecnicas);


        buscarProvaPorIdParaCorrecaoService.buscar(prova.getId());

        Mockito.verify(respostasDissertativaRepository).findAllByProvaIdEquals(prova.getId());
    }
}