package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetornarListaDeEspecifidadesDeUmaProvaService {

    public List<Especificidade> retornar(List<QuestaoTecnicaComRespostaResponse> questoesTecnicas,
                                         List<QuestaoDissertativaComRespostaResponse> questoesDissertativa,
                                         List<QuestaoMultiplaEscolhaComRespostaResponse> questoesMultiplaEscolha){

        List<Especificidade> especificidades = new ArrayList<>();

        questoesTecnicas.forEach(q -> especificidades.add(q.getEspecificidade()));
        questoesDissertativa.forEach(q -> especificidades.add(q.getEspecificidade()));
        questoesMultiplaEscolha.forEach(q -> especificidades.add(q.getEspecificidade()));

        return especificidades.stream().distinct().collect(Collectors.toList());
    }
}
