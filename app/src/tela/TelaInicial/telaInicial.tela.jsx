import React, { Component } from 'react';
import { Redirect } from 'react-router-dom'
import { retornarEspecificidades,	
					retornarResultadosMultipla,
					retornarResultadosDissertativa,
					retornarResultadosTecnica } from '../../services/index';
import { Notificacao, Select, GraficoMultipla, GraficoNotaDissertativa, GraficoNotaTecnica } from '../../component/index';
import './telaInicial.style.css';

const mensagemSucessoNotificacao = 'Busca bem sucedida';
export class TelaInicialScreen extends Component {
	constructor(props) {
		super(props);
		this.state = {
			deveRenderizarLogin: false,
			especificidades: [],
			especificidadeEscolhida: '',
			notasDissertativas: [],
			notasTecnicas: [],
			notasMultipla: []
		};
	}

	async componentDidMount() {
		let token = localStorage.getItem('accessToken');
		if (!token) {
			this.setState({
				deveRenderizarLogin: true
			});
		}else{
			this.setState({
				especificidades: await retornarEspecificidades()
			})
		}
	}	

	handleChange = async (event) => {
		const { name, value } = event.target;
		this.setState({ [name]: value }, async() => {
			this.setState({
				notasMultipla: await retornarResultadosMultipla(this.state.especificidadeEscolhida),
				notasDissertativas: await retornarResultadosDissertativa(this.state.especificidadeEscolhida),
				notasTecnicas: await retornarResultadosTecnica(this.state.especificidadeEscolhida)
			})
		})
	}

	catchErrorENotifica(error) {
		if (error.response.data.errors) {
			error.response.data.errors.map((message) => {
				return Notificacao('Falha', `${message.defaultMessage}`, 'warning');
			});
		} else {
			Notificacao('Falha', `${error.response.data.message}`, 'danger');
		}
	}

	salvaResponseENotificaSucesso(especificidades) {
		this.setState({ especificidades })
		Notificacao('Sucesso', mensagemSucessoNotificacao, 'success');
	}

	renderContainerComponent() {
		if (this.state.especificidades) {
			return (
				<div className="container-select">
					<h1 className="subtitulo-especificidade">Para qual especificidade deseja visualizar as estatisticas?</h1>
					<div className="input-principal">
					<Select
						questoesWidth="width-select"
						name="especificidadeEscolhida"
						value={this.state.especificidadeEscolhida}
						onChange={this.handleChange}
						object={this.state.especificidades}
						placeholder="Selecione a especificidade"
					/>
				</div>
			</div>
			);
		}
		else {
			return <span className="titulo-crie"> Não há especificidades para gerar gráficos </span>
		}
	}

	renderMultiplasEscolhas() {
		if(this.state.notasMultipla.length > 0){
			return <GraficoMultipla notas={this.state.notasMultipla}/>
		}else{
			return <h1 className="titulo-crie">Não há questões</h1>
		}
	}

	renderDissertativas() {
		if(this.state.notasDissertativas.length > 0){
			return <GraficoNotaDissertativa notas={this.state.notasDissertativas}/>
		}else{
			return <h1 className="titulo-crie">Não há questões</h1>
		}
	}

	renderTecnicas() {
		if(this.state.notasTecnicas.length > 0){
			return <GraficoNotaTecnica notas={this.state.notasTecnicas}/>
		}else{
			return <h1 className="titulo-crie">Não há questões</h1>
		}
	}

	renderGraficos() {
		return(
			<>
			<div className="container-nivel">
				<h6 className="nivel facil">Fácil</h6>
				<h6 className="nivel medio">Medio</h6>
				<h6 className="nivel dificil">Difícil</h6>
			</div>
			<h1 className="titulo-crie">Multiplas escolhas</h1>
			<div className="graficos">
				{this.renderMultiplasEscolhas()}
			</div>
			<h1 className="titulo-crie">Dissertativas</h1>
			<div className="graficos">
				{this.renderDissertativas()}
			</div>
			<h1 className="titulo-crie">Técnicas</h1>
			<div className="graficos">
				{this.renderTecnicas()}
			</div>
			</>
		)
	}

	render() {
		if (this.state.deveRenderizarLogin) {
			return <Redirect to="/login" />;
		}
    return (
      <>
			<div className="container-tela">
				<h1 className="titulo">Dashboard</h1>
				{this.renderContainerComponent()}
				
				{this.state.especificidadeEscolhida && this.renderGraficos()}
      </div>
      </>
		);
	}
}
