package br.com.cwi.crescer.api.controller.requests.prova;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProvaRespondidaRequest {
    private int tipo;
    private Long idQuestao;
    private String resposta;
}
