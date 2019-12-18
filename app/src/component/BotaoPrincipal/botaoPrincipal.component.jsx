import React, { Component } from 'react'
import './botaoPrincipal.style.css'

export class BotaoPrincipal extends Component {
  render() {
    console.log(this.props.nomeUsuario)
    return (
      <>
        <button
          className={`botao-principal ${this.props.classe}`}
          onClick={(e) => this.props.onClick(this.props.nomeUsuario, this.props.emailUsuario)}
        >
          <span>{this.props.nome}</span>
        </button>
      </>
    )
  }
}
