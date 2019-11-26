import React, { PureComponent } from 'react';
import { QuestaoUnica, Notificacao } from '../../index'
import { adicionarQuestaoTecnica } from '../../../services/index'

export class CadastroTecnica extends PureComponent {

  constructor(props){
    super(props)
    this.state = {
      linguagens: props.linguagens,
      niveis: props.niveis,
      especificidade: null,
      nivel: null,
      questao: null,
      respostaBase: null,
      testeBase: null
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
      "nivelDeDificuldade": this.state.nivel,
      "testeBase": this.state.testeBase,
      "respostaBase": this.state.respostaBase
    }

    try{
      await adicionarQuestaoTecnica(questao)
      Notificacao('Sucesso', 'Questão adicionada com sucesso', 'success')
    }
    catch(error){
      if (error.response.data.errors) {
        error.response.data.errors.map(message => {
          return Notificacao('Falha', `${message.defaultMessage}`, 'warning')
        })
      }else {
        Notificacao('Falha', `${error.response.data.message}`, 'danger')
      }
    }
  }

  render() {
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
