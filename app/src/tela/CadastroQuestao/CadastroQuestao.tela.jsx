import React, { Component } from 'react';
import './CadastroQuestao.style.css';
import { CadastroMultiplaQuestao, CadastroDissertativa, CadastroTecnica, Select } from '../../component/index'
import { retornarEspecificidades, retornarNiveisDeDificuldade } from '../../services/index'

export class CadastrarQuestaoScreen extends Component {
	constructor(props){
		super(props)
		this.state = {
			questoes: [ 'Dissertativa', 'Múltipla Escolha', 'Técnica'],
			especificidade: [],
			niveis: [],
			questao: ''
		}
	}

	async componentDidMount() {
		this.setState({
			especificidade: await retornarEspecificidades(),
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
		if(this.state.questao === 'Múltipla Escolha'){
			return(
				<CadastroMultiplaQuestao
					linguagens = {this.state.especificidade}
					niveis = {this.state.niveis}
					/>
			)
		}else if(this.state.questao === 'Dissertativa'){
			return(
				<CadastroDissertativa
					linguagens = {this.state.especificidade}
					niveis = {this.state.niveis}
					/>
			)
		}else if(this.state.questao === 'Técnica'){
			return(
				<CadastroTecnica
					linguagens = {this.state.especificidade}
					niveis = {this.state.niveis}
					/>
			)
		}else{
			return(
				<h2>Escolha qual questão deseja cadastrar</h2>
			)
		}
	}

	renderContainerComponent () {
		if(this.state.especificidade && this.state.niveis){
			return (
				<>
					<div className="container-titulo">
						<span className="titulo-crie">Crie sua Questao </span>
						<Select
							questoesWidth = "width-questoes"
							placeholder = "Selecione"
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
		}
	}

	render() {
		return(
			<div className="tela-cadastro">
					{this.renderContainerComponent()}
			</div>
		)
	}
}
