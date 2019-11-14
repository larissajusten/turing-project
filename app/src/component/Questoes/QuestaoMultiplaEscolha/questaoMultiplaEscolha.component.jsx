import React, { PureComponent } from 'react';
import { BotaoPrincipal, Input, Select, RadioButton} from '../../index'
import './questaoMultiplaEscolha.style.css'
import { adicionaQuestaoTecnica } from '../../../services/index'

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
			respostaA: '',
			respostaB: '',
			respostaC: '',
			respostaD: '',
			respostaE: '',
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
			"nivel": this.state.nivel,
			"especificidade": this.state.especificidade,
			"alternativaA": {"resposta": this.state.alternativaA, "respostaCorreta": this.state.respostaA},
			"alternativaB": {"resposta": this.state.alternativaB, "respostaCorreta": this.state.respostaB},
			"alternativaC": {"resposta": this.state.alternativaC, "respostaCorreta": this.state.respostaC},
			"alternativaD": {"resposta": this.state.alternativaD, "respostaCorreta": this.state.respostaD},
			"alternativaE": {"resposta": this.state.alternativaE, "respostaCorreta": this.state.respostaE},
    }
    
    try {
      await adicionaQuestaoTecnica(questao)
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
								<div className="buttonRadio">
									<input type="radio" name={this.state.respostaA} value={this.state.value} onClick={this.handleChange}/>
									A
								</div>
								<div className="buttonRadio">
									<input type="radio" name={this.state.respostaB} value={this.state.value} onClick={this.handleChange}/>
									B
								</div>
								<div className="buttonRadio">
									<input type="radio" name={this.state.respostaC} value={this.state.value} onClick={this.handleChange}/>
									C
								</div>
								<div className="buttonRadio">
									<input type="radio" name={this.state.respostaD} value={this.state.value} onClick={this.handleChange}/>
									D
								</div>
								<div className="buttonRadio">
									<input type="radio" name={this.state.respostaE} value={this.state.value} onClick={this.handleChange}/>
									E
								</div>
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