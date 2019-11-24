import React, { Component } from 'react'
import './resolverProva.style.css';
import { retornaProvaPorToken,
          iniciarProva,
          enviarRespostasDaProva,
          retornarTipoDeQuestao} from '../../services/index'
import { ProvaModal,
        RespondeQuestaoUnicaResposta,
        RespondeQuestaoMultiplasRespostas,
        BotaoPrincipal } from '../../component/index'

const objetoResposta = { idQuestao: '', tipo: '', resposta: '' }

export class ResolverProvaScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      token: this.props.match.params.token,
      modalIniciarProva: true,
      renderProva: false,
      modalFinalizarProva: false,
      count: 0,
      idProva: 74,
      prova: null,
      tiposDeQuestoes: [],
      resposta: null,
      statusProva: null,
      arrayRespostas: [objetoResposta]
    }
    this.lengthDissertativas = 0
    this.lengthTecnicas = 0
  }

  async componentDidMount() {
    localStorage.setItem('accessToken', this.state.token)
    let prova = await retornaProvaPorToken(this.state.token)
    this.setState({
      prova: prova,
      tiposDeQuestoes: await retornarTipoDeQuestao()
    }, () => {
      const quantidadeObjetos = (this.state.prova.questoesDeMultiplaEscolha.length +
                                  this.state.prova.questoesDissertativas.length +
                                  this.state.prova.questoesTecnicas.length)

      const newArray = [...new Array(quantidadeObjetos)]
      const arrayRespostas = newArray.map(() => ({ ...objetoResposta }))

      this.setState({
        count: this.state.prova.tempoDeDuracaoDaProva,
        arrayRespostas: arrayRespostas
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
      if(this.state.count <= 0){
        this.setState({
          iniciarProva: false,
          modalFinalizarProva: true,
          count: 0,
        })
        clearInterval(this.interval)
      }
    }, 60000 )
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
    })
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
    this.setState({
      iniciarProva: false,
      renderProva: false,
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
                    index={key+this.lengthMultiplasEscolhas+this.lengthDissertativas}
                    tipo={this.state.tiposDeQuestoes[2]}
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
                    index={key+this.lengthMultiplasEscolhas}
                    tipo={this.state.tiposDeQuestoes[0]}
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
                  tipo={this.state.tiposDeQuestoes[1]}
                  idQuestao={item.id}
                  alternativaA={item.alternativaA}
                  alternativaB={item.alternativaB}
                  alternativaC={item.alternativaC}
                  alternativaD={item.alternativaD}
                  alternativaE={item.alternativaE}
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
            <div className="content-titulo">
              <span className="titulo-crie">Boa prova {this.state.prova.nomeCandidato}</span>
              <div className="tempo"> {this.state.count} <span>Minutos</span></div>
            </div>
          </div>

          {this.renderQuestoesMultiplasEscolhas()}
          {this.renderQuestoesDissertativas()}
          {this.renderQuestoesTecnicas()}

          <div className="container-botao">
            <BotaoPrincipal nome="ENVIAR" onClick={this.handleClickEnviarProva} />
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
        nomeBotao="COMEÇAR"
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
