package br.com.cwi.crescer.api.controller.requests.prova;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.enums.TipoDeProva;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
public class ProvaCrescerRequest {

    @Positive
    @Min(value = 0, message = "Quantidade de provas não pode ser vazio")
    private int quantidade;

    private TipoDeProva tipo;

    @Positive
    @Min(value = 0, message = "O tempo de duração da prova não pode ser vazio")
    private int tempoDeDuracaoDaProva;

    @Positive
    @Min(value = 0, message = "Tempo de inicio da prova deve ser maior que 0")
    private int tempoParaInicioProva;
}
