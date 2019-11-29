package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaComRespostasResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaParaCorrecaoResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaParaCorrecaoResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuscarProvaPorIdParaCorrecaoService {
    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @Autowired
    private RespostasDissertativaRepository respostasDissertativaRepository;

    @Autowired
    private RespostasTecnicaRepository respostasTecnicaRepository;

    @Autowired
    private RespostaMultiplaEscolhaRepository respostaMultiplaEscolhaRepository;

    public ProvaComRespostasResponse buscar(Long idProva) {

        ProvaComRespostasResponse response = new ProvaComRespostasResponse();
        Prova prova = buscarProvaPorIdService.buscar(idProva);

        List<Especificidade> especificidades = new ArrayList<>();
        List<RespostasDissertativaProva> respostasDissertativas = respostasDissertativaRepository.findAllByProvaIdEquals(idProva);
        List<QuestaoDissertativaParaCorrecaoResponse> questoesDissertativas = new ArrayList<>();

        respostasDissertativas.forEach(questao -> {
            QuestaoDissertativaParaCorrecaoResponse respostaResponse = new QuestaoDissertativaParaCorrecaoResponse();
            respostaResponse.setQuestao(questao.getQuestaoDissertativa().getQuestao());
            respostaResponse.setIdResposta(questao.getId());
            respostaResponse.setIdQuestao(questao.getQuestaoDissertativa().getId());
            respostaResponse.setResposta(questao.getResposta());

            especificidades.add(questao.getQuestaoDissertativa().getEspecificidade());
            questoesDissertativas.add(respostaResponse);
        });

        List<RespostasTecnicaProva> respostasTecnicas = respostasTecnicaRepository.findAllByProvaIdEquals(idProva);
        List<QuestaoTecnicaParaCorrecaoResponse> questoesTecnicas = new ArrayList<>();

        respostasTecnicas.forEach(questao -> {
            QuestaoTecnicaParaCorrecaoResponse respostaResponse = new QuestaoTecnicaParaCorrecaoResponse();
            respostaResponse.setQuestao(questao.getQuestaoTecnica().getQuestao());
            respostaResponse.setIdQuestao(questao.getQuestaoTecnica().getId());
            respostaResponse.setIdResposta(questao.getId());
            respostaResponse.setResposta(questao.getResposta());

            especificidades.add(questao.getQuestaoTecnica().getEspecificidade());
            questoesTecnicas.add(respostaResponse);
        });


        List<RespostasMultiplaEscolhaProva> respostasMultiplaEscolhaProva = respostaMultiplaEscolhaRepository.findAllByProvaIdEquals(idProva);
        List<Especificidade> especificidadeSemRepetidas = especificidades.stream()
                .distinct()
                .collect(Collectors.toList());
        int quantasQuestoesParaCorrecao = respostasTecnicas.size() + respostasDissertativas.size()
                + respostasMultiplaEscolhaProva.size();


        response.setId(idProva);
        response.setQuestoesDissertativas(questoesDissertativas);
        response.setQuestoesTecnicas(questoesTecnicas);
        response.setNomeCandidato(prova.getNomeCandidato());
        response.setNumeroDeQuestoes(quantasQuestoesParaCorrecao);
        response.setEspecificidades(especificidadeSemRepetidas);

        return response;
    }
}
