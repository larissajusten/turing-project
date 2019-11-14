import React, { PureComponent } from 'react';
import { BotaoPrincipal, Input, Select, RadioButton} from '../../index'
import './questaoMultiplaEscolha.style.css'

export class CadastroMultiplaQuestao extends PureComponent {
	constructor(props){
		super(props)
		this.state = {
			linguagens: props.linguagens,
			niveis: props.niveis,
			alternativaA: '',
			alternativaB: '',
			alternativaC: '',
			alternativaD: '',
			alternativaE: '',
			respostaCorreta: '',
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
			"alternativaA": this.state.alternativaA,
			"alternativaB": this.state.alternativaB,
			"alternativaC": this.state.alternativaC,
			"alternativaD": this.state.alternativaD,
			"alternativaE": this.state.alternativaE,
			"respostaCorreta": this.state.respostaCorreta
    }
    
    try {
      //await cadastraUsuario(questao)
    } catch (error) {
      alert(error.response.data.errors[0].defaultMessage);
    }
  }

  render() {
		return (
			<>
				<div className="container-questao-multipla-escolha">
					<div className="esquerda">

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

						<Input
							name="alternativaA"
							value={this.state.alternativaA}
							onChange={this.handleChange}
							className="input" 
							type="text" 
							label="Alternativa A" 
							placeholder="" />

						<Input
							name="alternativaB"
							value={this.state.alternativaB}
							onChange={this.handleChange}
							className="input"
							type="text"
							label="Alternativa B"
							placeholder="" />

					</div>

					<div className="direita">

						<div className="input-principal">
							<Select 
								name="especificidade"
								value={this.state.especificidade}
								onChange={this.handleChange}
								object={this.state.linguagens}
								placeholder="Selecione a especificidade" />
						</div>

						<Input
							name="alternativaC"
							value={this.state.alternativaC}
							onChange={this.handleChange}
							className="input"
							type="text"
							label="Alternativa C" 
							placeholder="" />

						<Input
							name="alternativaD"
							value={this.state.alternativaD}
							onChange={this.handleChange}
							className="input"
							type="text"
							label="Alternativa D"
							placeholder="" />

						<Input 
							name="alternativaE"
							value={this.state.alternativaE}
							onChange={this.handleChange}
							className="input" 
							type="text" 
							label="Alternativa E" 
							placeholder="" />

						<div className="input-principal">
							<label className="label">Resposta correta</label>
							<div className="container-radio-buttons">
							<RadioButton
								name="respostaCorreta"
								value={this.state.respostaCorreta}
								onClick={this.handleChange}
								/>
							</div>
						</div>
					
					</div>
				</div>

				<div className="botao-cadastro">
					<BotaoPrincipal nome="Enviar" onClick={this.handleClickSalvarQuestao}/>
				</div>
				
			</>
		);
	}
}