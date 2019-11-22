import React, { Component } from 'react'
import { retornaProvasCorrigidas } from '../../services/index'
import { Paginacao, CardProva, Input, BotaoPrincipal } from '../../component/index'
import './buscarProvaCorrigida.style.css'

export class BuscarProvaJaCorrigidaScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      pesquisa: '',
      provas: null,
      totalPaginas: null,
      per_page: null,
      current_page: 0,
      deveRedirecionarParaProva: false
    }
  }

  handleChange = (event) => {
    const { name, value } = event.target
    this.setState({
      [name]: value
    })
  }

  handleClickEnviarPesquisa = async () => {
    let dadosDaResponse = "get com o filtro"//await retornaProvasCorrigidas(this.state.current_page)
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
        let dadosDaResponse = await retornaProvasCorrigidas(0)
        this.setState({
          provas: dadosDaResponse[0],
          totalPaginas: dadosDaResponse[1],
          per_page: dadosDaResponse[2],
          current_page: dadosDaResponse[3]
        }, () => { this.buscarProvas() })
      }
    , 20000)
  }

  buscaPagina = async (pageNumber) => {
    let dadosDaResponse = await retornaProvasCorrigidas(pageNumber)

    this.setState({
      questoes: dadosDaResponse[0],
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
          <span className="titulo-crie">Provas corrigidas</span>
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

  verificaSeExisteProvas() {
    return(
      <>
      {
        this.state.provas ? this.renderProvas()
        :
        <>
        <h1>Não há provas para serem corrigidas</h1>
        <div className="container-botao">
          <BotaoPrincipal nome="Enviar" onClick={this.handleClickEnviarPesquisa} />
        </div>
        </>
      }
      </>
    )
  }

  renderPesquisar(){
    return(
      <>
      <div className="container-titulo">
        <span className="titulo-crie">Busque o candidato</span>
      </div>

      <Input
        name="pesquisa"
        value={this.state.pesquisa}
        onChange={this.handleChange}
        classNameDiv="div-input-busca-usuario"
        maxTam="300"
        type="text"
        label=""
        placeholder="Digite o nome ou email do candidato"/>

      {this.verificaSeExisteProvas()}
      </>
    )
  }

  render(){
    return(
      <div className="container-tela">
        {this.renderPesquisar()}
      </div>
    )
  }
}
