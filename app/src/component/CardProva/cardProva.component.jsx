import React, { Component } from 'react'
import './cardProva.style.css'

export class CardProva extends Component {

  render() {
    return (
      <div className="container-card" onClick={(event) => this.props.onClick(event, this.props.id)}>
        <div className="content-card">
          <span>{`Nome do candidato: ${this.props.informacaoUm}`}</span>
          <span>{`E-mail do candidato: ${this.props.informacaoDois}`}</span>
          <span>{`Duração da prova: ${this.props.informacaoTres}`}</span>
        </div>
      </div>
    )
  }
}
