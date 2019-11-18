import React, { PureComponent } from 'react';
import { QuestaoUnica } from '../../index'
import { adicionarQuestaoTecnica } from '../../../services/index'

import { store } from 'react-notifications-component'
import 'react-notifications-component/dist/theme.css'
import 'animate.css'

export class CadastroTecnica extends PureComponent {

  constructor(props){
    super(props)
    this.state = {
      linguagens: props.linguagens,
      niveis: props.niveis,
      especificidade: null,
      nivel: null,
      questao: null
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

    try{
			await adicionarQuestaoTecnica(questao)
      store.addNotification({
        title: 'Sucesso',
        message: 'Questão adicionada com sucesso',
        type: 'success',
        container: 'top-right',
        animationIn: ["animated", "fadeIn"],
        animationOut: ["animated", "fadeOut"],
        dismiss: {
          duration: 3000
        }
			})
    }
    catch(error){
      if (error.response.data.errors) {
        error.response.data.errors.map(message => {
          return store.addNotification({
            title: 'Falha',
            message: `${message.defaultMessage}`,
            type: 'danger',
            container: 'top-right',
            animationIn: ["animated", "fadeIn"],
            animationOut: ["animated", "fadeOut"],
            dismiss: {
              duration: 3000
            }
          })
        })
      }else {
        store.addNotification({
          title: 'Falha',
          message: `${error.response.data.message}`,
          type: 'danger',
          container: 'top-right',
          animationIn: ["animated", "fadeIn"],
          animationOut: ["animated", "fadeOut"],
          dismiss: {
            duration: 3000
          }
        })
      }
    }
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
