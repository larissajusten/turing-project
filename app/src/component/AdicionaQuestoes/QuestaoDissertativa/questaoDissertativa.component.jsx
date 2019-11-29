import React, { PureComponent } from 'react';
import { QuestaoUnica, Notificacao } from '../../index'
import { adicionarQuestaoDissertativa } from '../../../services/index'

export class CadastroDissertativa extends PureComponent {

  constructor(props) {
    super(props)
    this.state = {
      linguagens: props.linguagens,
      niveis: props.niveis,
      especificidade: '',
      nivel: '',
      questao: ''
    }
  }

  handleClickSalvarQuestao = async (event) => {
    event.preventDefault()

    const questaoDissertativa = {
      "questao": this.state.questao,
      "nivelDeDificuldade": this.state.nivel,
      "especificidade": this.state.especificidade
    }

    try {
      await adicionarQuestaoDissertativa(questaoDissertativa)
      Notificacao('Sucesso', 'Questão adicionada com sucesso', 'success')
    }
    catch (error) {
      if (error.response.data.errors) {
        error.response.data.errors.map(message => {
          return Notificacao('Falha', `${message.defaultMessage}`, 'warning')
        })
      } else {
        Notificacao('Falha', `${error.response.data.message}`, 'danger')
      }
    }
  }

  handleChange = (event) => {
    const { name, value } = event.target
    this.setState({ [name]: value })
  }

  render() {
    return (
      <>
        <QuestaoUnica
          linguagens={this.state.linguagens}
          niveis={this.state.niveis}
          especificidade={this.state.especificidade}
          nivel={this.state.nivel}
          questao={this.state.questao}
          handleChange={this.handleChange}
          handleClickSalvarQuestao={this.handleClickSalvarQuestao} />
      </>
    )
  }
}
