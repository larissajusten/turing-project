import React, { PureComponent } from 'react'
import './paginacao.style.css'

export class Paginacao extends PureComponent {
  render(){
    return(
      <div className="container-paginacao">
        <div className="bloco-paginacao" onClick={
                            this.props.paginaAtual > 0
                            ?
                            () => this.props.onClickVoltar(this.props.paginaAtual - 1)
                            : undefined }>
          <span>&laquo;</span>
        </div>
        <div className="bloco-paginacao bloco-laranja">
          <span>{this.props.paginaAtual+1}</span>
        </div>
        <div className="bloco-paginacao" onClick={
                            this.props.totalPaginas > this.props.paginaAtual+1
                            ?
                            () => this.props.onClickVoltar(this.props.paginaAtual + 1)
                            : undefined }>
          <span>&#187;</span>
        </div>
      </div>
    )
  }
}
