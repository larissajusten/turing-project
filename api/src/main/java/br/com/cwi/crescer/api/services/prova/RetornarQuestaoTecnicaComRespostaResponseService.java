package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetornarQuestaoTecnicaComRespostaResponseService {

    @Autowired
    private RespostasTecnicaRepository respostasTecnicaRepository;

    public List<QuestaoTecnicaComRespostaResponse> buscar(Prova prova) {

        List<QuestaoTecnicaComRespostaResponse> listaQuestoesTecnicas = new ArrayList<>();

        respostasTecnicaRepository.findAllByProvaIdEquals(prova.getId())
                .forEach(questao -> {
                    QuestaoTecnicaComRespostaResponse questaoTecnicaComRespostaResponse =
                            new QuestaoTecnicaComRespostaResponse();

                    questaoTecnicaComRespostaResponse.setIdQuestao(questao.getQuestaoTecnica().getId());
                    questaoTecnicaComRespostaResponse.setNota(questao.getNota());
                    questaoTecnicaComRespostaResponse.setQuestao(questao.getQuestaoTecnica().getQuestao());
                    questaoTecnicaComRespostaResponse.setResposta(questao.getResposta());

                    listaQuestoesTecnicas.add(questaoTecnicaComRespostaResponse);
                });

        return  listaQuestoesTecnicas;
    }

}
