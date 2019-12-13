package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.mapper.QuestaoComRespostaMapper;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetornarQuestaoDissertativaComRespostaResponseService {

    @Autowired
    private RespostasDissertativaRepository respostasDissertativaRepository;

    @Autowired
    private QuestaoComRespostaMapper mapper;

    public List<QuestaoDissertativaComRespostaResponse> buscar(Prova prova) {

        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();

        respostasDissertativaRepository.findAllByProvaIdEquals(prova.getId())
                .stream()
                .map(questao -> questaoDissertativa.add(mapper.questaoDissertativa(questao)))
                .collect(Collectors.toList());
        
        return questaoDissertativa;
    }
}
