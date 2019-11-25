import React, { Component } from 'react'
import { BlocoQuestao, Textarea, Input } from '../../index'
import { retornaQuestaoTecnicaParaBaixar } from '../../../services/index'
import './corrigirUnicaResposta.style.css'

export class CorrigirUnicaResposta extends Component {
  constructor(props){
    super(props)
    this.state = {
      questaoDownload: ''
    }
  }

  async componentDidMount(){
    if(this.props.tipo === 'TECNICA'){
      this.setState({
        questaoDownload: await retornaQuestaoTecnicaParaBaixar(this.props.idResposta)
      })
    }
  }
  
  downloadRespostaFile = () => {
    const element = document.createElement("a");
    const file = new Blob([this.props.resposta], {type: 'text/plain'});
    element.href = URL.createObjectURL(file);
    element.download = `resposta${this.props.idResposta}.txt`;
    document.body.appendChild(element);
    element.click();
  }

  downloadTestesFile = () => {
    const element = document.createElement("a");
    const file = new Blob([this.state.questaoDownload.testeBase], {type: 'text/plain'});
    element.href = URL.createObjectURL(file);
    element.download = `teste${this.props.idResposta}.txt`;
    document.body.appendChild(element);
    element.click();
  }

  downloadRespostaBaseFile = () => {
    const element = document.createElement("a");
    const file = new Blob([this.state.questaoDownload.respostaBase], {type: 'text/plain'});
    element.href = URL.createObjectURL(file);
    element.download = `respostaBase${this.props.idResposta}.txt`;
    document.body.appendChild(element);
    element.click();
  }

  render() {
    return(
      <div className="container-questoes-corrigir">
        <BlocoQuestao
          questaoNome="Questão"
          questao={this.props.questao}/>

        <BlocoQuestao
          questaoNome="Resposta"
          questao={this.props.resposta}/>

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
              maxLength="500"/>
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
              onChange={this.props.handleChange}/>
            {
              this.props.tipo === 'TECNICA' &&
              <div className="container-download">
              <button className="botao-download" onClick={this.downloadRespostaFile}>Resposta</button>
              <button className="botao-download" onClick={this.downloadTestesFile}>Testes</button>
              <button className="botao-download resposta-base" onClick={this.downloadRespostaBaseFile}>Resposta Base</button>
              </div>
            }
          </div>
        </div>
      </div>
    )
  }
}
