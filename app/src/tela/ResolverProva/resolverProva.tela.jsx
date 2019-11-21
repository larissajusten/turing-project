import React, { Component } from 'react'
import './resolverProva.style.css';
import { retornaProva, iniciarProva, enviarRespostasDaProva, retornarTipoDeQuestao } from '../../services/index'
import { ProvaModal,
        RespondeQuestaoUnicaResposta,
        RespondeQuestaoMultiplasRespostas,
        BotaoPrincipal } from '../../component/index'

const objetoResposta = { idQuestao: null, tipo: null, resposta: null }

export class ResolverProvaScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      modalIniciarProva: true,
      renderProva: false,
      modalFinalizarProva: false,
      count: 5000,
      idProva: 72, //localStorage.getItem('idProva'),
      prova: null,
      tiposDeQuestoes: [],
      resposta: null,
      statusProva: null,
      arrayRespostas: [objetoResposta]
    }
    this.lengthDissertativas = 0
    this.lengthTecnicas = 0
  }

  componentDidMount = async () => {
    this.setState({
      prova: await retornaProva(this.state.idProva),
      tiposDeQuestoes: await retornarTipoDeQuestao()
    }, () => {
      const quantidadeObjetos = (this.state.prova.questoesDeMultiplaEscolha.length +
                                  this.state.prova.questoesDissertativas.length +
                                  this.state.prova.questoesTecnicas.length)

      const newArray = [...new Array(quantidadeObjetos)]
      const arrayRespostas = newArray.map(() => ({ ...objetoResposta }))

      this.setState({
        count: this.state.prova.tempoDeDuracaoDaProva,
        arrayRespostas
      })

      this.lengthMultiplasEscolhas = this.state.prova.questoesDeMultiplaEscolha.length
      this.lengthDissertativas = this.state.prova.questoesDissertativas.length
      this.lengthTecnicas = this.state.prova.questoesTecnicas.length
    })
  }

  contador = async () => {
    this.interval = setInterval( async () => {
      this.setState({
        count: this.state.count - 1
      })
      if(this.state.count < 0){
        this.setState({
          modalFinalizarProva: true,
          count: 0,
        })
        clearInterval(this.interval)
      }
    }, 1000 )
  }

  adicionaObjetoResposta = () => {
    this.setState({
      arrayRespostas: [...this.state.arrayRespostas, objetoResposta]
    })
  }

  handleClickResponderQuestoesUnicaResposta = (event, index, idQuestao, tipo) => {
    const { name, value } = event.target

    const array = this.state.arrayRespostas

    array[index][name] = value;
    array[index].idQuestao = idQuestao;
    array[index].tipo = tipo;

    this.setState({
      arrayRespostas: array
    })
  }

  handleClickResponderQuestoesMultiplasRespostas = (event, index, idQuestao, idAlternativa, tipo) => {
    event.preventDefault()
    const array = [...this.state.arrayRespostas]

    array[index].resposta = idAlternativa;
    array[index].idQuestao = idQuestao;
    array[index].tipo = tipo;

    this.setState({
      arrayRespostas: array
    }, () => { this.adicionaObjetoResposta() })
  }

  handleClickIniciarProva = async(event) => {
    event.preventDefault()
    this.setState({
      modalIniciarProva: false,
      iniciarProva: true
    })
    this.contador()
    await iniciarProva(this.state.idProva)
  }

  handleClickFinalizarProva = () => {
    return null
  }

  handleClickEnviarProva = async(event) => {
    event.preventDefault()
    console.log(this.state.arrayRespostas)
    this.setState({
      iniciarProva: false,
      modalFinalizarProva: true,
      statusProva: await enviarRespostasDaProva(this.state.idProva, this.state.arrayRespostas)
    })
  }

  renderQuestoesTecnicas() {
    return (
      <>
      {
        this.state.prova.questoesTecnicas &&
        this.state.prova.questoesTecnicas.map((item, key) => {
          return <RespondeQuestaoUnicaResposta
                    key={key}
                    index={key}
                    tipo={this.state.tiposDeQuestoes}
                    idQuestao={item.id}
                    questao={item.questao}
                    resposta={this.state.arrayRespostas[key+this.lengthMultiplasEscolhas+this.lengthDissertativas].resposta}
                    handleChange={this.handleClickResponderQuestoesUnicaResposta}/>
        })
      }
      </>
    )
  }

  renderQuestoesDissertativas() {
    return (
      <>
      {
        this.state.prova.questoesDissertativas &&
        this.state.prova.questoesDissertativas.map((item, key) => {
          return <RespondeQuestaoUnicaResposta
                    key={key}
                    index={key}
                    tipo={this.state.tiposDeQuestoes}
                    idQuestao={item.id}
                    questao={item.questao}
                    resposta={this.state.arrayRespostas[key+this.lengthMultiplasEscolhas].resposta}
                    handleChange={this.handleClickResponderQuestoesUnicaResposta}/>
        })
      }
      </>
    )
  }

  renderQuestoesMultiplasEscolhas() {
    return (
      <>
      {
        this.state.prova.questoesDeMultiplaEscolha &&
        this.state.prova.questoesDeMultiplaEscolha.map((item, key) => {
          return <RespondeQuestaoMultiplasRespostas
                  key={key}
                  index={key}
                  tipo={this.state.tiposDeQuestoes}
                  idQuestao={item.id}
                  questao={item.questao}
                  onClick={this.handleClickResponderQuestoesMultiplasRespostas}/>
        })
      }
      </>
    )
  }

  renderProva() {
    return(
      <>
      {
        this.state.prova &&
        <div className="container-tela">
          <div className="container-titulo">
            <span className="titulo-crie">Boa prova</span>
            <span> {this.state.count} </span>
          </div>

          {this.renderQuestoesMultiplasEscolhas()}
          {this.renderQuestoesDissertativas()}
          {this.renderQuestoesTecnicas()}

          <div className="container-botao">
            <BotaoPrincipal nome="Enviar" onClick={this.handleClickEnviarProva} />
          </div>
        </div>
      }
      </>
    )
  }

  renderModalIniciar(){
    return(
      <>
      <ProvaModal
        titulo="Clique em iniciar para realizar sua prova"
        nomeBotao="Começar"
        comBotao={true}
        onClick={this.handleClickIniciarProva}/>
      </>
    )
  }

  renderModalFinalizar(){
    return(
      <>
      {
        this.state.modalFinalizarProva &&
        <ProvaModal
          titulo="Sua prova terminou"/>
      }
      </>
    )
  }

  render() {
    return(
      <>
      { this.state.modalIniciarProva && this.renderModalIniciar() }
      { this.state.iniciarProva && this.renderProva() }
      { this.state.modalFinalizarProva && this.renderModalFinalizar() }
      </>
    )
  }
}
