package br.com.cwi.crescer.api.domain.questao;


import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "QUESTAO_TECNICA")
@SequenceGenerator(name = "seq", sequenceName = "SEQ_QUESTAO_TECNICA", allocationSize = 1)
public class QuestaoTecnica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @Column(name = "DATA_CRIACAO")
    private LocalDate dataCriacao;

    private String questao;

    private String testeBase;

    private String respostaBase;

    @Enumerated(EnumType.STRING)
    private Especificidade especificidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "NIVEL")
    private NivelDeDificuldade nivelDeDificuldade;

    @Column(name = "VEZES_USADA")
    private int vezesUsada;
}
