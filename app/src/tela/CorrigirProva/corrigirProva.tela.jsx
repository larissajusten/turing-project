import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import { retornarTipoDeQuestao, retornarProvaParaCorrigir, corrigirProva} from '../../services/index'
import { CorrigirUnicaResposta, BotaoPrincipal, Notificacao } from '../../component/index'
import './corrigirProva.style.css'

const objetoCorrecaoProva =  { idQuestao: '', idResposta: '', tipoDeQuestao: '', nota: '', comentario: '' }
export class CorrigirProvaScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      idProva: localStorage.getItem('idProvaParaCorrigir'),
      prova: null,
      tiposDeQuestoes: [],
      arrayCorrecoes: [objetoCorrecaoProva],
      deveRedirecionarParaDashboard: false
    }
    this.lengthDissertativas = 0
    this.lengthTecnicas = 0
  }

  componentDidMount = async () => {
    this.setState({
      tiposDeQuestoes: await retornarTipoDeQuestao(),
      prova: await retornarProvaParaCorrigir(this.state.idProva)
    }, () => {
      const quantidadeDeObjetos = (this.state.prova.questoesDissertativas.length + this.state.prova.questoesTecnicas.length)

      const newArray = [...new Array(quantidadeDeObjetos)]
      const arrayCorrecoes = newArray.map(() => ({ ...objetoCorrecaoProva }))

      this.setState({
        arrayCorrecoes
      })

      this.lengthDissertativas = this.state.prova.questoesDissertativas.length
      this.lengthTecnicas = this.state.prova.questoesTecnicas.length
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

  handleClickEnviarCorrecao = async(event) => {
    event.preventDefault()
    try{
      await corrigirProva(this.state.idProva, this.state.arrayCorrecoes)
      Notificacao('Sucesso', 'Prova salva', 'success')
      this.setState({ deveRedirecionarParaDashboard: true })
    }
    catch (error) {
      if (error.response.data.errors) {
        error.response.data.errors.map(message => {
          return Notificacao('Falha', `${message.defaultMessage}`, 'danger')
        })
      } else {
        Notificacao('Falha', `${error.response.data.message}`, 'danger')
      }
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

  renderProva() {
    return(
      <>
      {
        this.state.prova && this.state.arrayCorrecoes.length > 1 &&
          <>
          <div className="container-titulo">
            <span className="titulo-crie">Correção da prova de {this.state.prova.nomeCandidato}</span>
          </div>

          {this.renderQuestoesDissertativas()}
          {this.renderQuestoesTecnicas()}

          <div className="container-botao">
            <BotaoPrincipal nome="ENVIAR" onClick={this.handleClickEnviarCorrecao} />
          </div>
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

