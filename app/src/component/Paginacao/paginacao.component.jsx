import React, { PureComponent } from 'react'
import './paginacao.style.css'

export class Paginacao extends PureComponent {
  render(){
    return(
      <div className="container-paginacao">
        <div className="bloco-paginacao" onClick={() => this.props.onClickVoltar(this.props.paginaAtual - 1)}>
          <span>&laquo;</span>
        </div>
        <div className="bloco-paginacao">
          <span>{this.props.paginaAtual}</span>
        </div>
        <div className="bloco-paginacao" onClick={() => this.props.onClickProxima(this.props.paginaAtual + 1)}>
          <span>&#187;</span>
        </div>
      </div>
    )
  }
}