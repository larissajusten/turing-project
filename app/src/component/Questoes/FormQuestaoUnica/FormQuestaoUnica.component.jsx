import React, { PureComponent } from 'react';
import { Select, BotaoPrincipal } from '../../index'

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
          <div className="container-questao-dissertativa">
              <div className="input-principal">
                <Select
                  name="especificidade"
                  value={this.props.especificidade}
                  onChange={this.props.handleChange}
                  object={this.state.linguagens}
                  placeholder="Selecione a especificidade" />
                </div>
    
              <div className="input-principal">
                <Select
                  name="nivel"
                  value={this.props.nivel}
                  onChange={this.props.handleChange}
                  object={this.state.niveis}
                  placeholder="Selecione o nível" />
              </div>
    
              <div className="input-principal">
                <label className="label">Questão</label>
                <textarea
                  className="questao"
                  name="questao"
                  value={this.props.questao}
                  onChange={this.props.handleChange}
                  type="textarea"
                  label="Questão"
                  placeholder=""
                  required/>
                        </div>
    
              <div className="botao-cadastro">
                <BotaoPrincipal nome="Enviar" onClick={this.props.handleClickSalvarQuestao}/>
              </div>
          </div>
          </>
        )
      }
}