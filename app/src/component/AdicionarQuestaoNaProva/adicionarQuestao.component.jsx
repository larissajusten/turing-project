import React, { Component } from 'react';
import { Input, BotaoAdicionar, BuscarQuestao } from '../'
import { DominioService } from '../../services/'

export class AdicionarQuestaoNaProva extends Component {

  constructor(props) {
    super(props)
    this.state = {
      tipos: [],
      especificidades: [],
      niveis: []
    }
    this.dominioService = new DominioService()
  }

  async componentDidMount() {
    this.setState({
      tipos: await this.dominioService.retornarTipoDeQuestao(),
      especificidades: await this.dominioService.retornarEspecificidades(),
      niveis: await this.dominioService.retornarNiveisDeDificuldade()
    })
  }

  render() {
    return (
      <div className="container-inputs-prova">
        <BuscarQuestao
          tipo={this.props.tipo}
          especificidade={this.props.especificidade}
          nivel={this.props.nivel}
          tipos={this.state.tipos}
          especificidades={this.state.especificidades}
          niveis={this.state.niveis}
          index={this.props.index}
          cadastro={true}
          handleChange={this.props.handleChange} />

        <Input
          name="quantidade"
          index={this.props.index}
          cadastro={true}
          onChange={this.props.handleChange}
          className="input-quantidade"
          maxNum="30"
          type="number"
          label="Quantidade de questões"
          placeholder="" />

        <div className="container-botao-adicionar">
          <BotaoAdicionar className="botao-adicionar" id={this.props.index} nome="+" onClick={this.props.onClick} />
        </div>

      </div>
    )
  }
}
