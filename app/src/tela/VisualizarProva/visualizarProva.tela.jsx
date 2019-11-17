import React, { Component } from 'react';
import './visualizarProva.style.css'

export class VisualizarProvaScreen extends Component {

  constructor(props){
    super(props)
    this.state = {
      idProva: localStorage.getItem('idProva')
    }
  }

  render(){
    console.log(this.state.idProva)
    return(
      <div className="tela-cadastro">
        <h1>Oi</h1>
      </div>
    )
  }
}