package br.com.cwi.crescer.api.controller.responses;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestaoDissertativaResponse {

    private Long id;

    private LocalDate dataCriacao;

    private String questao;

    private Especificidade especificidade;

    private NivelDeDificuldade nivelDeDificuldade;

    private Long idUsuario;
}
