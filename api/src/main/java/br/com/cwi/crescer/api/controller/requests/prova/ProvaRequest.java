package br.com.cwi.crescer.api.controller.requests.prova;

import br.com.cwi.crescer.api.domain.enums.TipoDeProva;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
public class ProvaRequest {

    @NotEmpty(message = "O email do candidato não pode ser vazio")
    private String email;

    @NotEmpty(message = "Deve ter o nome completo do candidato")
    private String nomeCandidato;

    @NotEmpty(message = "O tipo de prova não pode ser vazio")
    private TipoDeProva tipo;

    @Positive
    @Min(value = 0, message = "O tempo de duração da prova não pode ser vazio")
    private int tempoDeDuracaoDaProva;

    @Positive
    @Min(value = 0, message = "Tempo de inicio da prova deve ser maior que 0")
    private int tempoParaInicioProva;
}
