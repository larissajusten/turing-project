import React, { Component } from 'react';
import { Input, BotaoAdicionar, EscolherQuestao } from '../index'
import { incluirDissertativas, incluirMultiplaEscolha, incluirTecnicas } from '../../services/index'

export class AdicionarQuestao extends Component {

  constructor(props){
    super(props)
    this.state = {
      tipos: props.tipos,
      especificidades: props.especificidades,
      niveis: props.niveis,
      tipo: '',
      especificidade: '',
      nivel: '',
      quantidade: ''
    }
  }

  handleClickEnviarQuestao = async(event) => {
    event.preventDefault()

    const questao = {
        "especificidade": this.state.especificidade,
        "nivelDeDificuldade": this.state.nivel,
        "quantidade": this.state.quantidade
    }

    if(this.state.tipo === this.state.tipos[0]){
      await incluirDissertativas(this.props.idProva, questao)
    }else if(this.state.tipo === this.state.tipos[1]){
      await incluirMultiplaEscolha(this.props.idProva, questao)
    }else if(this.state.tipo === this.state.tipos[2]){
      await incluirTecnicas(this.props.idProva, questao)
    }

    this.setState({
      tipo: '',
      especificidade: '',
      nivel: '',
      quantidade: ''
    })
  }

  render() {
    return(
      <div className="container-inputs-prova">
      <EscolherQuestao 
          tipo = {this.state.tipo}
          especificidade = {this.state.especificidade}
          nivel = {this.state.nivel}
          tipos = {this.state.tipos}
          especificidades = {this.state.especificidades}
          niveis = {this.state.niveis}
          handleChange = {this.handleChange}/>
          
      <Input
          name="quantidade"
          value={this.state.quantidade}
          onChange={this.handleChange}
          className="input-quantidade"
          type="number"
          label="Quantidade de questões"
          placeholder=""/>

      <BotaoAdicionar nome="+" onClick={this.handleClickEnviarQuestao}/>
      </div>
    )
  }
}