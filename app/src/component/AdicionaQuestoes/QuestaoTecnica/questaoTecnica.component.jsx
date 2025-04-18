import React, { PureComponent } from 'react'
import { Redirect } from 'react-router-dom'
import { QuestaoUnica, Notificacao } from '../../'
import { QuestaoTecnicaService } from '../../../services/'

export class CadastroTecnica extends PureComponent {

  constructor(props){
    super(props)
    this.state = {
      linguagens: props.linguagens,
      niveis: props.niveis,
      especificidade: '',
      nivel: '',
      questao: '',
      respostaBase: '',
      testeBase: '',
      deveRedirecionarParaDashboard: false
    }
    this.questaoTecnica = new QuestaoTecnicaService()
  }

  handleChange = (event) => {
    const { name, value } = event.target
    this.setState({ [name]: value })
  }

  catchErrorENotifica(error){
    if (error.response.data.errors) {
      error.response.data.errors.map(message => {
        return Notificacao('Falha', `${message.defaultMessage}`, 'warning')
      })
    } else {
      Notificacao('Falha', `${error.response.data.message}`, 'danger')
    }
  }

  handleClickSalvarQuestao = async (event) => {
    

    const questaoTecnica = {
      "questao": this.state.questao,
      "especificidade": this.state.especificidade,
      "nivelDeDificuldade": this.state.nivel,
      "testeBase": this.state.testeBase,
      "respostaBase": this.state.respostaBase
    }

    try{
      await this.questaoTecnica.adicionarQuestaoTecnica(questaoTecnica)
      Notificacao('Sucesso', 'Questão adicionada com sucesso', 'success')
      this.setState({
        deveRedirecionarParaDashboard: true
      })
    }
    catch(error){
      this.catchErrorENotifica(error)
    }
  }

  render() {
    if (this.state.deveRedirecionarParaDashboard) {
			return <Redirect to="/" />
		}
    return(
      <>
      <QuestaoUnica
        questaoTipoTecnica={true}
        linguagens = {this.state.linguagens}
        niveis = {this.state.niveis}
        especificidade = {this.state.especificidade}
        nivel = {this.state.nivel}
        questao = {this.state.questao}
        resposta = {this.state.respostaBase}
        testes = {this.state.testeBase}
        handleChange = {this.handleChange}
        handleClickSalvarQuestao = {this.handleClickSalvarQuestao}/>
      </>
    )
  }
}
