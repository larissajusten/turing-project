package br.com.cwi.crescer.api.controller.responses;


import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.enums.TipoDeProva;
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

    private String nomeCandidato;

    private String emailCandidato;

    private StatusProva statusProva;

    private double tempoDeDuracaoDaProva;

    private double tempoParaInicioProva;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataInicio;

    private TipoDeProva tipoDeProva;

    private double nota;

    private List<QuestaoDissertativaComRespostaResponse> questoesDissertativas;

    private List<QuestaoMultiplaEscolhaComRespostaResponse> questoesMultiplaEscolha;

    private List<QuestaoTecnicaComRespostaResponse> questoesTecnicas;

    private List<Especificidade> especificidades;

    private int numeroDeQuestoes;
}
