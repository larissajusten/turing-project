package br.com.cwi.crescer.api.controller.requests.prova;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Valid
@Getter
@AllArgsConstructor
public class ProvaRequest {

    @NotEmpty
    private String email;

    @NotNull
    private int tempoDeDuracaoDaProva;

    @NotNull
    private int tempoParaInicioProva;

}
