import React, { Component } from 'react';
import { BlocoQuestao } from '../../index'

export class RespondeQuestaoUnicaResposta extends Component {
  render() {
    return (
      <>
        <BlocoQuestao/>
        <Input
          name="alternativaA"
          value={this.state.alternativaA}
          onChange={this.handleChange}
          maxTam="300"
          type="text"
          label="Alternativa A"
          placeholder=""/>
      </>
    )
  }
}