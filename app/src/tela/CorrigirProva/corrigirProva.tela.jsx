import React, { Component } from 'react'
import { retornarProvaComRespostas } from '../../services/prova/prova.service'

const objetoCorrecaoProva = { idQuestao: null, idResposta: null, nota: 0, comentario: '' }

export class CorrigirProvaScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      idProva: 73,
      prova: null,
      arrayRespostas: [objetoCorrecaoProva]
    }
  }
  
  render() {
    console.log(this.state.prova);
    
    return (
      <div className="container-tela">
        <h1>oi</h1>
      </div>
    )
  }

  componentDidMount = async () => {
    this.setState({
      prova: await retornarProvaComRespostas(this.state.idProva)
    })
  }



}


