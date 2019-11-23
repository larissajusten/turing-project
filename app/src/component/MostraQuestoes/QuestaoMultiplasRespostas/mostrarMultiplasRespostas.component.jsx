import React, { Component } from 'react'
import './mostrarMultiplasRespostas.style.css'
import { BotaoAdicionar, BlocoVisualizar, BlocoQuestao } from '../../index'

export class MostrarMultiplasRespostas extends Component {

  render() {
    return (
      <div className="container-questao-multipla-escolha">

        <div className="primeira-div">

          <BlocoQuestao
            widthpergunta={"width-questao"}
            questaoNome={this.props.questaoNome}
            questao={this.props.questao}/>

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
              conteudo={this.props.alternativaB} />

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
