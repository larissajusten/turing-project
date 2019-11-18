import React, { Component } from 'react';
import { Input, BotaoAdicionar, EscolherQuestao } from '../index'
import {retornarEspecificidades,
        retornarNiveisDeDificuldade} from '../../services/index'

export class AdicionarQuestao extends Component {

  constructor(props) {
    super(props)
    this.state = {
      tipos: ['Dissertativa', 'Múltipla Escolha', 'Técnica'],
      especificidades: [],
      niveis: []
    }
  }

  async componentDidMount() {
    this.setState({
      especificidades: await retornarEspecificidades(),
      niveis: await retornarNiveisDeDificuldade()
    })
  }

  render() {
    return (
      <div className="container-inputs-prova">
        <EscolherQuestao
          tipo={this.props.tipo}
          especificidade={this.props.especificidade}
          nivel={this.props.nivel}
          tipos={this.state.tipos}
          especificidades={this.state.especificidades}
          niveis={this.state.niveis}
          id={this.props.id}
          cadastro={true}
          handleChange={this.props.handleChange} />

        <Input
          name="quantidade"
          id={this.props.id}
          cadastro={true}
          onChange={this.props.handleChange}
          className="input-quantidade"
          maxNum="30"
          type="number"
          label="Quantidade de questões"
          placeholder="" />

        <div className="container-botao-adicionar">
          <BotaoAdicionar className="botao-adicionar" id={this.props.id} nome="+" onClick={this.props.onClick} />
        </div>

      </div>
    )
  }
}
