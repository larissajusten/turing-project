package br.com.cwi.crescer.api.controller.requests.questoes;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@Valid
public class QuestaoMultiplaEscolhaRequest {

    @NotEmpty
    private String questao;

    @NonNull
    private NivelDeDificuldade nivelDeDificuldade;

    @NonNull
    private Especificidade especificidade;

    @NonNull
    private AlternativaQuestaoMultiplaEscolhaRequest alternativaA;

    @NonNull
    private AlternativaQuestaoMultiplaEscolhaRequest alternativaB;

    @NonNull
    private AlternativaQuestaoMultiplaEscolhaRequest alternativaC;

    @NonNull
    private AlternativaQuestaoMultiplaEscolhaRequest alternativaD;

    @NonNull
    private AlternativaQuestaoMultiplaEscolhaRequest alternativaE;

}
