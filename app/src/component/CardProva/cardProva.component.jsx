import React, { Component } from 'react'
import './cardProva.style.css'

export class CardProva extends Component {

  render() {
    return (
      <div className="container-card" onClick={(event) => this.props.onClick(event, this.props.id)}>
        <div className="content-card">
          <span>{this.props.informacaoUm}</span>
          <span>{this.props.informacaoDois}</span>
          <span>{this.props.informacaoTres}</span>
        </div>
      </div>
    )
  }
}
