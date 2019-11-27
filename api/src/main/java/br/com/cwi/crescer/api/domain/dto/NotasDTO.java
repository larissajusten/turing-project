package br.com.cwi.crescer.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotasDTO {

    private double nota;

    private Long quantidadeDeQuestoes;

}
