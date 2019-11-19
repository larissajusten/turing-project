import React, { Component } from 'react'
import './mostrarQuestaoUnica.style.css'
import { BotaoAdicionar, BlocoQuestao } from '../../index'

export class MostrarQuestaoUnica extends Component {

  render() {
    return (
      <div className="container-questao-unica">

        <BlocoQuestao
          questaoNome={this.props.questaoNome}
          questao={this.props.questao}/>

        <div>
          <div className="container-especificacao">
            <div className="especificacao">{this.props.nivel}</div>
            <label className="especificacao-nome">Nivel</label>
          </div>

          <div className="container-especificacao">
            <div className="especificacao">{this.props.especificidade}</div>
            <label className="especificacao-nome">Especificidade</label>
          </div>
        </div>

        <BotaoAdicionar className="botao-remover" nome="-" adicionar={false} onClick={this.props.onClick} id={this.props.id} />

      </div>
    )
  }
}
