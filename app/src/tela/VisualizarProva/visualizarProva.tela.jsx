import React, { Component } from 'react';
import './visualizarProva.style.css'
import { MostrarQuestaoUnica, MostrarMultiplasRespostas } from '../../component/index'
import { retornaProva } from '../../services/index'

export class VisualizarProvaScreen extends Component {

  constructor(props) {
    super(props)
    this.state = {
      idProva: localStorage.getItem('idProva'),
      prova: null,
      semProvaParaMostrar: true
    }
  }

  async componentDidMount() {
    this.setState({
      prova: await retornaProva(this.state.idProva)
    })
  }

  renderMultiplasEscolhas() {
    return (
      this.state.prova.questoesDeMultiplaEscolha.map((item, key) => {
        return <MostrarMultiplasRespostas
          key={key}
          id={key}
          questao={item.questao}
          nivel={item.nivelDeDificuldade}
          especificidade={item.especificidade}
          alternativaA={item.alternativaA.resposta}
          alternativaB={item.alternativaB.resposta}
          alternativaC={item.alternativaC.resposta}
          alternativaD={item.alternativaD.resposta}
          alternativaE={item.alternativaE.resposta}
          respostaCorreta=
          {item.alternativaA.respostaCorreta ? "Alternativa A" :
            (item.alternativaB.respostaCorreta ? "Alternativa B" :
              (item.alternativaC.respostaCorreta ? "Alternativa C" :
                (item.alternativaD.respostaCorreta ? "Alternativa D" : "Alternativa E")
              )
            )
          }
          onClick={this.removerQuestaoMultiplaEscolha} />
      })
    )
  }

  renderQuestoesTecnicas() {
    return (
      this.state.prova.questoesTecnicas.map((item, key) => {
        return <MostrarQuestaoUnica
          key={key}
          id={key}
          questaoNome="Questão técnica"
          questao={item.questao}
          nivel={item.nivelDeDificuldade}
          especificidade={item.especificidade}
          onClick={this.removerQuestaoTecnica} />
      })
    )
  }

  renderQuestoesDissertativas() {
    return (
      this.state.prova.questoesDissertativas.map((item, key) => {
        return <MostrarQuestaoUnica
          key={key}
          id={key}
          questaoNome="Questão dissertativa"
          questao={item.questao}
          nivel={item.nivelDeDificuldade}
          especificidade={item.especificidade}
          onClick={this.removerQuestaoDissertativa} />
      })
    )
  }

  render() {
    if (this.state.prova) {
      return (
        <div className="container-tela">
          <div className="container-titulo">
            <span className="titulo-crie">Essa é a prova que você criou</span>
          </div>

          {this.renderQuestoesDissertativas()}
          {this.renderQuestoesTecnicas()}
          {this.renderMultiplasEscolhas()}
        </div>
      )
    } else {
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
