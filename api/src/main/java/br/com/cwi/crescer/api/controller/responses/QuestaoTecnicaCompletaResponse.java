package br.com.cwi.crescer.api.controller.responses;

import lombok.Data;

@Data
public class QuestaoTecnicaCompletaResponse {

    private String questao;

    private String testeBase;

    private String respostaBase;

    private String respostaUsuario;
}
