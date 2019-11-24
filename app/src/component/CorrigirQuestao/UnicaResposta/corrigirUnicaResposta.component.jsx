import React, { Component } from 'react'
import { BlocoQuestao, Textarea, Input } from '../../index'
import './corrigirUnicaResposta.style.css'

export class CorrigirUnicaResposta extends Component {
  render() {
    return(
      <div className="container-questoes-resposta">
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
        </div>
      </div>
    )
  }
}
