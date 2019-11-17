package br.com.cwi.crescer.api.domain.resposta;

import br.com.cwi.crescer.api.controller.requests.questoes.CorrecaoProvaRequest;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RESPOSTAS_DISSERTATIVAS_PROVAS")
@SequenceGenerator(name = "seq", sequenceName = "SEQ_RESPOSTAS_DISSERTATIVAS", allocationSize = 1)
public class RespostasDissertativaProva {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String resposta;

    private String comentario;

    @Column(precision = 2, scale = 10, name = "nota", columnDefinition = "NUMBER (2, 10)")
    private double nota;

    @ManyToOne
    @JoinColumn(name = "ID_QUESTAO", referencedColumnName = "id")
    private QuestaoDissertativa questaoDissertativa;

    @ManyToOne
    @JoinColumn(name = "ID_PROVA", referencedColumnName = "id")
    private Prova prova;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "id")
    private Usuario usuario;
}
