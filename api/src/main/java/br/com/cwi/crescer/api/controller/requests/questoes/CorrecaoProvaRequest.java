package br.com.cwi.crescer.api.controller.requests.questoes;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class CorrecaoProvaRequest {

    @NotNull
    private double nota;

    @NotEmpty
    private String comentario;

}
