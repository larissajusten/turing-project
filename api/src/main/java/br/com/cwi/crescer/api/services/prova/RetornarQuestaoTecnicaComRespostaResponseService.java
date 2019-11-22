package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.mapper.QuestaoComRespostaMapper;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetornarQuestaoTecnicaComRespostaResponseService {

    @Autowired
    private RespostasTecnicaRepository respostasTecnicaRepository;

    @Autowired
    private QuestaoComRespostaMapper mapper;

    public List<QuestaoTecnicaComRespostaResponse> buscar(Prova prova) {

        List<QuestaoTecnicaComRespostaResponse> listaQuestoesTecnicas = new ArrayList<>();

        respostasTecnicaRepository.findAllByProvaIdEquals(prova.getId())
                .forEach(questao -> listaQuestoesTecnicas.add(mapper.questaoTecnica(questao)));

        return  listaQuestoesTecnicas;

    }

}
