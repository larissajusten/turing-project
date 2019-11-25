import React, { Component } from 'react'
import './blocoResposta.style.css'

export class BlocoResposta extends Component {
  render() {
    return(
        <div className="container-resposta">
      <div className={`container-pergunta ${this.props.widthpergunta}`}>
        <label className="label">
            <h3><strong>{this.props.questaoNome}</strong></h3>
            {this.props.tipo === undefined ? '' : <h6>{`Tipo: ${this.props.tipo}`}</h6> }
        </label>
        <div className="label">
         {this.props.questao}
        </div>
        </div>
      </div>
    )
  }
}
