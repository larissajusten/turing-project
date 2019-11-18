package br.com.cwi.crescer.api.controller.requests.prova;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ProvaRequest {

    @NotEmpty(message = "E-mail não pode estar vazio" )
    private String email;

    @NotNull(message = "Tempo de duração da prova não pode ser nulo" )
    private int tempoDeDuracaoDaProva;

    @NotNull(message = "Tempo de início para a prova não pode ser nulo" )
    private int tempoParaInicioProva;

}
