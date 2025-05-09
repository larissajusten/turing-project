import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import { CardProva, Paginacao } from '../../component/'
import { BuscarProvaService } from '../../services/'
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
    this.buscarProvaService = new BuscarProvaService()
  }

  async componentDidMount() {
    let dadosDaResponse = await this.buscarProvaService
      .retornaProvasParaCorrecao(this.state.current_page)
    this.setState({
      provas: dadosDaResponse[0],
      totalPaginas: dadosDaResponse[1],
      per_page: dadosDaResponse[2],
      current_page: dadosDaResponse[3]
    })
  }

  onClickCorrigirProva = (event, idProva) => {
    
    this.setState({
      idProvaParaCorrigir: idProva
    }, () => { this.setState({ deveRedirecionarParaCorrecao: true }) })
  }

  buscaPagina = async pageNumber => {
    let dadosDaResponse = await this.buscarProvaService.retornaProvasParaCorrecao(pageNumber)

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
                onClick={this.onClickCorrigirProva}
                nomeBotao="CORRIGIR"
                especificidades={item.especificidades}
                quantidadeQuestoes={item.numeroQuestoes}
                paraCorrigir={true}/>
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
          onClick={this.buscaPagina}/>
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
