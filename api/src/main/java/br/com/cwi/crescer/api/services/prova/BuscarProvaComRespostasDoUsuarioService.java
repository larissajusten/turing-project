package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.*;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarProvaComRespostasDoUsuarioService {
    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @Autowired
    private RespostasDissertativaRepository respostasDissertativaRepository;

    @Autowired
    private RespostasTecnicaRepository respostasTecnicaRepository;

    public ProvaComRespostasResponse buscar(Long idProva){
        Prova prova = buscarProvaPorIdService.buscar(idProva);
        ProvaComRespostasResponse response = new ProvaComRespostasResponse();
        List<RespostasDissertativaProva> respostasDissertativas = respostasDissertativaRepository.findAllByProvaIdEquals(idProva);

        List<QuestaoDissertativaParaCorrecaoResponse> questoesDissertativas = new ArrayList<>();

        respostasDissertativas.forEach( questao -> {
            QuestaoDissertativaParaCorrecaoResponse respostaResponse = new QuestaoDissertativaParaCorrecaoResponse();
            respostaResponse.setQuestao(questao.getQuestaoDissertativa().getQuestao());
            respostaResponse.setIdQuestao(questao.getQuestaoDissertativa().getId());
            respostaResponse.setResposta(questao.getResposta());
            questoesDissertativas.add(respostaResponse);
        });

        List<RespostasTecnicaProva> respostasTecnicas = respostasTecnicaRepository.findAllByProvaIdEquals(idProva);

        List<QuestaoTecnicaParaCorrecaoResponse> questoesTecnicas = new ArrayList<>();

        respostasTecnicas.forEach( questao -> {
            QuestaoTecnicaParaCorrecaoResponse respostaResponse = new QuestaoTecnicaParaCorrecaoResponse();
            respostaResponse.setQuestao(questao.getQuestaoTecnica().getQuestao());
            respostaResponse.setIdQuestao(questao.getQuestaoTecnica().getId());
            respostaResponse.setResposta(questao.getResposta());
            questoesTecnicas.add(respostaResponse);
        });

        response.setQuestoesDissertativas(questoesDissertativas);
        response.setQuestoesTecnicas(questoesTecnicas);
        response.setNomeCandidato(prova.getNomeCandidato());

        return response;
    }
}
