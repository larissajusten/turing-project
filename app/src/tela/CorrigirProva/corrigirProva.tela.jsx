import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import { DominioService, BuscarProvaService, ProvaService } from '../../services/'
import { CorrigirUnicaResposta, BotaoPrincipal, Notificacao } from '../../component/'

const objetoCorrecaoProva =  { idQuestao: '', idResposta: '', tipoDeQuestao: '', nota: '', comentario: '' }
export class CorrigirProvaScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      idProva: this.props.match.params.idProva,
      prova: null,
      tiposDeQuestoes: [],
      arrayCorrecoes: [objetoCorrecaoProva],
      deveRedirecionarParaDashboard: false
    }
    this.lengthDissertativas = 0
    this.lengthTecnicas = 0
    this.dominioService = new DominioService()
    this.provaService = new ProvaService()
    this.buscarProvaService = new BuscarProvaService()
  }

  async componentDidMount() {
    let tiposDeQuestoes = await this.dominioService.retornarTipoDeQuestao()
    let prova = await this.buscarProvaService.retornarProvaParaCorrigir(this.state.idProva)

    this.lengthDissertativas = prova.questoesDissertativas.length
    this.lengthTecnicas = prova.questoesTecnicas.length

    const quantidadeDeObjetos = (this.lengthDissertativas + this.lengthTecnicas)

    const newArray = Array.from({length:(quantidadeDeObjetos)}, () => ({ }))
    const arrayCorrecoes = newArray.map(() => ({ ...objetoCorrecaoProva }))

    this.setState({
      arrayCorrecoes,
      tiposDeQuestoes,
      prova
    })
  }

  handleClickResponderQuestoesUnicaResposta = (event, index, idQuestao, idResposta, tipo) => {
    const { name, value } = event.target

    const array = this.state.arrayCorrecoes

    array[index][name] = value;
    array[index].idQuestao = idQuestao;
    array[index].tipoDeQuestao = tipo;
    array[index].idResposta = idResposta;

    this.setState({
      arrayCorrecoes: array
    })
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

  handleClickEnviarCorrecao = async(event) => {
    event.preventDefault()
    try{
      await this.provaService.corrigirProva(this.state.idProva, this.state.arrayCorrecoes)
      Notificacao('Sucesso', 'Prova salva', 'success')
      this.setState({ deveRedirecionarParaDashboard: true })
    }
    catch (error) {
      this.catchErrorENotifica(error)
    }
  }

  renderQuestoesTecnicas() {
    return (
      <>
      {
        this.state.prova.questoesTecnicas &&
        this.state.prova.questoesTecnicas.map((item, key) => {
          return <CorrigirUnicaResposta
                    key={key}
                    index={key+this.lengthDissertativas}
                    idQuestao={item.idQuestao}
                    idResposta={item.idResposta}
                    tipo={this.state.tiposDeQuestoes[2]}
                    questao={item.questao}
                    resposta={item.resposta}
                    comentario={this.state.arrayCorrecoes[key+this.lengthDissertativas].comentario}
                    nota={this.state.arrayCorrecoes[key+this.lengthDissertativas].nota}
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
          return <CorrigirUnicaResposta
                  key={key}
                  index={key}
                  idQuestao={item.idQuestao}
                  idResposta={item.idResposta}
                  tipo={this.state.tiposDeQuestoes[0]}
                  questao={item.questao}
                  resposta={item.resposta}
                  comentario={this.state.arrayCorrecoes[key].comentario}
                  nota={this.state.arrayCorrecoes[key].nota}
                  handleChange={this.handleClickResponderQuestoesUnicaResposta}/>
        })
      }
      </>
    )
  }

  renderQuestoes(){
    return(
      <>
      {
        this.state.arrayCorrecoes.length >= 1 ?
        <>
        {this.renderQuestoesDissertativas()}
        {this.renderQuestoesTecnicas()}

        <div className="container-botao">
          <BotaoPrincipal nome="ENVIAR" onClick={this.handleClickEnviarCorrecao} />
        </div>
        </>
        :
        <span className="titulo-crie">Não há questões nessa prova</span>
      }
      </>
    )
  }

  renderProva() {
    return(
      <>
      {
        this.state.prova &&
          <>
          <div className="container-titulo">
            <span className="titulo-crie">Correção da prova de {this.state.prova.nomeCandidato}</span>
          </div>
          {this.renderQuestoes()}
          </>
      }
      </>
    )
  }

  render() {
    if(this.state.deveRedirecionarParaDashboard){
      return <Redirect to="/"/>
    }
    return (
      <div className="container-tela">
        {this.renderProva()}
      </div>
    )
  }
}

