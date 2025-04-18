import React, { Component } from 'react'
import './resolverProva.style.css'
import {
  BuscarProvaService,
  ProvaService,
  DominioService,
  ProvaCrescerService
} from '../../services/'
import {
  ProvaModal,
  RespondeQuestaoUnicaResposta,
  RespondeQuestaoMultiplasRespostas,
  BotaoPrincipal,
  Notificacao,
  Select
} from '../../component/'

const objetoResposta = { tipoDeQuestao: '', idQuestao: '', resposta: '' }

/* Verificar visibilidade da aba */
let hidden = null
let visibilityChange = null
if (typeof document.hidden !== 'undefined') {
  hidden = 'hidden'
  visibilityChange = 'visibilitychange'
}

export class ResolverProvaScreen extends Component {
  constructor(props) {
    super(props)
    this.state = {
      token: this.props.match.params.token,
      modalIniciarProva: true,
      renderProva: false,
      modalFinalizarProva: false,
      count: 0,
      idProva: 0,
      prova: null,
      tiposDeQuestoes: [],
      especificidades: [],
      resposta: null,
      statusProva: null,
      arrayRespostas: [objetoResposta],
      actions: [],
      tipo: false
    }
    this.lengthDissertativas = 0
    this.lengthTecnicas = 0
    this.dominioService = new DominioService()
    this.provaService = new ProvaService()
    this.buscarProvaService = new BuscarProvaService()
    this.provaCrescerService = new ProvaCrescerService()
  }

  async componentDidMount() {
    try {
      let prova = await this.buscarProvaService.retornaProvaPorToken(
        this.state.token
      )
      let tiposDeQuestoes = await this.dominioService.retornarTipoDeQuestao()
      let especificidades = await this.dominioService.retornarEspecificidades()
      document.addEventListener(
        visibilityChange,
        this.handleVisibilityChange,
        false
      )
      this.setState(
        {
          idProva: prova.id,
          prova,
          tiposDeQuestoes,
          especificidades,
          tipo: prova.tipo
        },
        () => {
          const quantidadeObjetos =
            this.state.prova.questoesDeMultiplaEscolha.length +
            this.state.prova.questoesDissertativas.length +
            this.state.prova.questoesTecnicas.length

          const newArray = Array.from({ length: quantidadeObjetos }, () => ({}))
          const arrayRespostas = newArray.map(() => ({ ...objetoResposta }))

          this.setState({
            count: this.state.prova.tempoDeDuracaoDaProva,
            arrayRespostas
          })

          this.lengthMultiplasEscolhas = this.state.prova.questoesDeMultiplaEscolha.length
          this.lengthDissertativas = this.state.prova.questoesDissertativas.length
          this.lengthTecnicas = this.state.prova.questoesTecnicas.length
        }
      )
    } catch (error) {
      if (error.response.data.errors) {
        error.response.data.errors.map(message => {
          return Notificacao('Falha', `${message.defaultMessage}`, 'warning')
        })
      } else {
        Notificacao('Falha', `${error.response.data.message}`, 'danger')
      }
      this.setState({
        modalIniciarProva: false,
        modalFinalizarProva: true,
        count: 0
      })
    }
  }

  handleChange = event => {
    const { name, value } = event.target
    this.setState({
      [name]: value
    })
  }

  componentWillMount() {
    document.removeEventListener(visibilityChange, this.handleVisibilityChange)
  }

  handleVisibilityChange = () => {
    if (document[hidden]) {
      this.setState({
        modalIniciarProva: false,
        modalFinalizarProva: true,
        count: 0
      })
    }
  }

  contador = async () => {
    this.interval = setInterval(async () => {
      this.setState({
        count: this.state.count - 1
      })
      if (this.state.count <= 0) {
        this.setState({
          modalIniciarProva: false,
          modalFinalizarProva: true,
          count: 0
        })
        clearInterval(this.interval)
      }
    }, 60000)
  }

  adicionaObjetoResposta = () => {
    this.setState({
      arrayRespostas: [...this.state.arrayRespostas, objetoResposta]
    })
  }

  handleClickResponderQuestoesUnicaResposta = (
    event,
    index,
    idQuestao,
    tipo
  ) => {
    const { name, value } = event.target
    const array = this.state.arrayRespostas
    array[index][name] = value
    array[index].idQuestao = idQuestao
    array[index].tipoDeQuestao = tipo
    this.setState({
      arrayRespostas: array
    })
  }

  handleClickResponderQuestoesMultiplasRespostas = (
    event,
    index,
    idQuestao,
    idAlternativa,
    tipo
  ) => {
    
    const array = [...this.state.arrayRespostas]
    array[index].resposta = idAlternativa
    array[index].idQuestao = idQuestao
    array[index].tipoDeQuestao = tipo
    this.setState({
      arrayRespostas: array
    })
  }

  handleClickIniciarProva = async (nome, email) => {
    this.setState({
      modalIniciarProva: false,
      renderProva: true
    })
    this.contador()
    if (this.state.tipo === 'CRESCER') {
      await this.provaCrescerService.iniciarProvaCrescer(
        this.state.idProva,
        nome,
        email
      )
    } else {
      await this.provaService.iniciarProva(this.state.idProva)
    }
  }

  handleClickEnviarProva = async () => {
    this.setState({
      modalIniciarProva: false,
      renderProva: false,
      modalFinalizarProva: true,
      statusProva: await this.provaService.enviarRespostasDaProva(
        this.state.idProva,
        this.state.arrayRespostas
      )
    })
  }

  handleClickEnviarProvaCrescer = async event => {
    
    this.setState({
      modalIniciarProva: false,
      renderProva: false,
      modalFinalizarProva: true,
      statusProva: await this.provaCrescerService.enviarRespostasDaProvaCrescer(
        this.state.idProva,
        this.state.linguagemEscolhida,
        JSON.stringify(this.state.arrayRespostas),
      )
    })
  }

  renderQuestoesTecnicas() {
    return (
      <>
        {this.state.prova.questoesTecnicas &&
          this.state.prova.questoesTecnicas.map((item, key) => {
            return (
              <RespondeQuestaoUnicaResposta
                key={key}
                index={
                  key + this.lengthMultiplasEscolhas + this.lengthDissertativas
                }
                tipo={this.state.tiposDeQuestoes[2]}
                idQuestao={item.id}
                questao={item.questao}
                resposta={
                  this.state.arrayRespostas[
                    key +
                      this.lengthMultiplasEscolhas +
                      this.lengthDissertativas
                  ].resposta
                }
                handleChange={this.handleClickResponderQuestoesUnicaResposta}
              />
            )
          })}
      </>
    )
  }

  renderQuestoesDissertativas() {
    return (
      <>
        {this.state.prova.questoesDissertativas &&
          this.state.prova.questoesDissertativas.map((item, key) => {
            return (
              <RespondeQuestaoUnicaResposta
                key={key}
                index={key + this.lengthMultiplasEscolhas}
                tipo={this.state.tiposDeQuestoes[0]}
                idQuestao={item.id}
                questao={item.questao}
                resposta={
                  this.state.arrayRespostas[key + this.lengthMultiplasEscolhas]
                    .resposta
                }
                handleChange={this.handleClickResponderQuestoesUnicaResposta}
              />
            )
          })}
      </>
    )
  }

  renderQuestoesMultiplasEscolhas() {
    return (
      <>
        {this.state.prova.questoesDeMultiplaEscolha &&
          this.state.prova.questoesDeMultiplaEscolha.map((item, key) => {
            return (
              <RespondeQuestaoMultiplasRespostas
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
                onClick={this.handleClickResponderQuestoesMultiplasRespostas}
              />
            )
          })}
      </>
    )
  }

  renderProva() {
    return (
      <>
        {this.state.prova && (
          <div className="container-tela">
            <div className="container-titulo">
              <div className="content-titulo">
                <div className="titulo-e-linguagem">
                  <span className="titulo-crie">
                    Boa prova {this.state.prova.nomeCandidato}
                  </span>
                  {this.state.tipo === 'CRESCER' && (
                    <div className="select-resolver-prova">
                      <span>
                        Selecione a especificidade/linguagem que deseje fazer a
                        prova
                      </span>
                      <Select
                        questoesWidth="width-resolver-prova"
                        placeholder="Selecione a linguagem"
                        name="linguagemEscolhida"
                        value={this.state.linguagemEscolhida}
                        onChange={this.handleChange}
                        object={this.state.especificidades}
                      />
                    </div>
                  )}
                </div>
                <div className="tempo">
                  {this.state.count} <span>Minutos</span>
                </div>
              </div>
            </div>

            {this.renderQuestoesMultiplasEscolhas()}
            {this.renderQuestoesDissertativas()}
            {this.renderQuestoesTecnicas()}

            <div className="container-botao">
              <BotaoPrincipal
                nome="ENVIAR"
                onClick={
                  this.state.tipo === 'CRESCER'
                    ? this.handleClickEnviarProvaCrescer
                    : this.handleClickEnviarProva
                }
              />
            </div>
          </div>
        )}
      </>
    )
  }

  renderModalIniciar() {
    return (
      <>
        <ProvaModal
          titulo="Clique em iniciar para realizar sua prova"
          nomeBotao="COMEÇAR"
          subtitulo={`Lembre-se, é proibido sair da aba da prova depois do seu inicio,
          caso saia, o usuario sera desclassificado automaticamente.
           Você possui ${this.state.prova && this.state.prova.tempoDeDuracaoDaProva} minutos para fazer a prova.`}
          comBotao={true}
          onClick={this.handleClickIniciarProva}
          tipoProva={this.state.tipo}
        />
      </>
    )
  }

  renderModalFinalizar() {
    return (
      <>
        {this.state.modalFinalizarProva && (
          <ProvaModal titulo="Sua prova terminou" />
        )}
      </>
    )
  }

  render() {
    return (
      <>
        {this.state.modalIniciarProva && this.renderModalIniciar()}
        {this.state.renderProva && !this.state.modalFinalizarProva
          ? this.renderProva()
          : ''}
        {this.state.modalFinalizarProva && this.renderModalFinalizar()}
      </>
    )
  }
}
