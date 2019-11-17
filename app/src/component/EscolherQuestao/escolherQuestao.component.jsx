import React, { Component } from 'react';
import './escolherQuestao.style.css'
import { Select } from '../index'

export class EscolherQuestao extends Component {

  render() {
    return(
      <>
        <div className="input-principal width-tipo">
          <label className="label">Tipo</label>
          <Select
            name="tipo"
            value={this.props.tipo}
            id={this.props.id}
            selectCadastro={this.props.cadastro ? true : false}
            onChange={this.props.handleChange}
            object={this.props.tipos}
            placeholder="Selecione o tipo"
            questoesWidth="width-tipo"/>
      </div>

      <div className="input-principal width-especificidade">
        <label className="label">Especificidade</label>
        <Select
          name="especificidade"
          value={this.props.especificidade}
          id={this.props.id}
          selectCadastro={this.props.cadastro ? true : false}
          onChange={this.props.handleChange}
          object={this.props.especificidades}
          placeholder="Selecione a especificidade"
          questoesWidth="width-especificidade"/>
      </div>

      <div className="input-principal width-nivel">
        <label className="label">Nivel</label>
        <Select
          name="nivel"
          value={this.props.nivel}
          id={this.props.id}
          selectCadastro={this.props.cadastro ? true : false}
          onChange={this.props.handleChange}
          object={this.props.niveis}
          placeholder="Selecione o nível"
          questoesWidth="width-nivel"/>
      </div>
    </>
    )
  }
}

