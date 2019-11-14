import React, { PureComponent } from 'react';
import './questaoDissertativa.style.css'
import { Select, BotaoPrincipal } from '../../index'
import { adicionaQuestaoDissertativa } from '../../../services/index'

export class CadastroDissertativa extends PureComponent {
  constructor(props){
    super(props)
    this.state = {
      linguagens: props.linguagens,
      niveis: props.niveis,
      especificidade: '',
      nivel:'',
      questao: ''
    }
  }

  handleChange = (event) => {
    const { name, value } = event.target
    this.setState({
        [name]: value
    })
  }

  handleClickSalvarQuestao = async (event) => {
    event.preventDefault()

    const questao = {
      "questao": this.state.questao,
      "nivelDeDificuldade": this.state.nivel,
      "especificidade": this.state.especificidade
    }

    await adicionaQuestaoDissertativa(questao)
  }

  render() {
    return(
      <>
      <div className="container-questao-dissertativa">
          <div className="input-principal">
            <Select
              name="especificidade"
              value={this.state.especificidade}
              onChange={this.handleChange}
              object={this.state.linguagens}
              placeholder="Selecione a especificidade" />
            </div>

          <div className="input-principal">
            <Select
              name="nivel"
              value={this.state.nivel}
              onChange={this.handleChange}
              object={this.state.niveis}
              placeholder="Selecione o nível" />
          </div>

          <div className="input-principal">
            <label className="label">Questão</label>
            <textarea
              className="questao"
              name="questao"
              value={this.state.questao}
              onChange={this.handleChange}
              type="textarea"
              label="Questão"
              placeholder=""
              required/>
					</div>

          <div className="botao-cadastro">
					  <BotaoPrincipal nome="Enviar" onClick={this.handleClickSalvarQuestao}/>
				  </div>
      </div>
      </>
    )
  }
}
