package br.com.cwi.crescer.api.controller.responses;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvaResponse {

    private Long id;

    private Long idCriador;

    private LocalDateTime dataCriacao;

    private double tempoDeDuracaoDaProva;

    private double tempoParaInicioProva;

    private boolean podeIniciar;

    private String nomeCandidato;

    private String emailCandidato;

    private StatusProva status;

    private List<QuestaoMultiplaEscolhaResponse> questoesDeMultiplaEscolha;

    private List<QuestaoDissertativaResponse> questoesDissertativas;

    private List<QuestaoTecnicaResponse> questoesTecnicas;
}
