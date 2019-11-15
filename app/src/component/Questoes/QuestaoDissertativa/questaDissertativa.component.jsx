import React, { PureComponent } from 'react';
import './QuestaoDissertativa.style.css'
import { QuestaoUnica } from '../../index'
import { adicionaQuestaoDissertativa } from '../../../services/index'

export class CadastroDissertativa extends PureComponent {

  constructor(props){
    super(props)
    this.state = {
      linguagens: props.linguagens,
      niveis: props.niveis,
      especificidade: '',
      nivel:'',
      questao: ''
    }
  }

  handleChange = (event) => {
    const { name, value } = event.target
    this.setState({
        [name]: value
    })
  }

  handleClickSalvarQuestao = async (event) => {
    event.preventDefault()

    const questao = {
      "questao": this.state.questao,
      "nivelDeDificuldade": this.state.nivel,
      "especificidade": this.state.especificidade
    }

    await adicionaQuestaoDissertativa(questao)
  }

  render() {
    return(
      <>
      <QuestaoUnica 
        linguagens = {this.state.linguagens}
        niveis = {this.state.niveis}
        especificidade = {this.state.especificidade}
        nivel = {this.state.nivel}
        questao = {this.state.questao}
        handleChange = {this.handleChange} 
        handleClickSalvarQuestao = {this.handleClickSalvarQuestao}/>
      </>
    )
  }
}
