import React, { Component } from 'react';
import './buscarQuestao.style.css'
import { Select } from '../index'

export class BuscarQuestao extends Component {

  render() {
    return(
      <>
        <div className="input-principal width-select-container">
          <label className="label">Tipo</label>
          <Select
            name="tipo"
            value={this.props.tipo}
            index={this.props.index}
            selectCadastro={this.props.cadastro ? true : false}
            onChange={this.props.handleChange}
            object={this.props.tipos}
            placeholder="Selecione o tipo"
            questoesWidth="width-tipo-select"/>
      </div>

      <div className="input-principal width-select-container especificidade">
        <label className="label">Especificidade</label>
        <Select
          name="especificidade"
          value={this.props.especificidade}
          index={this.props.index}
          selectCadastro={this.props.cadastro ? true : false}
          onChange={this.props.handleChange}
          object={this.props.especificidades}
          placeholder="Selecione a especificidade"
          questoesWidth="width-especificidade-select"/>
      </div>

      <div className="input-principal width-select-container">
        <label className="label">Nivel</label>
        <Select
          name="nivel"
          value={this.props.nivel}
          index={this.props.index}
          selectCadastro={this.props.cadastro ? true : false}
          onChange={this.props.handleChange}
          object={this.props.niveis}
          placeholder="Selecione o nível"
          questoesWidth="width-nivel-select"/>
      </div>
    </>
    )
  }
}

