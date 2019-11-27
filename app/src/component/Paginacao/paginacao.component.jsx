import React, { PureComponent } from 'react'
import './paginacao.style.css'

export class Paginacao extends PureComponent {
  render(){
    return(
      <div className="container-paginacao">
        <button className="draw" onClick={
                            this.props.paginaAtual > 0
                            ?
                            () => this.props.onClickVoltar(this.props.paginaAtual - 1)
                            : undefined }>
          &laquo;
        </button>
        <div className="bloco-principal-paginacao">
          {this.props.paginaAtual+1}
        </div>
        <button className="draw" onClick={
                            this.props.totalPaginas > this.props.paginaAtual+1
                            ?
                            () => this.props.onClickVoltar(this.props.paginaAtual + 1)
                            : undefined }>
          <div>&#187;</div>
        </button>
      </div>
    )
  }
}
