import React, { Component } from 'react'
import './botaoPrincipal.style.css'

export class BotaoPrincipal extends Component {
  render() {
    return (
      <>
        <button
          className={`botao-principal ${this.props.classe}`}
          onClick={(e) => this.props.onClick(e,this.props.nomeUsuario, this.props.emailUsuario)}
        >
          <span>{this.props.nome}</span>
        </button>
      </>
    )
  }
}
