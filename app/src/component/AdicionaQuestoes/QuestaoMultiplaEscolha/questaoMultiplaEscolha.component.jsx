import React, { PureComponent } from 'react';
import { BotaoPrincipal, Input, Select, Notificacao, Textarea } from '../../index'
import { adicionarQuestaoMultiplaEscolha } from '../../../services/index'
import './questaoMultiplaEscolha.style.css'

export class CadastroMultiplaQuestao extends PureComponent {

	constructor(props) {
		super(props)
		this.state = {
			linguagens: props.linguagens,
			niveis: props.niveis,
			alternativaA: null,
			alternativaB: null,
			alternativaC: null,
			alternativaD: null,
			alternativaE: null,
			respostaA: '',
			respostaB: '',
			respostaC: '',
			respostaD: '',
			respostaE: '',
			resposta: '',
			especificidade: null,
			nivel: null,
			questao: null
		}
	}

	handleChange = (event) => {
		const { name, value } = event.target
		this.setState({
			[name]: value
		})
	}

	catchErrorENotifica(error) {
		if (error.response.data.errors) {
			error.response.data.errors.map(message => {
				return Notificacao('Falha', `${message.defaultMessage}`, 'warning')
			})
		} else {
			Notificacao('Falha', `${error.response.data.message}`, 'danger')
		}
	}

	handleClickSalvarQuestao = async (event) => {
		event.preventDefault()

		const questao = {
			"questao": this.state.questao,
			"nivelDeDificuldade": this.state.nivel,
			"especificidade": this.state.especificidade,
			"alternativaA": { "resposta": this.state.alternativaA, "respostaCorreta": this.state.resposta === 'A' ? "true" : "false" },
			"alternativaB": { "resposta": this.state.alternativaB, "respostaCorreta": this.state.resposta === 'B' ? "true" : "false" },
			"alternativaC": { "resposta": this.state.alternativaC, "respostaCorreta": this.state.resposta === 'C' ? "true" : "false" },
			"alternativaD": { "resposta": this.state.alternativaD, "respostaCorreta": this.state.resposta === 'D' ? "true" : "false" },
			"alternativaE": { "resposta": this.state.alternativaE, "respostaCorreta": this.state.resposta === 'E' ? "true" : "false" },
		}

		try {
			await adicionarQuestaoMultiplaEscolha(questao)
			Notificacao('Sucesso', 'Questão adicionada com sucesso', 'success')
		}
		catch (error) {
			this.catchErrorENotifica(error)
		}
	}

	renderInputs() {
		const arrayDeParamsDoInputs =
			[{ name: "alternativaA", label: "A" },
			{ name: "alternativaB", label: "B" },
			{ name: "alternativaC", label: "C" },
			{ name: "alternativaD", label: "D" },
			{ name: "alternativaE", label: "E" }]
		return arrayDeParamsDoInputs.map((item, key) => {
			return <Input
				key={key}
				name={item.name}
				value={this.state[item.name]}
				onChange={this.handleChange}
				maxTam="300"
				type="text"
				label={`Alternativa ${item.label}`}
				placeholder="" />
		})
	}

	renderSelects() {
		const arrayDeParamsDoSelect =
			[{ name: "especificidade", label: "o", object: this.state.linguagens },
			{ name: "nivel", label: "a", object: this.state.niveis }]
		return arrayDeParamsDoSelect.map((item, key) => {
			return <div className="input-principal">
				<Select
					key={key}
					questoesWidth="width-select"
					name={item.name}
					value={this.state[item.name]}
					onChange={this.handleChange}
					object={item.object}
					placeholder={`Selecione ${item.label} ${item.name}`} />
			</div>
		})
	}

	renderRadioButtons() {
		const arrayDeParamsDosRadioButtons =
			[{ value: "A" }, { value: "B" }, { value: "C" }, { value: "D" }, { value: "E" }]
		return arrayDeParamsDosRadioButtons.map((item, key) => {
			return <div className="buttonRadio">
				<input type="radio" name="resposta" value={item.value} onClick={this.handleChange} />
				{item.value}
			</div>
		})
	}

	render() {
		return (
			<>
				<div className="container-questao">
					<div className="container-select">
						{this.renderSelects()}
					</div>

					<div className="input-principal">
						<Textarea
							label="Questão"
							name="questao"
							value={this.state.questao}
							handleChange={this.handleChange}
							maxLength="500" />
					</div>

					{this.renderInputs()}

					<div className="input-principal">
						<label className="label">Resposta correta</label>
						<div className="container-radio-buttons">
							{this.renderRadioButtons()}
						</div>
					</div>
				</div>

				<div className="container-botao">
					<BotaoPrincipal nome="ENVIAR" onClick={this.handleClickSalvarQuestao} />
				</div>
			</>
		);
	}
}
