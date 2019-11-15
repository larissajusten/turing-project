import React, { PureComponent } from 'react';
import { QuestaoUnica } from '../../index'
import { adicionaQuestaoTecnica } from '../../../services/index'

export class CadastroTecnica extends PureComponent {

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
      "especificidade": this.state.especificidade,
      "nivelDeDificuldade": this.state.nivel
    }
    await adicionaQuestaoTecnica(questao)
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
