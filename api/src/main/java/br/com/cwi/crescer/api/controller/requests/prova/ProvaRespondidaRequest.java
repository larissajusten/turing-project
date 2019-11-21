package br.com.cwi.crescer.api.controller.requests.prova;

import br.com.cwi.crescer.api.domain.enums.TipoDeQuestao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProvaRespondidaRequest {
    private TipoDeQuestao tipoDeQuestao;
    private Long idQuestao;
    private String resposta;
}
