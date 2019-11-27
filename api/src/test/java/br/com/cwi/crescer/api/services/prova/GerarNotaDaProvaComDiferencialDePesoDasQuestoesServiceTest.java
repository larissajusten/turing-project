package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class GerarNotaDaProvaComDiferencialDePesoDasQuestoesServiceTest {

    @InjectMocks
    GerarNotaDaProvaComDiferencialDePesoDasQuestoesService gerarNotaDaProvaComDiferencialDePesoDasQuestoesService;

    @Mock
    RespostasTecnicaRepository respostasTecnicaProva;

    @Mock
    RespostaMultiplaEscolhaRepository respostaMultiplaEscolhaRepository;

    @Mock
    RespostasDissertativaRepository respostasDissertativaProva;

    @Test
    public void deveChamarRespostasDissertativaRepositoryQuandoGerarNotaDaProvaComDiferencialDePesoDasQuestoesServiceForChamado() {
        Prova prova = new Prova();

        gerarNotaDaProvaComDiferencialDePesoDasQuestoesService.gerar(prova);

        Mockito.verify(respostasDissertativaProva).findAllByProvaIdEquals(prova.getId());

    }

    @Test
    public void deveChamarRespostasTecnicaRepositoryQuandoGerarNotaDaProvaComDiferencialDePesoDasQuestoesServiceForChamado() {
        Prova prova = new Prova();

        gerarNotaDaProvaComDiferencialDePesoDasQuestoesService.gerar(prova);

        Mockito.verify(respostasTecnicaProva).findAllByProvaIdEquals(prova.getId());

    }

    @Test
    public void deveChamarRespostaMultiplaEscolhaRepositoryQuandoGerarNotaDaProvaComDiferencialDePesoDasQuestoesServiceForChamado() {
        Prova prova = new Prova();

        gerarNotaDaProvaComDiferencialDePesoDasQuestoesService.gerar(prova);

        Mockito.verify(respostaMultiplaEscolhaRepository).findAllByProvaIdEquals(prova.getId());

    }

    @Test
    public void deveRetornarUmaNotaQuandoGerarNotaDaProvaComDiferencialDePesoDasQuestoesServiceForChamado() {

        Prova prova = new Prova();
        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        questaoDissertativa.setNivelDeDificuldade(NivelDeDificuldade.FACIL);
        QuestaoDissertativa questaoDissertativa2 = new QuestaoDissertativa();
        questaoDissertativa2.setNivelDeDificuldade(NivelDeDificuldade.MEDIO);
        QuestaoDissertativa questaoDissertativa3 = new QuestaoDissertativa();
        questaoDissertativa3.setNivelDeDificuldade(NivelDeDificuldade.DIFICIL);

        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        questaoTecnica.setNivelDeDificuldade(NivelDeDificuldade.FACIL);
        QuestaoTecnica questaoTecnica2 = new QuestaoTecnica();
        questaoTecnica2.setNivelDeDificuldade(NivelDeDificuldade.MEDIO);
        QuestaoTecnica questaoTecnica3 = new QuestaoTecnica();
        questaoTecnica3.setNivelDeDificuldade(NivelDeDificuldade.DIFICIL);

        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();
        questaoMultiplaEscolha.setNivelDeDificuldade(NivelDeDificuldade.FACIL);
        AlternativaMultiplaEscolha alternativaMultiplaEscolha = new AlternativaMultiplaEscolha();
        alternativaMultiplaEscolha.setRespostaCorreta(true);
        alternativaMultiplaEscolha.setQuestaoMultiplaEscolha(questaoMultiplaEscolha);
        QuestaoMultiplaEscolha questaoMultiplaEscolha2 = new QuestaoMultiplaEscolha();
        questaoMultiplaEscolha2.setNivelDeDificuldade(NivelDeDificuldade.MEDIO);
        AlternativaMultiplaEscolha alternativaMultiplaEscolha2 = new AlternativaMultiplaEscolha();
        alternativaMultiplaEscolha2.setRespostaCorreta(true);
        alternativaMultiplaEscolha2.setQuestaoMultiplaEscolha(questaoMultiplaEscolha2);
        QuestaoMultiplaEscolha questaoMultiplaEscolha3 = new QuestaoMultiplaEscolha();
        questaoMultiplaEscolha3.setNivelDeDificuldade(NivelDeDificuldade.DIFICIL);
        AlternativaMultiplaEscolha alternativaMultiplaEscolha3 = new AlternativaMultiplaEscolha();
        alternativaMultiplaEscolha3.setRespostaCorreta(true);
        alternativaMultiplaEscolha3.setQuestaoMultiplaEscolha(questaoMultiplaEscolha3);

        List<RespostasTecnicaProva> listaTecnica = new ArrayList<>();
        List<RespostasDissertativaProva> listaDissertativa = new ArrayList<>();
        List<RespostasMultiplaEscolhaProva> listaMultiplaEscolha = new ArrayList<>();

        RespostasDissertativaProva respostasDissertativaProvaResposta = new RespostasDissertativaProva();
        RespostasDissertativaProva respostasDissertativaProvaResposta2 = new RespostasDissertativaProva();
        RespostasDissertativaProva respostasDissertativaProvaResposta3 = new RespostasDissertativaProva();

        RespostasTecnicaProva respostasTecnicaProva1 = new RespostasTecnicaProva();
        RespostasTecnicaProva respostasTecnicaProva2 = new RespostasTecnicaProva();
        RespostasTecnicaProva respostasTecnicaProva3 = new RespostasTecnicaProva();

        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();
        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva2 = new RespostasMultiplaEscolhaProva();
        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva3 = new RespostasMultiplaEscolhaProva();

        respostasDissertativaProvaResposta.setProva(prova);
        respostasDissertativaProvaResposta.setQuestaoDissertativa(questaoDissertativa);
        respostasDissertativaProvaResposta.setNota(10);
        respostasDissertativaProvaResposta2.setProva(prova);
        respostasDissertativaProvaResposta2.setQuestaoDissertativa(questaoDissertativa2);
        respostasDissertativaProvaResposta2.setNota(10);
        respostasDissertativaProvaResposta3.setProva(prova);
        respostasDissertativaProvaResposta3.setQuestaoDissertativa(questaoDissertativa3);
        respostasDissertativaProvaResposta3.setNota(10);

        respostasTecnicaProva1.setProva(prova);
        respostasTecnicaProva1.setQuestaoTecnica(questaoTecnica);
        respostasTecnicaProva1.setNota(10);
        respostasTecnicaProva2.setProva(prova);
        respostasTecnicaProva2.setQuestaoTecnica(questaoTecnica2);
        respostasTecnicaProva2.setNota(10);
        respostasTecnicaProva3.setProva(prova);
        respostasTecnicaProva3.setQuestaoTecnica(questaoTecnica3);
        respostasTecnicaProva3.setNota(10);

        respostasMultiplaEscolhaProva.setProva(prova);
        respostasMultiplaEscolhaProva.setQuestaoMultiplaEscolha(questaoMultiplaEscolha);
        respostasMultiplaEscolhaProva.setAlternativaMultiplaEscolha(alternativaMultiplaEscolha);
        respostasMultiplaEscolhaProva2.setProva(prova);
        respostasMultiplaEscolhaProva2.setQuestaoMultiplaEscolha(questaoMultiplaEscolha2);
        respostasMultiplaEscolhaProva2.setAlternativaMultiplaEscolha(alternativaMultiplaEscolha2);
        respostasMultiplaEscolhaProva3.setProva(prova);
        respostasMultiplaEscolhaProva3.setQuestaoMultiplaEscolha(questaoMultiplaEscolha3);
        respostasMultiplaEscolhaProva3.setAlternativaMultiplaEscolha(alternativaMultiplaEscolha3);

        listaDissertativa.add(respostasDissertativaProvaResposta);
        listaDissertativa.add(respostasDissertativaProvaResposta2);
        listaDissertativa.add(respostasDissertativaProvaResposta3);

        listaTecnica.add(respostasTecnicaProva1);
        listaTecnica.add(respostasTecnicaProva2);
        listaTecnica.add(respostasTecnicaProva3);

        listaMultiplaEscolha.add(respostasMultiplaEscolhaProva);
        listaMultiplaEscolha.add(respostasMultiplaEscolhaProva2);
        listaMultiplaEscolha.add(respostasMultiplaEscolhaProva3);

        Mockito.when(respostasDissertativaProva.findAllByProvaIdEquals(prova.getId()))
                .thenReturn(listaDissertativa);
        Mockito.when(respostasTecnicaProva.findAllByProvaIdEquals(prova.getId()))
                .thenReturn(listaTecnica);
        Mockito.when(respostaMultiplaEscolhaRepository.findAllByProvaIdEquals(prova.getId()))
                .thenReturn(listaMultiplaEscolha);

        gerarNotaDaProvaComDiferencialDePesoDasQuestoesService.gerar(prova);


        Assert.assertEquals(10, gerarNotaDaProvaComDiferencialDePesoDasQuestoesService.gerar(prova), 0);
    }

}