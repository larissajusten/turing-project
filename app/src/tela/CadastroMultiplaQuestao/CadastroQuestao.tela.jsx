import React, { PureComponent } from 'react';
import './CadastroQuestao.style.css';
import { CadastroMultiplaQuestao, CadastroDissertativa, CadastroTecnica, Select } from '../../component/index'

export class CadastrarQuestaoScreen extends PureComponent {
	constructor(props){
		super(props)
		this.state = {
			questoes: [ 'Dissertativa', 'Múltipla Escolha', 'Técnica'],
			linguagens: [ 'JS', 'Java', 'React' ],
			niveis: [ 'Iniciante', 'Intermediário', 'Avançado' ],
			questao: ''
		}
	}

	handleChange = (event) => {
    const { name, value } = event.target
    this.setState({
        [name]: value
    })
  } 

	render() {
		return (
			<>
			<div className="tela-cadastro">
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
					this.state.questao === 'Múltipla Escolha' 
					? 
					<CadastroMultiplaQuestao 
						linguagens = {this.state.linguagens}
						niveis = {this.state.niveis}
						/>
					: 
					( 
						this.state.questao === 'Dissertativa' 
						? 
						<CadastroDissertativa
							linguagens = {this.state.linguagens}
							niveis = {this.state.niveis}
							/> 
						: 
						<CadastroTecnica
							linguagens = {this.state.linguagens}
							niveis = {this.state.niveis}
							/> 
					)
				}
			</div>
			</>
		);
	}
}
