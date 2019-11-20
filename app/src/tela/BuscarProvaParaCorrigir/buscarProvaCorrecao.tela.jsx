import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import { CardProva } from '../../component/index'
import { CorrigirProvaScreen } from '../index'

export class BuscarProvaCorrecaoScreen extends Component{
  constructor(props){
    super(props)
    this.state = {
      provas: [],
      deveRedirecionarParaCorrecao: false
    }
  }

  async componentDidMount() {
    this.setState({
      provas: [] //await retornaProvasParaCorrecao()
    }, () => {
      this.buscarProvas()
    })
  }

  buscarProvas = async () => {
    setTimeout(
      async () => { 
        this.setState({
          provas: []//await retornaCorridasChamadasMotorista(),
        }, () => { this.buscarProvas() })
      }
    , 2000)
  }

  onClickCorrigirProva = (event, idProva) => {
    event.preventDefault()
    localStorage.setItem('idProvaParaCorrigir', idProva)
    this.setState({
      deveRedirecionarParaCorrecao: true
    })
  }

  renderProvas(){
    this.state.provas.map((key, item) => {
      return <CardProva
              key={key}
              id={item.id}
              informacaoUm={item.nomeCandidato}
              informacaoDois={item.emailCandidato}
              informacaoTres={item.tempoDeDuracaoDaProva}
              onClick={this.onClickCorrigirProva}/>
    })
  }

  render() {
    if(this.state.deveRedirecionarParaCorrecao){
      return <Redirect to={CorrigirProvaScreen}/>
    }

    return(
      <div className="container-tela">
        <div className="container-titulo">
          <span className="titulo-crie">Provas para serem corrigidas</span>
        </div>
        <div className="container-cards">
          {this.renderProvas()}
        </div>
      </div>
    )
  }
}
