import React, { Component } from 'react';
import { Redirect } from 'react-router-dom'
import './visualizarProva.style.css'
import { MostrarQuestaoUnica,
        MostrarMultiplasRespostas,
        BlocoVisualizar,
        Notificacao,
        BotaoPrincipal } from '../../component/index'
import { retornaProva,
          cancelarProva,
          removerQuestaoDissertativa,
          removerQuestaoTecnica,
          removerQuestaoMultiplaEscolha,
          enviarEmail } from '../../services/index'

const mensagemSucessoNotificacao = 'Questão removida com sucesso'

export class VisualizarProvaScreen extends Component {

  constructor(props) {
    super(props)
    this.state = {
      idProva: this.props.match.params.idProva,
      prova: null,
      semProvaParaMostrar: true
    }
  }

  async componentDidMount() {
    localStorage.removeItem('idProva')
    this.setState({
      prova: await retornaProva(this.state.idProva)
    })
  }

  handleClickVoltarProva = async (event) => {
    event.preventDefault()
    this.setState({
      deveRedirecionarParaDashboard: true
    })
  }

  handleClickEnviarProva = async (event) => {
    event.preventDefault()
    try {
      Notificacao('Sucesso', 'Prova enviada com sucesso', 'success')
      await enviarEmail(this.state.prova.emailCandidato)
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

  handleClickCancelarProva = async(event) => {
    event.preventDefault()
    try {
      Notificacao('Sucesso', 'Prova cancelada com sucesso', 'success')
      await cancelarProva(this.state.idProva)
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

  removerQuestaoDissertativa = async (idDaQuestao) => {
    await removerQuestaoDissertativa(this.state.idProva, idDaQuestao)
    Notificacao('Sucesso', mensagemSucessoNotificacao, 'success')
    this.setState({
      prova: await retornaProva(this.state.idProva)
    })
  }

  removerQuestaoTecnica = async (idDaQuestao) => {
    await removerQuestaoTecnica(this.state.idProva, idDaQuestao)
    Notificacao('Sucesso', mensagemSucessoNotificacao, 'success')
    this.setState({
      prova: await retornaProva(this.state.idProva)
    })
  }

  removerQuestaoMultiplaEscolha = async (idDaQuestao) => {
    await removerQuestaoMultiplaEscolha(this.state.idProva, idDaQuestao)
    Notificacao('Sucesso', mensagemSucessoNotificacao, 'success')
    this.setState({
      prova: await retornaProva(this.state.idProva)
    })
  }

  verificaAlternativa(item) {
    if (item.alternativaA.respostaCorreta === "Alternativa A"){
      return "Alternativa A"
    }else if (item.alternativaB.respostaCorreta === "Alternativa B"){
      return "Alternativa B"
    }else if (item.alternativaC.respostaCorreta === "Alternativa C"){
      return "Alternativa C"
    }else if (item.alternativaD.respostaCorreta === "Alternativa D"){
      return "Alternativa D"
    }else{
      return "Alternativa E"
    }
  }

  renderMultiplasEscolhas() {
    if(this.state.prova.questoesDeMultiplaEscolha){
      return (
        this.state.prova.questoesDeMultiplaEscolha.map((item, key) => {
          return <MostrarMultiplasRespostas
            key={key}
            id={item.id}
            questaoNome="Questão multipla escolha"
            questao={item.questao}
            nivel={item.nivelDeDificuldade}
            especificidade={item.especificidade}
            alternativaA={item.alternativaA.resposta}
            alternativaB={item.alternativaB.resposta}
            alternativaC={item.alternativaC.resposta}
            alternativaD={item.alternativaD.resposta}
            alternativaE={item.alternativaE.resposta}
            respostaCorreta={this.verificaAlternativa(item)}
            onClick={this.removerQuestaoMultiplaEscolha} />
        })
      )
    }else{
      return null
    }
  }

  renderQuestoesTecnicas() {
    if(this.state.prova.questoesTecnicas){
      return (
        this.state.prova.questoesTecnicas.map((item, key) => {
          return <MostrarQuestaoUnica
            key={key}
            id={item.id}
            questaoNome="Questão técnica"
            questao={item.questao}
            nivel={item.nivelDeDificuldade}
            especificidade={item.especificidade}
            onClick={this.removerQuestaoTecnica} />
        })
      )
    }else{
      return null
    }
  }

  renderQuestoesDissertativas() {
    if(this.state.prova.questoesDissertativas){
      return (
        this.state.prova.questoesDissertativas.map((item, key) => {
          return <MostrarQuestaoUnica
            key={key}
            id={item.id}
            questaoNome="Questão dissertativa"
            questao={item.questao}
            nivel={item.nivelDeDificuldade}
            especificidade={item.especificidade}
            onClick={this.removerQuestaoDissertativa} />
        })
      )
    }else{
      return null
    }
  }

  render() {
    if (this.state.deveRedirecionarParaDashboard) {
      return <Redirect to="/" />
    }
    if (this.state.prova){
      return (
        <div className="container-tela">
          <div className="container-titulo">
            <span className="titulo-crie">Essa é a prova que você criou</span>
          </div>

          <div className="container-infos">
            <BlocoVisualizar
              classe="blocoVisualizar-email"
              nome="Nome do candidato"
              conteudo={this.state.prova.nomeCandidato}/>

            <BlocoVisualizar
              classe="blocoVisualizar-email"
              nome="Email do candidato"
              conteudo={this.state.prova.emailCandidato}/>

            <div className="container-infos-tempos">
              <BlocoVisualizar
                classe="blocoVisualizar-tempo"
                nome="Tempo de duração (minutos)"
                conteudo={this.state.prova.tempoDeDuracaoDaProva}/>

              <BlocoVisualizar
                classe="blocoVisualizar-tempo"
                nome="Tempo para inicio (horas)"
                conteudo={this.state.prova.tempoParaInicioProva}/>
            </div>
          </div>

          {this.renderQuestoesDissertativas()}
          {this.renderQuestoesTecnicas()}
          {this.renderMultiplasEscolhas()}
          <div className="container-botao container-botao-prova">
            <BotaoPrincipal nome="ENVIAR POR E-MAIL" onClick={this.handleClickEnviarProva}/>
            <BotaoPrincipal nome="CANCELAR" onClick={this.handleClickCancelarProva} />
            <BotaoPrincipal nome="SAIR" onClick={this.handleClickVoltarProva}/>
          </div>
        </div>
      )
    }else{
      return (
        <div className="container-tela">
          <div className="container-titulo">
            <span className="titulo-crie">Não há prova criada para visualizar</span>
          </div>
        </div>
      )
    }
  }
}
