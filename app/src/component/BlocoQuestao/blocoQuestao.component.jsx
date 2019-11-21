import React, { Component } from 'react'
import './blocoQuestao.style.css'

export class BlocoQuestao extends Component {
  render() {
    return(
      <div className={`container-pergunta ${this.props.widthpergunta}`}>
        <label className="label">{this.props.questaoNome}</label>
        <div className="questao">
          {this.props.questao}
        </div>
      </div>
    )
  }
}
