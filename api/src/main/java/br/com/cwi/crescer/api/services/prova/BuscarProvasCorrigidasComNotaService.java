package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaCorrigidaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.RetornarNotaDaQuestaoMultiplaEscolhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarProvasCorrigidasComNotaService {

    @Autowired
    private ProvaRepository provaRepository;

    @Autowired
    private RespostaMultiplaEscolhaRepository respostaMultiplaEscolhaRepository;

    @Autowired
    private RespostasDissertativaRepository respostasDissertativaRepository;

    @Autowired
    private RespostasTecnicaRepository respostasTecnicaRepository;

    @Autowired
    private RetornarNotaDaQuestaoMultiplaEscolhaService retornarNotaDaQuestaoMultiplaEscolhaService;

    public Page<ProvaCorrigidaResponse> buscar(Pageable pageable) {

        Page<Prova> provas = provaRepository.findAllByStatusEquals(pageable, StatusProva.CORRIGIDA);

        Page<ProvaCorrigidaResponse> provaCorrigidaResponse = provas.map(prova -> {

            List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = new ArrayList<>();
            List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();
            List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

            respostasTecnicaRepository.findAllByProvaIdEquals(prova.getId())
                    .forEach(questao -> {
                        QuestaoTecnicaComRespostaResponse questaoTecnicaComRespostaResponse =
                                new QuestaoTecnicaComRespostaResponse();

                        questaoTecnicaComRespostaResponse.setIdQuestao(questao.getQuestaoTecnica().getId());
                        questaoTecnicaComRespostaResponse.setNota(questao.getNota());
                        questaoTecnicaComRespostaResponse.setQuestao(questao.getQuestaoTecnica().getQuestao());
                        questaoTecnicaComRespostaResponse.setResposta(questao.getResposta());

                        questoesTecnicas.add(questaoTecnicaComRespostaResponse);
                    });

            respostasDissertativaRepository.findAllByProvaIdEquals(prova.getId())
                    .forEach(questao -> {
                        QuestaoDissertativaComRespostaResponse questaoDissertativaComRespostaResponse =
                                new QuestaoDissertativaComRespostaResponse();

                        questaoDissertativaComRespostaResponse.setIdQuestao(questao.getQuestaoDissertativa().getId());
                        questaoDissertativaComRespostaResponse.setNota(questao.getNota());
                        questaoDissertativaComRespostaResponse.setQuestao(questao.getQuestaoDissertativa().getQuestao());
                        questaoDissertativaComRespostaResponse.setResposta(questao.getResposta());

                        questaoDissertativa.add(questaoDissertativaComRespostaResponse);
                    });

            respostaMultiplaEscolhaRepository.findAllByProvaIdEquals(prova.getId())
                    .forEach(questao -> {
                        QuestaoMultiplaEscolhaComRespostaResponse questaoMultiplaEscolhaComRespostaResponse =
                                new QuestaoMultiplaEscolhaComRespostaResponse();

                        questaoMultiplaEscolhaComRespostaResponse.setIdQuestao(questao.getQuestaoMultiplaEscolha().getId());
                        questaoMultiplaEscolhaComRespostaResponse.setQuestao(questao.getQuestaoMultiplaEscolha().getQuestao());
                        questaoMultiplaEscolhaComRespostaResponse.setNota(retornarNotaDaQuestaoMultiplaEscolhaService
                                .notaQuestaoMultiplaEscolha(questao.getQuestaoMultiplaEscolha().getNivelDeDificuldade()));
                        questaoMultiplaEscolhaComRespostaResponse.setResposta(questao.getAlternativaMultiplaEscolha());

                        questaoMultiplaEscolha.add(questaoMultiplaEscolhaComRespostaResponse);
                    });

            ProvaCorrigidaResponse provaResponse = new ProvaCorrigidaResponse();
            provaResponse.setId(prova.getId());
            provaResponse.setNomeCandidato(prova.getNomeCandidato());
            provaResponse.setNota(prova.getNota());
            provaResponse.setQuestoesMultiplaEscolha(questaoMultiplaEscolha);
            provaResponse.setQuestoesDissertativas(questaoDissertativa);
            provaResponse.setQuestoesTecnicas(questoesTecnicas);

            return provaResponse;
        });

        return provaCorrigidaResponse;
    }
}
