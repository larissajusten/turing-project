package br.com.cwi.crescer.api.controller.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestaoDissertativaComRespostaResponse {

    private Long idQuestao;

    private String resposta;

    private String questao;

    private double nota;
}
