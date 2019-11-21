import React, { Component } from 'react';
import { BlocoQuestao, Textarea } from '../../index'
import './responderUnicaResposta.style.css'

export class RespondeQuestaoUnicaResposta extends Component {
  render() {
    return (
      <div className="container-questoes-resposta">
        <BlocoQuestao
          questaoNome="Questão"
          questao={this.props.questao}/>

        <div className="container-pergunta">
          <Textarea
            label="Resposta"
            name="resposta"
            value={this.props.resposta}
            handleChange={this.props.handleChange}
            comIndex={true}
            index={this.props.index}
            tipo={this.props.tipo}
            idQuestao={this.props.idQuestao}/>
        </div>
      </div>
    )
  }
}
