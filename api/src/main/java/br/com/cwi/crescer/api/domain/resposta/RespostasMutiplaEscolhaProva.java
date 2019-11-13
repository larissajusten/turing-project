package br.com.cwi.crescer.api.domain.resposta;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RESPOSTAS_MULT_ESCOLHAS_PROVAS")
@SequenceGenerator(name = "seq", sequenceName = "SEQ_RESPOSTAS_DISSERTATIVAS", allocationSize = 1)
public class RespostasMutiplaEscolhaProva {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String resposta;

    @ManyToOne
    @JoinColumn(name = "ID_QUESTAO", referencedColumnName = "id")
    private QuestaoMultiplaEscolha questaoMultiplaEscolha;

    @ManyToOne
    @JoinColumn(name = "ID_PROVA", referencedColumnName = "id")
    private Prova prova;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "id")
    private Usuario usuario;
}
