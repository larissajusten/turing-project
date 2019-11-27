package br.com.cwi.crescer.api.controller.responses;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvaComRespostasResponse {
    private Long id;

    private String nomeCandidato;

    private List<QuestaoDissertativaParaCorrecaoResponse> questoesDissertativas;

    private List<QuestaoTecnicaParaCorrecaoResponse> questoesTecnicas;

    private List<Especificidade> especificidades;

    private int numeroDeQuestoes;
}
