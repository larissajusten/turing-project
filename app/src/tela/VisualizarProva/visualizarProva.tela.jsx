import React, { Component } from 'react';
import './visualizarProva.style.css'
import { renderQuestaoUnica } from '../../component/index'

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
      <div className="container-tela">
        <renderQuestaoUnica />
      </div>
    )
  }
}