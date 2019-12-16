import React, { PureComponent } from 'react'
import { Redirect } from 'react-router-dom'
import { QuestaoUnica, Notificacao } from '../../'
import { QuestaoDissertativaService } from '../../../services'

export class CadastroDissertativa extends PureComponent {

  constructor(props) {
    super(props)
    this.state = {
      linguagens: props.linguagens,
      niveis: props.niveis,
      especificidade: '',
      nivel: '',
      questao: '',
      deveRedirecionarParaDashboard: false
    }
    this.questaoDissertativaService = new QuestaoDissertativaService()
  }

  handleClickSalvarQuestao = async (event) => {
    event.preventDefault()

    const questaoDissertativa = {
      "questao": this.state.questao,
      "nivelDeDificuldade": this.state.nivel,
      "especificidade": this.state.especificidade
    }

    try {
      await this.questaoDissertativaService.adicionarQuestaoDissertativa(questaoDissertativa)
      Notificacao('Sucesso', 'Questão adicionada com sucesso', 'success')
      this.setState({
        deveRedirecionarParaDashboard: true
      })
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
    if (this.state.deveRedirecionarParaDashboard) {
			return <Redirect to="/" />
		}
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
