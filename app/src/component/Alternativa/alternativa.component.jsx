import React, { Component } from 'react'
import './alternativa.style.css'

export class Alternativa extends Component {
  render() {
    return(
      <div className="container-alternativa">
        <div className="alternativa">{this.props.nome}</div>
        <label className="alternativa-resposta">{this.props.resposta}</label>
      </div>
    )
  }
}
