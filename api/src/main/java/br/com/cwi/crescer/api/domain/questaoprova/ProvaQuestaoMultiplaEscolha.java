package br.com.cwi.crescer.api.domain.questaoprova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MULTIPLA_ESCOLHA_PROVAS")
@SequenceGenerator(name = "seq", sequenceName = "SEQ_MULTIPLA_ESCOLHA_PROVAS", allocationSize = 1)
public class ProvaQuestaoMultiplaEscolha {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_QUESTAO", referencedColumnName = "id")
    private QuestaoMultiplaEscolha questao;

    @ManyToOne
    @JoinColumn(name = "ID_PROVA", referencedColumnName = "id")
    private Prova prova;
}
