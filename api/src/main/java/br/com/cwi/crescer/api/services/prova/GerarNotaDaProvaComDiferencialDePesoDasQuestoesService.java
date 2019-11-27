package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerarNotaDaProvaComDiferencialDePesoDasQuestoesService {

    @Autowired
    private RespostasTecnicaRepository respostasTecnicaProva;

    @Autowired
    private RespostaMultiplaEscolhaRepository respostaMultiplaEscolhaRepository;

    @Autowired
    private RespostasDissertativaRepository respostasDissertativaProva;

    private double nota = 0;
    private int divisor = 0;

    //TODO VER SE NÃO DÁ PRA QUEBRAR EM 3 MÉTODOS: CADA UM RETORNA UMA NOTA
    public double gerar(Prova prova) {

        respostasDissertativaProva.findAllByProvaIdEquals(prova.getId())
                .forEach(questao -> {

                    if (questao.getQuestaoDissertativa().getNivelDeDificuldade().equals(NivelDeDificuldade.FACIL)) {
                        nota += questao.getNota();
                        divisor += 1;
                    } else if (questao.getQuestaoDissertativa().getNivelDeDificuldade().equals(NivelDeDificuldade.MEDIO)) {
                        nota += questao.getNota() * 2;
                        divisor += 2;
                    } else {
                        nota += questao.getNota() * 3;
                        divisor += 3;
                    }

                });

        respostasTecnicaProva.findAllByProvaIdEquals(prova.getId())
                .forEach(questao -> {

                    if (questao.getQuestaoTecnica().getNivelDeDificuldade().equals(NivelDeDificuldade.FACIL)) {
                        nota += questao.getNota();
                        divisor += 1;
                    } else if (questao.getQuestaoTecnica().getNivelDeDificuldade().equals(NivelDeDificuldade.MEDIO)) {
                        nota += questao.getNota() * 2;
                        divisor += 2;
                    } else {
                        nota += questao.getNota() * 3;
                        divisor += 3;
                    }

                });

        respostaMultiplaEscolhaRepository.findAllByProvaIdEquals(prova.getId())
                .forEach(questao -> {

                    if (questao.getQuestaoMultiplaEscolha().getNivelDeDificuldade().equals(NivelDeDificuldade.FACIL) &&
                            questao.getAlternativaMultiplaEscolha().isRespostaCorreta()) {
                        nota += 10;
                        divisor += 1;
                    } else if (questao.getQuestaoMultiplaEscolha().getNivelDeDificuldade().equals(NivelDeDificuldade.MEDIO) &&
                            questao.getAlternativaMultiplaEscolha().isRespostaCorreta()) {
                        nota += 20;
                        divisor += 2;
                    } else if (questao.getQuestaoMultiplaEscolha().getNivelDeDificuldade().equals(NivelDeDificuldade.DIFICIL) &&
                            questao.getAlternativaMultiplaEscolha().isRespostaCorreta()) {
                        nota += 30;
                        divisor += 3;
                    }

                });


        return nota / divisor;
    }

}
