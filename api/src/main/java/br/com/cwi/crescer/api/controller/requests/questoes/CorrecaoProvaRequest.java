package br.com.cwi.crescer.api.controller.requests.questoes;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class CorrecaoProvaRequest {

    @NotNull (message = "A nota não pode ser vazia")
    private double nota;

    @NotEmpty (message = "O comentario não pode ser vazio")
    private String comentario;

}
