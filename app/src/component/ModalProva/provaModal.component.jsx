import React, { Component } from 'react'
import './provaModal.style.css'
import { BotaoPrincipal } from '../'

export class ProvaModal extends Component {
  constructor(props) {
    super(props)
    this.state = {
      nome: '',
      email: ''
    }
  }
  render() {
    return (
      <>
        <div className="container-tela container-modal">
          <div className="container-titulo">
            <span className="titulo-crie">{this.props.titulo}</span>
            <span className="subtitulo-crie">{this.props.subtitulo}</span>
          </div>
          {this.props.tipoProva === 'CRESCER' && (
            <>
              <label htmlFor="nomeCandidato">Informe seu nome:</label>
              <input
                type="text"
                name="nomeCandidato"
                className="input-principal"
                onChange={event => this.setState({ nome: event.target.value })}
                placeholder="Ex. João da Silva"
              />
              <label htmlFor="emailCandidato">Informe seu email:</label>
              <input
                type="text"
                name="emailCandidato"
                className="input-principal"
                onChange={event => this.setState({ email: event.target.value })}
                placeholder="joao.silva@cwi.com.br"
              />
            </>
          )}

          {this.props.comBotao && (
            <BotaoPrincipal
              nome={this.props.nomeBotao}
              onClick={this.props.onClick}
              nomeUsuario={this.state.nome}
              emailUsuario={this.state.email}
            />
          )}
        </div>
      </>
    )
  }
}
