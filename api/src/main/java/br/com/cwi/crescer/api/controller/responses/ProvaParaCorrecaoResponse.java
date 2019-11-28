package br.com.cwi.crescer.api.controller.responses;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProvaParaCorrecaoResponse {

    private Long id;

    private LocalDateTime dataCriacao;

    private int tempoDeDuracaoDaProva;

    private String nomeCandidato;

    private String emailCandidato;

    private List<Especificidade> especificidades;

    private Integer numeroQuestoes;

    private StatusProva status;

}
