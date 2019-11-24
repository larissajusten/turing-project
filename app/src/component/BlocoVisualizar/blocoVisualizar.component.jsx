import React, { Component } from 'react'
import './blocoVisualizar.style.css'

export class BlocoVisualizar extends Component {
  render() {
    return(
      <div className={`bloco-container ${this.props.classe}`}>

        <div className="bloco-nome">{this.props.nome}</div>
        <label className={`bloco-conteudo ${this.props.classeConteudo}`}>{this.props.conteudo}</label>

      </div>
    )
  }
}
