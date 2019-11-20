import React, { Component } from 'react';
import { BlocoQuestao, Textarea} from '../../index'
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
            name="resposta"
            value={this.props.resposta}
            label="Resposta"
            maxLength="500"
            comId={true}
            id={this.props.id}
            handleChange={this.props.handleChange}/>
        </div>

      </div>
    )
  }
}