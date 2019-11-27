package br.com.cwi.crescer.api.domain.questao;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@SequenceGenerator(name = "seq", sequenceName = "SEQ_ALTERNATIVAS", allocationSize = 1)
@Table(name = "ALTERNATIVAS_MULTIPLA_ESCOLHA")
public class AlternativaMultiplaEscolha {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String resposta;

    @Column(name = "CORRETA")
    @Type(type = "yes_no")
    private boolean respostaCorreta = false;

    @ManyToOne
    @JoinColumn(name = "ID_QUESTAO", referencedColumnName = "id")
    private QuestaoMultiplaEscolha questaoMultiplaEscolha;
}