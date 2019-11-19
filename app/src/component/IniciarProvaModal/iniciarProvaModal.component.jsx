import React, { Component } from 'react';
import './iniciarProvaModal.style.css'
import { BotaoPrincipal } from '../index'

export class IniciarProvaModal extends Component {
  render() {
    return (
      <>
      <div className="container-tela container-modal">
        <div className="container-titulo">
          <span className="titulo-crie">Clique em iniciar para resolver a sua prova {/*this.state.prova.nomeCandidato*/}</span>
        </div>
        <BotaoPrincipal nome="Iniciar" onClick={this.props.onClick}/>
      </div>
      </>
    )
  }
}