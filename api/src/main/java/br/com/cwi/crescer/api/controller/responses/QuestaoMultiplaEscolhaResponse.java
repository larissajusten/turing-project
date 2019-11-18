package br.com.cwi.crescer.api.controller.responses;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.Data;

import java.time.LocalDate;

@Data
public class QuestaoMultiplaEscolhaResponse {

    private Long id;

    private LocalDate dataCriacao;

    private String questao;

    private Especificidade especificidade;

    private NivelDeDificuldade nivelDeDificuldade;

    private AlternativaMultiplaEscolhaResponse alternativaA;

    private AlternativaMultiplaEscolhaResponse alternativaB;

    private AlternativaMultiplaEscolhaResponse alternativaC;

    private AlternativaMultiplaEscolhaResponse alternativaD;

    private AlternativaMultiplaEscolhaResponse alternativaE;

    private Long idUsuario;
}
