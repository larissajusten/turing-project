package br.com.cwi.crescer.api.controller.requests.questoes;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;

public class QuestaoMultiplaEscolhaRequest {

    @NotEmpty
    private String questao;

    @NonNull
    private NivelDeDificuldade nivelDeDificuldade;

    @NonNull
    private Especificidade especificidade;

    @NonNull
    private AlternativaMultiplaEscolha alternativaA;

    @NonNull
    private AlternativaMultiplaEscolha alternativaB;

    @NonNull
    private AlternativaMultiplaEscolha alternativaC;

    @NonNull
    private AlternativaMultiplaEscolha alternativaD;

    @NonNull
    private AlternativaMultiplaEscolha alternativaE;


}
