import React, { Component } from 'react';
import './cadastroQuestao.style.css';
import { CadastroMultiplaQuestao, CadastroDissertativa, CadastroTecnica, Select } from '../../component/index'
import { retornarEspecificidades, retornarNiveisDeDificuldade, retornarTipoDeQuestao } from '../../services/index'

export class CadastrarQuestaoScreen extends Component {
	constructor(props) {
		super(props)
		this.state = {
			questoes: [],
			especificidades: [],
			niveis: [],
			questao: ''
		}
	}

	async componentDidMount() {
		this.setState({
			questoes: await retornarTipoDeQuestao(),
			especificidades: await retornarEspecificidades(),
			niveis: await retornarNiveisDeDificuldade()
		})
	}

	handleChange = (event) => {
		const { name, value } = event.target
		this.setState({
			[name]: value
		})
	}

	renderComponent() {
		if (this.state.questao === this.state.questoes[0]) {
			return (
				<CadastroDissertativa
					linguagens={this.state.especificidades}
					niveis={this.state.niveis}
				/>
			)
		} else if (this.state.questao === this.state.questoes[1]) {
			return (
				<CadastroMultiplaQuestao
					linguagens={this.state.especificidades}
					niveis={this.state.niveis}
				/>
			)
		} else if (this.state.questao === this.state.questoes[2]) {
			return (
				<CadastroTecnica
					linguagens={this.state.especificidades}
					niveis={this.state.niveis}
				/>
			)
		} else {
			return (
				<h2>Escolha qual questão deseja cadastrar</h2>
			)
		}
	}

	renderContainerComponent() {
		if (this.state.especificidades && this.state.niveis) {
			return (
				<>
					<div className="container-titulo">
						<span className="titulo-crie">Crie sua Questão </span>
						<Select
							questoesWidth="width-questoes"
							placeholder="Selecione"
							name="questao"
							value={this.state.questao}
							onChange={this.handleChange}
							object={this.state.questoes}
						/>
					</div>
					{
						this.renderComponent()
					}
				</>
			);
		} else {
			return <h3>Não há especificidades ou niveis no banco para você poder cadastrar uma questão</h3>
		}
	}

	render() {
		return (
			<div className="container-tela">
				{this.renderContainerComponent()}
			</div>
		)
	}
}
