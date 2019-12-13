import React, { Component } from 'react'
import { saveAs } from 'file-saver'
import { Textarea, Input, BlocoResposta } from '../../'
import { retornaQuestaoTecnicaParaBaixar } from '../../../services/'
import './corrigirUnicaResposta.style.css'

export class CorrigirUnicaResposta extends Component {
  constructor(props) {
    super(props)
    this.state = {
      questaoDownload: ''
    }
    this.typeFile = 'text/plain;charset=utf-8'
  }

  async componentDidMount() {
    if (this.props.tipo === 'TECNICA') {
      this.setState({
        questaoDownload: await retornaQuestaoTecnicaParaBaixar(
          this.props.idResposta
        )
      })
    }
  }

  downloadRespostaFile = () => {
    const file = new Blob([this.props.resposta], { type: this.typeFile })
    saveAs(file, `resposta${this.props.idResposta}.txt`)
  }

  downloadTestesFile = () => {
    const file = new Blob([this.state.questaoDownload.testeBase], {
      type: this.type
    })
    saveAs(file, `teste${this.props.idResposta}.txt`)
  }

  downloadRespostaBaseFile = () => {
    const file = new Blob([this.state.questaoDownload.respostaBase], {
      type: this.type
    })
    saveAs(file, `respostaBase${this.props.idResposta}.txt`)
  }

  render() {
    return (
      <div className="container-questoes-corrigir">
        <BlocoResposta
          questaoNome={`Questão ${this.props.index + 1}`}
          tipo={this.props.tipo}
          questao={this.props.questao}
        />

        <BlocoResposta questaoNome="Resposta" questao={this.props.resposta} />

        <div className="comentario-nota">
          <div className="comentario">
            <Textarea
              classe="width-comentario"
              label="Comentário"
              name="comentario"
              comIdResposta={true}
              index={this.props.index}
              idResposta={this.props.idResposta}
              idQuestao={this.props.idQuestao}
              tipo={this.props.tipo}
              value={this.props.comentario}
              handleChange={this.props.handleChange}
              maxLength="500"
            />
          </div>
          <div className="container-nota-download">
            <Input
              classNameDiv="width-nota"
              label="Nota"
              name="nota"
              type="number"
              maxNum="10"
              comIdResposta={true}
              index={this.props.index}
              idResposta={this.props.idResposta}
              idQuestao={this.props.idQuestao}
              tipo={this.props.tipo}
              value={this.props.nota}
              onChange={this.props.handleChange}
            />
          </div>
        </div>
        {this.props.tipo === 'TECNICA' && (
          <div className="container-download">
            <button
              className="botao-download"
              onClick={this.downloadRespostaFile}
            >
              {' '}
              Resposta<i class="fa fa-download"></i>
            </button>
            <button
              className="botao-download"
              onClick={this.downloadTestesFile}
            >
              Testes<i class="fa fa-download"></i>
            </button>
            <button
              className="botao-download resposta-base"
              onClick={this.downloadRespostaBaseFile}
            >
              Resposta Base<i class="fa fa-download"></i>
            </button>
          </div>
        )}
      </div>
    )
  }
}
