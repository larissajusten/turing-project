import React, { Component } from 'react'
import './mostrarMultiplasRespostas.style.css'
import { BotaoAdicionar, BlocoVisualizar } from '../../index'

export class MostrarMultiplasRespostas extends Component {

  render() {
    return (
      <div className="container-questao-multipla">

        <div className="primeira-div">
          <div className="container-pergunta-questao mult-questao">
            <label className="label">Questão de múltipla escolha</label>
            <div className="questao">
              {this.props.questao}
            </div>
          </div>

          <div className="container-especificacao">
            <div className="especificacao">{this.props.respostaCorreta}</div>
            <label className="especificacao-nome">Resposta correta</label>
          </div>

          <BotaoAdicionar className="botao-remover" nome="-" adicionar={false} onClick={this.props.onClick} id={this.props.id} />
        </div>

        <div className="container-alternativas">
          <div className="coluna">
            <BlocoVisualizar
              classe="mult"
              nome="Alternativa A"
              conteudo={this.props.alternativaA} />

            <BlocoVisualizar
              classe="mult"
              nome="Alternativa B"
              resposconteudota={this.props.alternativaB} />

            <BlocoVisualizar
              classe="mult"
              nome="Alternativa C"
              conteudo={this.props.alternativaC} />
          </div>

          <div className="coluna">
            <div className="container-especificacoes">
              <div className="container-especificacao-mult">
                <label className="especificacao-nome mult">Nivel</label>
                <div className="especificacao mult">{this.props.nivel}</div>
              </div>

              <div className="container-especificacao-mult">
                <label className="especificacao-nome mult">Especificidade</label>
                <div className="especificacao mult">{this.props.especificidade}</div>
              </div>
            </div>

            <BlocoVisualizar
              classe="mult"
              nome="Alternativa D"
              conteudo={this.props.alternativaD} />

            <BlocoVisualizar
              classe="mult"
              nome="Alternativa E"
              conteudo={this.props.alternativaE} />
          </div>
        </div>
      </div>
    )
  }
}
