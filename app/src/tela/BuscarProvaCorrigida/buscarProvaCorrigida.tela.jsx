import React, { Component } from 'react'
import { retornaProvasCorrigidas } from '../../services/index'

export class BuscarProvaJaCorrigidaScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      provas: null,
      totalPaginas: null,
      per_page: null,
      current_page: 0,
      deveRedirecionarParaProva: false
    }
  }

  async componentDidMount(){
    let dadosDaResponse = await retornaProvasCorrigidas(this.state.current_page)
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

  buscaPagina = async pageNumber => {
    let dadosDaResponse = await retornaProvasCorrigidas(pageNumber)

    this.setState({
      questoes: dadosDaResponse[0],
      total: dadosDaResponse[1],
      per_page: dadosDaResponse[2],
      current_page: dadosDaResponse[3],
    })
  }

  render(){
    console.log(this.state.provas)
    return(
      <div className="container-tela">
        <h1>Oi</h1>
      </div>
    )
  }
}