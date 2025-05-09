package br.com.cwi.crescer.api.domain.prova;


import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.enums.TipoDeProva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROVAS")
@SequenceGenerator(name = "seq", sequenceName = "SEQ_PROVAS", allocationSize = 1)
public class Prova {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "DATA_INICIO")
    private LocalDateTime dataInicio;

    @Column(name = "EMAIL_CANDIDATO")
    private String emailCandidato;

    @Column(precision = 2, scale = 10, name = "DURACAO", columnDefinition = "NUMBER (2, 10)")
    private double tempoDeDuracaoDaProva;

    @Column(precision = 2, scale = 10, name = "TEMPO_INICIO", columnDefinition = "NUMBER (2, 10)")
    private double tempoParaInicioProva;

    @Enumerated(EnumType.STRING)
    private StatusProva status;

    @Column(precision = 2, scale = 10, name = "nota", columnDefinition = "NUMBER (2, 10)")
    private double nota;

    @Column(name = "NOME_CANDIDATO")
    private String nomeCandidato;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoDeProva tipo;


    @Enumerated(EnumType.STRING)
    @Column
    private Especificidade especificidade;

}
