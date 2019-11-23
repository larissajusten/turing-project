package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.mapper.QuestaoComRespostaMapper;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetornarQuestaoDissertativaComRespostaResponseService {

    @Autowired
    private RespostasDissertativaRepository respostasDissertativaRepository;

    @Autowired
    private QuestaoComRespostaMapper mapper;

    public List<QuestaoDissertativaComRespostaResponse> buscar(Prova prova) {

        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();

        respostasDissertativaRepository.findAllByProvaIdEquals(prova.getId())
                .forEach(questao -> questaoDissertativa.add(mapper.questaoDissertativa(questao)));

        return questaoDissertativa;
    }

}
