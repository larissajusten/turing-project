import React, { Component } from 'react'
import './resolverProva.style.css';
import { retornaProva, inserirDataDeInicioDaProva } from '../../services/index'
import { IniciarProvaModal, RespondeQuestaoUnicaResposta } from '../../component/index'

const objetoRespostaQuestao = { resposta: null, idQuestao: null }

export class ResolverProvaScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      modalIniciarProva: true,
      count: null,
      idProva: 60,
      prova: null,
      arrayRespostasDissertativas: [objetoRespostaQuestao],
      arrayRespostasTecnicas: []
    }
  }

  componentDidMount = async () => {
    this.setState({
      prova: await retornaProva(this.state.idProva)
    }, () => {
      this.setState({
        count: this.state.prova.duracao
      })
    })
  }

  handleChange = (event) => {
    const { name, value } = event.target
    this.setState({
      [name]: value
    })
  }

  handleChangeArrayDissertativas = (event, id) => {
    const { name, value } = event.target

    const array = [...this.state.arrayRespostasDissertativas]

    array[id][name] = value;
    array[id].idQuestao = id;

    this.setState({
      arrayRespostasDissertativas: array
    }, () => {
      this.setState({
        arrayRespostasDissertativas: [...this.state.arrayRespostasDissertativas, objetoRespostaQuestao]
      })
    })
  }

  handleChangeArrayTecnicas = (event, id) => {
    const { name, value } = event.target

    const array = [...this.state.arrayRespostasDissertativas]

    array[id][name] = value;
    array[id].idQuestao = id;

    this.setState({
      arrayRespostasDissertativas: array
    })
  }

  contador = () => {
    this.interval = setInterval(() => {
        this.setState({
            count: this.state.count - 1
        })
        if(this.state.count < 0){
          this.setState({ 
            modalFim: true,
            count: 0,
            terminoPorTempo: true
          })
          clearInterval(this.interval)
        }
    }, 1000 )
  }

  handleClickIniciarProva = async(event) => {
    event.preventDefault()
    this.setState({
      modalIniciarProva: false
    })
    this.contador()
    await inserirDataDeInicioDaProva(this.state.idProva)
  }

  renderQuestoesDissertativas() {
    if(this.state.prova.questoesDissertativas){
      return (
        this.state.prova.questoesDissertativas.map((item, key) => {
          return <RespondeQuestaoUnicaResposta
                  key={key}
                  id={key}
                  questao={item.questao}
                  resposta={this.state.resposta}
                  handleChange={this.handleChangeArrayDissertativas}
                  />
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
          return <RespondeQuestaoUnicaResposta
            key={key}
            id={item.id}
            questao={item.questao}
            resposta={this.state.resposta}
            handleChange={this.handleChange}
            />
        })
      )
    }else{
      return null
    }
  }

  renderProva() {
    return(
      <div className="container-tela">
        <div className="container-titulo">
          <span className="titulo-crie">Boa prova</span>
        </div>

        {this.renderQuestoesDissertativas()}
        {this.renderQuestoesTecnicas()}
        {this.renderMultiplasEscolhas()}
      </div>
    )
  }
  
  render() {
    return(
      <>
      { this.state.modalIniciarProva ? <IniciarProvaModal onClick={this.handleClickIniciarProva}/> : this.renderProva() }
      </>
    )
  }
}