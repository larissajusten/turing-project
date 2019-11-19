import React, { Component } from 'react'
import './blocoQuestao.style.css'

export class BlocoQuestao extends Component {
  render() {
    return(
      <div className="container-pergunta-questao">
        <label className="label">{this.props.questaoNome}</label>
        <div className="questao">
          {this.props.questao}
        </div>
      </div>
    )
  }
}