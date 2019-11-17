package br.com.cwi.crescer.api.domain.prova;


import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
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

    private String email;

    @Column(name = "DURACAO")
    private int tempoDeDuracaoDaProva;

    @Column(name = "TEMPO_INICIO")
    private int tempoParaInicioProva;

    @Enumerated(EnumType.STRING)
    private StatusProva status;

    @ManyToOne
    @JoinColumn(name = "ID_CRIADOR", referencedColumnName = "id")
    private Usuario criador;
}
