package br.com.cwi.crescer.api.domain.questao;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "QUESTAO_MULTIPLA_ESCOLHA")
@SequenceGenerator(name = "seq", sequenceName = "SEQ_QUESTAO_MULTIPLA_ESCOLHA", allocationSize = 1)
public class QuestaoMultiplaEscolha {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @Column(name = "DATA_CRIACAO")
    private LocalDate dataCriacao;

    private String questao;

    @Enumerated(EnumType.STRING)
    private Especificidade especificidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "NIVEL")
    private NivelDeDificuldade nivelDeDificuldade;

    @ManyToOne
    @JoinColumn(name = "ID_CRIADOR", referencedColumnName = "id")
    private Usuario usuario;

}
