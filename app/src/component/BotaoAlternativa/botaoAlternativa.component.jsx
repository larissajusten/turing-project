import React, { Component } from 'react'
import './botaoAlternativa.style.css'

export class BotaoAlternativa extends Component {
  render() {
    return(
        <div className={`bloco-container ${this.props.classe}`} >

          <span className="bloco-nome">{this.props.nome}</span>
          <button className={`bloco-conteudo ${this.props.classeConteudo}`}
            onClick={ this.props.comId
              ? (event) => this.props.onClick(event, this.props.index,
                                                      this.props.idQuestao,
                                                      this.props.idAlternativa,
                                                      this.props.tipo)
              : this.props.onClick}
            >
            {this.props.conteudo}
          </button>
        </div>
    )
  }
}
