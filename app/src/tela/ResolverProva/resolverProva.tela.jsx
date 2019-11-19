import React, { Component } from 'react'
import './resolverProva.style.css';
import { retornaProva } from '../../services/index'
import { IniciarProvaModal } from '../../component/index'

export class ResolverProvaScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      idProva: 60,
      prova: null,
      modalIniciarProva: true,
      count: 2000
    }
  }

  componentDidMount = async () => {
    this.setState({
      prova: await retornaProva(this.state.idProva)
    }/*, () => {
      this.setState({
        count: this.state.prova.duracao
      })
    }*/)
  }

  contador = () => {
    this.interval = setInterval(() => {
        this.setState({
            count: this.state.count - 1
        })
        if(this.state.count < 0){
          this.setState({ 
            modalFim: true,
            count: 0,
            terminoPorTempo: true
          })
          clearInterval(this.interval)
        }
    }, 1000 )
  }

  handleClickIniciarProva = () => {
    this.setState({
      modalIniciarProva: false
    })
    this.contador()
  }

  renderProva() {
    return(
      <div className="container-tela">
        <div className="container-titulo">
          <span className="titulo-crie">Boa prova</span>
        </div>

      </div>
    )
  }
  
  render() {
    console.log(this.state.count)
    return(
      <>
      { this.state.modalIniciarProva ? <IniciarProvaModal onClick={this.handleClickIniciarProva}/> : this.renderProva() }
      </>
    )
  }
}