package br.com.cwi.crescer.api.controller.responses;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import lombok.Data;

import java.time.LocalDate;

@Data
public class QuestaoMultiplaEscolhaResponse {

    private Long id;

    private LocalDate dataCriacao;

    private String questao;

    private Especificidade especificidade;

    private NivelDeDificuldade nivelDeDificuldade;

    private AlternativaMultiplaEscolha alternativaA;

    private AlternativaMultiplaEscolha alternativaB;

    private AlternativaMultiplaEscolha alternativaC;

    private AlternativaMultiplaEscolha alternativaD;

    private AlternativaMultiplaEscolha alternativaE;

    private Long idUsuario;
}
