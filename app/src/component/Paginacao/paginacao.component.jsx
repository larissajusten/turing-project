import React, { PureComponent } from 'react'
import './paginacao.style.css'

export class Paginacao extends PureComponent {
  render(){
    return(
      <div className="container-paginacao">
        <div className="bloco-paginacao" onClick={
                            this.props.totalPaginas > this.props.paginaAtual
                            ?
                            () => this.props.onClickVoltar(this.props.paginaAtual - 1)
                            : null }>
          <span>&laquo;</span>
        </div>
        <div className="bloco-paginacao">
          <span>{this.props.paginaAtual+1}</span>
        </div>
        <div className="bloco-paginacao" onClick={
                            this.props.totalPaginas-1 > this.props.paginaAtual
                            ?
                            () => this.props.onClickVoltar(this.props.paginaAtual + 1)
                            : null }>
          <span>&#187;</span>
        </div>
      </div>
    )
  }
}
