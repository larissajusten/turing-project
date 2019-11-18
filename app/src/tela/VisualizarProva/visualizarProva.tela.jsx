import React, { Component } from 'react';
import './visualizarProva.style.css'
import { MostrarQuestaoUnica, MostrarMultiplasRespostas } from '../../component/index'
import { retornaProva,
          removerQuestaoDissertativa,
          removerQuestaoTecnica,
          removerQuestaoMultiplaEscolha } from '../../services/index'

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

  removerQuestaoDissertativa = async (idDaQuestao) => {
    await removerQuestaoDissertativa(this.state.idProva, idDaQuestao)
    this.setState({
      prova: await retornaProva(this.state.idProva)
    })
  }

  removerQuestaoTecnica = async (idDaQuestao) => {
    await removerQuestaoTecnica(this.state.idProva, idDaQuestao)
    this.setState({
      prova: await retornaProva(this.state.idProva)
    })
  }

  removerQuestaoMultiplaEscolha = async (idDaQuestao) => {
    await removerQuestaoMultiplaEscolha(this.state.idProva, idDaQuestao)
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
    return (
      this.state.prova.questoesDeMultiplaEscolha.map((item, key) => {
        return <MostrarMultiplasRespostas
          key={key}
          id={item.id}
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
  }

  renderQuestoesTecnicas() {
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
  }

  renderQuestoesDissertativas() {
    console.log(this.state.prova.questoesDissertativas)
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
  }

  render() {
    console.log(this.state.prova)
    if (this.state.prova
      && this.state.prova.questoesDissertativas.length
      && this.state.prova.questoesDeMultiplaEscolha.length
      && this.state.prova.questoesTecnicas.length){
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
    } else if (this.state.prova
              && !this.state.prova.questoesDissertativas.length
              && !this.state.prova.questoesDeMultiplaEscolha.length
              && !this.state.prova.questoesTecnicas.length){
        return (
          <div className="container-tela">
            <div className="container-titulo">
              <span className="titulo-crie">Não há questões para visualizar</span>
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
