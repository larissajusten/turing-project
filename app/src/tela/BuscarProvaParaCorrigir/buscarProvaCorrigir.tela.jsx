import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import { CardProva, Paginacao } from '../../component/index'
import { retornaProvasParaCorrecao } from '../../services/index'
import './buscarProvaCorrigir.style.css'

export class BuscarProvaParaCorrigirScreen extends Component{
  constructor(props){
    super(props)
    this.state = {
      provas: [],
      totalPaginas: null,
      per_page: null,
      current_page: 0,
      idProvaParaCorrigir: 0,
      deveRedirecionarParaCorrecao: false
    }
  }

  async componentDidMount() {
    let dadosDaResponse = await retornaProvasParaCorrecao(this.state.current_page)
    this.setState({
      provas: dadosDaResponse[0],
      totalPaginas: dadosDaResponse[1],
      per_page: dadosDaResponse[2],
      current_page: dadosDaResponse[3]
    }, () => {
      this.buscarProvas()
    })
  }

  buscarProvas = async () => {
    setTimeout(
      async () => {
        let dadosDaResponse = await retornaProvasParaCorrecao(0)
        this.setState({
          provas: dadosDaResponse[0],
          totalPaginas: dadosDaResponse[1],
          per_page: dadosDaResponse[2],
          current_page: dadosDaResponse[3]
        }, () => { this.buscarProvas() })
      }
    , 20000)
  }

  onClickCorrigirProva = (event, idProva) => {
    event.preventDefault()
    this.setState({
      idProvaParaCorrigir: idProva
    }, () => { this.setState({ deveRedirecionarParaCorrecao: true }) })
  }

  buscaPagina = async pageNumber => {
    let dadosDaResponse = await retornaProvasParaCorrecao(pageNumber)

    this.setState({
      provas: dadosDaResponse[0],
      total: dadosDaResponse[1],
      per_page: dadosDaResponse[2],
      current_page: dadosDaResponse[3],
    })
  }

  renderCardsProvas(){
    return(
      <>
      {
        this.state.provas.map((item, key) => {
          return <CardProva
                key={key}
                id={item.id}
                informacaoUm={item.nomeCandidato}
                informacaoDois={item.emailCandidato}
                informacaoTres={item.tempoDeDuracaoDaProva}
                onClick={this.onClickCorrigirProva}/>
        })
      }
      </>
    )
  }

  renderProvas(){
    return(
      <>
        <div className="container-titulo">
          <span className="titulo-crie">Provas para serem corrigidas</span>
        </div>
        <div className="container-cards">
          {this.renderCardsProvas()}
        </div>
        <Paginacao
          totalPaginas={this.state.totalPaginas}
          paginaAtual={this.state.current_page}
          onClickVoltar={this.buscaPagina}
          onClickProxima={this.buscaPagina}/>
      </>
    )
  }

  render() {
    if(this.state.deveRedirecionarParaCorrecao){
      return <Redirect to={`/corrigir-prova/${this.state.idProvaParaCorrigir}`}/>
    }

    return(
      <div className="container-tela">
      {
        this.state.provas.length > 0 ? this.renderProvas() :
        <div className="container-titulo">
          <span className="titulo-crie">Não há provas para serem corrigidas</span>
        </div>
      }
      </div>
    )
  }
}
