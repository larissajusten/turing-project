import React, { Component } from 'react'
import './provaModal.style.css'
import { BotaoPrincipal } from '../'

export class ProvaModal extends Component {
  render() {
    return (
      <>
        <div className="container-tela container-modal">
          <div className="container-titulo">
            <span className="titulo-crie">{this.props.titulo}</span>
            <span className="subtitulo-crie">{this.props.subtitulo}</span>
          </div>
          {this.props.comBotao && (
            <BotaoPrincipal
              nome={this.props.nomeBotao}
              onClick={this.props.onClick}
            />
          )}
        </div>
      </>
    )
  }
}
