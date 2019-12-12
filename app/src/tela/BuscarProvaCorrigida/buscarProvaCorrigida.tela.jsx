import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import { retornaProvasCorrigidas } from '../../services/index'
import { CardProva, Input, BotaoPrincipal, Notificacao } from '../../component/index'
import './buscarProvaCorrigida.style.css'

export class BuscarProvaJaCorrigidaScreen extends Component {
  constructor(props) {
    super(props)
    this.state = {
      pesquisa: '',
      provas: [], 
      idProva: ''
    }
  }

  handleChange = (event) => {
    const { name, value } = event.target
    this.setState({
      [name]: value
    })
  }

  handleClickEnviarPesquisa = async (event) => {
    event.preventDefault()
    try {
      let provasResponse = await retornaProvasCorrigidas(this.state.pesquisa)
      Notificacao('Sucesso', 'Provas encontradas', 'success')
      this.setState({
        provas: provasResponse
      })
    } catch (error) {
      if (error.response.data.errors) {
        error.response.data.errors.map(message => {
          return Notificacao('Falha', `${message.defaultMessage}`, 'warning')
        })
      } else {
        Notificacao('Falha', `${error.response.data.message}`, 'danger')
      }
    }
  }

  handleClickGerarPDFProva = (event, idProva) => {
    this.setState({
      idProva,
      deveRedirecionarParaProva: true
    })
  }

  renderCardsProvas() {
    return (
      <>
        {
          this.state.provas.map((item, key) => {
            return <CardProva
              key={key}
              id={item.id}
              informacaoUm={item.nomeCandidato}
              informacaoDois={item.emailCandidato}
              informacaoTres={item.tempoDeDuracaoDaProva}
              onClick={this.handleClickGerarPDFProva}
              nomeBotao="RELATÓRIO"/>
          })
        }
      </>
    )
  }

  renderProvas() {
    return (
      <>
        <div className="container-titulo">
          <span className="titulo-crie">Provas corrigidas</span>
        </div>
        <div className="container-cards">
          {this.renderCardsProvas()}
        </div>
      </>
    )
  }

  renderPesquisar() {
    return (
      <>
        <div className="container-titulo">
          <span className="titulo-crie">Busque o candidato</span>
        </div>

        <Input
          name="pesquisa"
          value={this.state.pesquisa}
          onChange={this.handleChange}
          maxTam="300"
          type="text"
          label=""
          placeholder="Digite o nome ou email do candidato" />

        <div className="container-botao">
          <BotaoPrincipal nome="ENVIAR" onClick={this.handleClickEnviarPesquisa} />
        </div>
        {this.state.provas.length > 0 && this.renderProvas()}
      </>
    )
  }

  render() {
    if (this.state.deveRedirecionarParaProva) {
      return <Redirect to={`/prova-PDF/${this.state.idProva}`}/>
    }

    return (
      <div className="container-tela tela-prova-corrigida">
        {this.renderPesquisar()}
      </div>
    )
  }
}
