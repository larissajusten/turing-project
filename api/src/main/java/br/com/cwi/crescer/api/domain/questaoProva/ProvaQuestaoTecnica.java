package br.com.cwi.crescer.api.domain.questaoProva;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TECNICA_PROVAS")
@SequenceGenerator(name = "seq", sequenceName = "SEQ_TECNICA_PROVAS", allocationSize = 1)
public class ProvaQuestaoTecnica {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_QUESTAO", referencedColumnName = "id")
    private QuestaoTecnica questao;

    @ManyToOne
    @JoinColumn(name = "ID_PROVA", referencedColumnName = "id")
    private Prova prova;
}
