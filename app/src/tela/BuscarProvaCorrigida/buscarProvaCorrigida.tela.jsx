import React, { Component } from 'react'
import { retornaProvasCorrigidas } from '../../services/index'
import { CardProva, Input, BotaoPrincipal } from '../../component/index'
import './buscarProvaCorrigida.style.css'

export class BuscarProvaJaCorrigidaScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      pesquisa: '',
      provas: null,
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
    this.setState({
      provas: await retornaProvasCorrigidas(this.state.pesquisa)
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
                  onClick={this.handleClickCorrigirProva}/>
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
      <div className="container-botao">
        <BotaoPrincipal nome="Enviar" onClick={this.handleClickEnviarPesquisa} />
      </div>
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
