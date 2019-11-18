package br.com.cwi.crescer.api.controller.requests.prova;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class ProvaRequest {

    @NotEmpty(message = "O email do candidato não pode ser vazio")
    private String email;

    @Min(value = 0, message = "O tempo para iniciar a prova não pode ser vazio")
    private int tempoDeDuracaoDaProva;

    @Min(value = 0, message = "O tempo para iniciar a prova não pode ser vazio")
    private int tempoParaInicioProva;

}
