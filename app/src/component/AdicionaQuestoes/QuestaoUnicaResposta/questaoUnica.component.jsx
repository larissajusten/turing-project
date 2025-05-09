import React, { PureComponent } from 'react';
import { Select, BotaoPrincipal, Textarea } from '../../'
import './questaoUnica.style.css'

export class QuestaoUnica extends PureComponent {

  constructor(props){
    super(props)
    this.state = {
      linguagens: props.linguagens,
      niveis: props.niveis,
    }
    this.arrayDeParamsDoSelect = [
      { name: "especificidade", value: "especificidade", label: "o", object: this.state.linguagens },
      { name: "nivel", value: "nivel", label: "a", object: this.state.niveis }
    ]

    this.arrayDeParamsDoTextArea = [
      { name: "respostaBase", value: "resposta", label:"Resposta base"},
      { name: "testeBase", value: "testes", label: "Testes base"}
    ]
  }

  renderSelects() {
		return this.arrayDeParamsDoSelect.map((item, key) => {
			return <div className="input-principal cadastro-questao">
				<Select
					key={key}
					name={item.name}
					value={this.props[item.name]}
					onChange={this.props.handleChange}
					object={item.object}
					placeholder={`Selecione ${item.label} ${item.name}`} />
			</div>
		})
	}

  renderTextAreaQuestaoTecnica() {
		return this.arrayDeParamsDoTextArea.map((item, key) => {
			return <div className="input-principal">
              <Textarea
                label={item.label}
                name={item.name}
                value={this.props[item.label]}
                handleChange={this.props.handleChange}/>
            </div>
		})
  }

  render() {
    return(
      <>
      <div className="container-questao">

        <div className="container-select">
          {this.renderSelects()}
        </div>

          <div className="input-principal">
            <Textarea
              label="Questão"
              name="questao"
              value={this.props.questao}
              handleChange={this.props.handleChange}/>
          </div>

          {
            this.props.questaoTipoTecnica &&
            <>
            {this.renderTextAreaQuestaoTecnica()}
            </>
          }

          <div className="container-botao">
            <BotaoPrincipal nome="ENVIAR" onClick={this.props.handleClickSalvarQuestao}/>
          </div>
      </div>
      </>
    )
  }
}
