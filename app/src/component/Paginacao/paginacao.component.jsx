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

  verificaClasseDoBotao(variavelMaior, variavelMenor){
    if(variavelMaior > variavelMenor){
      return "botao-paginacao"
    }else{
      return this.state.desabilitado
    }
  }

  verificaClickBotao(variavelMaior, variavelMenor, variavelOnClick){
    if(variavelMaior > variavelMenor){
      return () => this.props.onClick(this.props.paginaAtual - 1)
    }else{
      return undefined
    }
  }

  render(){
    return(
      <div className="container-paginacao">
        <button 
          className={this.verificaClasseDoBotao(this.props.paginaAtual, 0)} 
          onClick={this.verificaClickBotao(this.props.paginaAtual, 0, this.props.paginaAtual - 1)}
        > &laquo; </button>

        <div className="bloco-principal-paginacao">
          {this.props.paginaAtual+1}
        </div>

        <button 
          className={this.verificaClasseDoBotao(this.props.totalPaginas, this.props.paginaAtual + 1)} 
          onClick={this.verificaClickBotao(this.props.totalPaginas, this.props.paginaAtual + 1, this.props.paginaAtual + 1)}
        > &#187; </button>
      </div>
    )
  }
}
