import React, { Component } from 'react'
import { retornarProvaComRespostas, corrigirProva } from '../../services/prova/prova.service'
import { retornarTipoDeQuestao } from '../../services/index'
import { RespondeQuestaoUnicaResposta, BotaoPrincipal, BlocoQuestao, Textarea, Input } from '../../component/index'
import './corrigirProva.style.css'

const objetoCorrecaoProva = {}
const correcao =  { idQuestao: null, idResposta: null, nota: 0, comentario: '' }

export class CorrigirProvaScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      idProva: 73, //localStorage.getItem('idProva'),
      prova: null,
      tiposDeQuestoes: [],
      arrayRespostas: [objetoCorrecaoProva], 
      listaDeCorrecoes: [correcao]
    }
  }

  componentDidMount = async () => {
    this.setState({
      prova: await retornarProvaComRespostas(this.state.idProva),
      tiposDeQuestoes: await retornarTipoDeQuestao()
    }, () => {
      const quantidadeObjetos = (
                                  this.state.prova.questoesDissertativas.length +
                                  this.state.prova.questoesTecnicas.length)

      const newArray = [...new Array(quantidadeObjetos)]
      const arrayRespostas = newArray.map(() => ({ ...objetoCorrecaoProva }))

      this.setState({
        arrayRespostas
      })

      this.lengthDissertativas = this.state.prova.questoesDissertativas.length
      this.lengthTecnicas = this.state.prova.questoesTecnicas.length
    })
      
  }

  handleChange = (event) => {
    const { name, value } = event.target
    this.setState({
        [name]: value
    })
	}

  renderQuestoesTecnicas() {
    return (
      <>
      {
        this.state.prova.questoesTecnicas &&
        this.state.prova.questoesTecnicas.map((item, key) => {
          return (
          <>
          <h3>Questão</h3>
          <BlocoQuestao
                    index={key}
                    tipo={this.state.tiposDeQuestoes}
                    idQuestao={item.id}
                    questao={item.questao}
          />
          <h3>Resposta</h3> 
            <BlocoQuestao
                    index={key}
                    tipo={this.state.tiposDeQuestoes}
                    idQuestao={item.id}
                    questao={item.resposta}
            />
          </>
          )
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
          return(
            <>
            <h3>Questão</h3> 
            <BlocoQuestao
                    key={key}
                    index={key}
                    tipo={this.state.tiposDeQuestoes}
                    idQuestao={item.id}
                    questao={item.questao}
                    />
          <h3>Resposta</h3> 
            <BlocoQuestao
                    key={key}
                    index={key}
                    tipo={this.state.tiposDeQuestoes}
                    idQuestao={item.id}
                    questao={item.resposta}
            />
          
          <div className="comentario-nota">
            <Input 
            label="Nota"
            step=".01"
            //value={this.state.listaDeCorrecoes[key].nota}
            />
          <Textarea
							label="Comentário"
							name="comentario"
							//value={this.state.listaDeCorrecoes[key].comentario}
							handleChange={this.handleChange}
							maxLength="500"/>
          </div>  
        </>
        )
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
            <span className="titulo-crie">Correção da prova de {this.state.prova.nomeCandidato}</span>
          </div>

          {this.renderQuestoesDissertativas()}
          {this.renderQuestoesTecnicas()}

          <div className="container-botao">
            <BotaoPrincipal nome="Enviar" onClick={this.handleClickEnviarCorrecao} />
          </div>
        </div>
      }
      </>
    )
  }
  
  handleClickEnviarCorrecao = async(event) => {
    event.preventDefault()
    console.log(this.state.arrayRespostas)
    this.setState({
      statusProva: await corrigirProva(this.state.idProva, this.state.arrayRespostas)
    })
  }
  
  render() { 
    return (
      <div className="container-tela">
        {this.renderProva()}
      </div>
    )
    }


  }

