import React, { Component } from 'react'
import './blocoVisualizar.style.css'

export class BlocoVisualizar extends Component {
  render() {
    return(
      <div
        className={`bloco-container ${this.props.classe}`}
        onClick=
          { this.props.comId ?
            (event) => this.props.onClick(event, this.props.index, this.props.idQuestao, this.props.idAlternativa )
          :
            this.props.onClick
          }>

        <div className="bloco-nome">{this.props.nome}</div>
        <label className={`bloco-conteudo ${this.props.classeConteudo}`}>{this.props.conteudo}</label>

      </div>
    )
  }
}
