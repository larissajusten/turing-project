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
public class ProvaCorrigidaResponse {

    private Long id;

    private Long idCriador;

    private String nomeCandidato;

    private String emailCandidato;

    private StatusProva statusProva;

    private int tempoDeDuracaoDaProva;

    private int tempoParaInicioProva;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataInicio;

    private double nota;

    private List<QuestaoDissertativaComRespostaResponse> questoesDissertativas;

    private List<QuestaoMultiplaEscolhaComRespostaResponse> questoesMultiplaEscolha;

    private List<QuestaoTecnicaComRespostaResponse> questoesTecnicas;

}
