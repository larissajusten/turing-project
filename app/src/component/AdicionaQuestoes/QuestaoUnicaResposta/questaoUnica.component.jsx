import React, { PureComponent } from 'react';
import { Select, BotaoPrincipal, Textarea } from '../../index'
import './questaoUnica.style.css'

export class QuestaoUnica extends PureComponent {

  constructor(props){
    super(props)
    this.state = {
      linguagens: props.linguagens,
      niveis: props.niveis,
    }
  }

  render() {
    return(
      <>
      <div className="container-questao">
          <div className="input-principal">
            <Select
              name="especificidade"
              value={this.props.especificidade}
              onChange={this.props.handleChange}
              object={this.state.linguagens}
              placeholder="Selecione a especificidade"/>
            </div>

          <div className="input-principal">
            <Select
              name="nivel"
              value={this.props.nivel}
              onChange={this.props.handleChange}
              object={this.state.niveis}
              placeholder="Selecione o nível"/>
          </div>

          <div className="input-principal">
            <Textarea
              label="Questão"
              name="questao"
              value={this.props.questao}
              onChange={this.props.handleChange}/>
          </div>

          {
            this.props.questaoTipoTecnica ?
            <>
            <div className="input-principal">
              <Textarea
                label="Resposta base"
                name="respostaBase"
                value={this.props.respostaBase}
                onChange={this.props.handleChange}/>
            </div>
            
            <div className="input-principal">
              <Textarea
                label="Testes base"
                name="testeBase"
                value={this.props.testeBase}
                onChange={this.props.handleChange}/>
            </div>
            </>
            :
            null
          }

          <div className="container-botao">
            <BotaoPrincipal nome="Enviar" onClick={this.props.handleClickSalvarQuestao}/>
          </div>
      </div>
      </>
    )
  }
}
