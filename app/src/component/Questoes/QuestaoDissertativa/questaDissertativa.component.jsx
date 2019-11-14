import React, { PureComponent } from 'react';
import './questaoDissertativa.style.css'
import { Select, BotaoPrincipal } from '../../index'

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
      "especificidade": this.state.especificidade,
      "nivel": this.state.nivel,
    }
    
    try {
      //await cadastraUsuario(questao)
    } catch (error) {
      alert(error.response.data.errors[0].defaultMessage);
    }
  }

  render() {
    return(
      <>
      <div className="container-questao-tecnica">
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