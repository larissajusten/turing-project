package br.com.cwi.crescer.api.controller.requests.prova;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ProvaRequest {

    @NotEmpty (message = "O email do candidato não pode ser vazio")
    private String email;

    @NotNull (message = "O tempo de duração da prova não pode ser vazio")
    private int tempoDeDuracaoDaProva;

    @NotEmpty
    @NotNull (message = "O tempo para iniciar a prova não pode ser vazio")
    private int tempoParaInicioProva;

}
