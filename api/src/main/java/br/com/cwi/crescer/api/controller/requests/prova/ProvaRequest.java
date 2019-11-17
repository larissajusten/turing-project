package br.com.cwi.crescer.api.controller.requests.prova;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ProvaRequest {

    @NotEmpty
    private String email;

    @NotNull
    private int tempoDeDuracaoDaProva;

    @NotNull
    private int tempoParaInicioProva;

}
