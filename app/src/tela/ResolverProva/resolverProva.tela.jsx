import React, { Component } from 'react'
import './resolverProva.style.css';
import { retornaProva, inserirDataDeInicioDaProva } from '../../services/index'
import { ProvaModal,
        RespondeQuestaoUnicaResposta,
        RespondeQuestaoMultiplasRespostas } from '../../component/index'

const objetoRespostaQuestao = { resposta: null, idQuestao: null }

export class ResolverProvaScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      modalIniciarProva: true,
      modalFinalizarProva: false,
      count: 0,
      idProva: localStorage.getItem('idProva'),
      prova: null,
      arrayRespostas: [objetoRespostaQuestao]
    }
  }

  componentDidMount = async () => {
    this.setState({
      prova: await retornaProva(this.state.idProva)
    }, () => {
      this.setState({
        count: 5000000//this.state.prova.duracao
      })
    })
  }

  handleChangeArrayRespostas = (event, index, idQuestao) => {
    const { name, value } = event.target

    const array = [...this.state.arrayRespostas]

    array[index][name] = value;
    array[index].idQuestao = idQuestao;

    this.setState({
      arrayRespostas: array
    }, () => {
      this.setState({
        arrayRespostas: [...this.state.arrayRespostas, objetoRespostaQuestao]
      })
    })
  }

  handleClickAdicionarAlternativa = (event, index, idQuestao, idAlternativa) => {
    event.preventDefault()
    const array = [...this.state.arrayRespostas]

    array[index].resposta = idAlternativa;
    array[index].idQuestao = idQuestao;

    this.setState({
      arrayRespostas: array
    }, () => {
      this.setState({
        arrayRespostas: [...this.state.arrayRespostas, objetoRespostaQuestao]
      })
    })
  }

  handleClickIniciarProva = async(event) => {
    event.preventDefault()
    this.setState({
      modalIniciarProva: false
    })
    this.contador()
    await inserirDataDeInicioDaProva(this.state.idProva)
  }

  handleClickFinalizarProva = () => {
    return null
  }

  contador = async () => {
    this.interval = setInterval(() => {
        this.setState({
            count: this.state.count - 1
        })
        if(this.state.count < 0){
          this.setState({
            modalFinalizarProva: true,
            count: 0
          })
          clearInterval(this.interval)
          //await enviarRespostasDaProva(this.state.idProva, this.state.arrayRespostas)
        }
    }, 1000 )
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
                  idQuestao={item.id}
                  questao={item.questao}
                  resposta={this.state.resposta}
                  handleChange={this.handleChangeArrayRespostas}
                  />
        })
      }
      </>
    )
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
                  idQuestao={item.id}
                  questao={item.questao}
                  resposta={this.state.resposta}
                  handleChange={this.handleChangeArrayRespostas}
                  />
        })
      }
      </>
    )
  }

  renderMultiplasEscolhas() {
    return (
      <>
      {
        this.state.prova.questoesDeMultiplaEscolha &&
        this.state.prova.questoesDeMultiplaEscolha.map((item, key) => {
          return <RespondeQuestaoMultiplasRespostas
                  key={key}
                  index={key}
                  idQuestao={item.id}
                  questao={item.questao}
                  onClick={this.handleClickAdicionarAlternativa}/>
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

          {this.renderQuestoesDissertativas()}
          {this.renderQuestoesTecnicas()}
          {this.renderMultiplasEscolhas()}
        </div>
      }
      </>
    )
  }

  renderModalIniciar(){
    return(
      <>
      {
        this.state.modalIniciarProva &&
        <ProvaModal
          titulo="Clique em iniciar para realizar sua prova"
          nomeBotao="Começar"
          onClick={this.handleClickIniciarProva}/> 
      }
      </>
    )
  }

  renderModalFinalizar(){
    return(
      <>
      {
        this.state.modalFinalizarProva &&
        <ProvaModal
          titulo="Sua prova terminou"
          nomeBotao="Finalizar"
          onClick={this.handleClickFinalizarProva}/>
      }
      </>
    )
  }

  render() {
    return(
      <>
      {this.renderModalIniciar()}
      {this.renderProva()}
      {this.renderModalFinalizar()}
      </>
    )
  }
}
