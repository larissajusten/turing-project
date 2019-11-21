package br.com.cwi.crescer.api.controller.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvaCorrigidaResponse {

    private Long id;

    private String nomeCandidato;

    private double nota;

    private List<QuestaoDissertativaComRespostaResponse> questoesDissertativas;

    private List<QuestaoMultiplaEscolhaComRespostaResponse> questoesMultiplaEscolha;

    private List<QuestaoTecnicaComRespostaResponse> questoesTecnicas;

}
