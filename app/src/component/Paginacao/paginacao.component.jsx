import React, { Component } from 'react'
import './paginacao.style.css'

export class Paginacao extends Component {
  constructor(props){
    super(props)
    this.state = {
      desabilitado: 'desabilitado',
      disablebotao: false
    }
  }

  render(){
    return(
      <div className="container-paginacao">
        <button className={`${this.props.paginaAtual > 0 ? "botao-paginacao" : this.state.desabilitado}`}
          onClick={this.props.paginaAtual > 0 ? () => this.props.onClick(this.props.paginaAtual - 1) : undefined}>
          &laquo;
        </button>
        <div className="bloco-principal-paginacao">
          {this.props.paginaAtual+1}
        </div>
        <button className={`${(this.props.totalPaginas > this.props.paginaAtual + 1) ? "botao-paginacao" : this.state.desabilitado}`} onClick={
                            this.props.totalPaginas > this.props.paginaAtual + 1
                            ?
                            () => this.props.onClick(this.props.paginaAtual + 1)
                            :
                            undefined }>
          <div>&#187;</div>
        </button>
      </div>
    )
  }
}
