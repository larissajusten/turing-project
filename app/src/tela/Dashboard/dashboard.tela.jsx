import React, { Component } from 'react';
import { retornarEspecificidades,
				retornarResultadosMultipla,
				retornarResultadosDissertativa,
				retornarResultadosTecnica,
				retornaTecnologias } from '../../services/index';
import { Notificacao,
					Select,
					GraficoMultipla,
					GraficoNota,
					GraficoTecnologias,
					GraficoDeBarras } from '../../component/index';
import './dashboard.style.css';

const mensagemSucessoNotificacao = 'Busca bem sucedida';
export class DashboardScreen extends Component {
	constructor(props) {
		super(props);
		this.state = {
			especificidades: [],
			especificidadeEscolhida: '',
			notasDissertativas: [],
			notasTecnicas: [],
			notasMultipla: []
		};
	}

	async componentDidMount() {
		this.setState({
			especificidades: await retornarEspecificidades(),
			tecnologias: await retornaTecnologias()
		});
	}

	handleChange = async (event) => {
		const { name, value } = event.target;
		this.setState({ [name]: value }, async () => {
			let notasMultiplas = await retornarResultadosMultipla(this.state.especificidadeEscolhida)
			let notasDissertativas = await retornarResultadosDissertativa(this.state.especificidadeEscolhida)
			let notasTecnicas = await retornarResultadosTecnica(this.state.especificidadeEscolhida)
			this.setState({
				notasMultipla: notasMultiplas,
				notasDissertativas: notasDissertativas,
				notasTecnicas: notasTecnicas
			});
		});
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
		this.setState({ especificidades });
		Notificacao('Sucesso', mensagemSucessoNotificacao, 'success');
	}

	renderGraficoTecnologias() {
		console.log(this.state.tecnologias)
		if(this.state.tecnologias) {
			return <GraficoDeBarras tecnologias={this.state.tecnologias} />
		} else {
			return <h1 className="titulo-nao-tem-questao">Não há questões de múltipla escolha!</h1>;
		}
	}

	renderContainerComponent() {
		if (this.state.especificidades) {
			return (
				<div className="container-select">
					<h1 className="subtitulo-especificidade">
						Para qual especificidade deseja visualizar as estatisticas?
					</h1>
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
		} else {
			return <span className="titulo-crie"> Não há especificidades para gerar gráficos </span>;
		}
	}

	renderMultiplasEscolhas() {
		if (this.state.notasMultipla.length > 0) {
			return <GraficoMultipla notas={this.state.notasMultipla} />;
		} else {
			return <h1 className="titulo-nao-tem-questao">Não há questões de múltipla escolha!</h1>;
		}
	}

	renderTecnicasEDissertativas(array) {
		if (array.length > 0) {
			return <GraficoNota notas={array} />;
		} else {
			return <h1 className="titulo-nao-tem-questao">Não há questões!</h1>;
		}
	}

	renderGraficos() {
		console.log(this.state.tecnologias)
		return (
			<div>
				<div className="container-nivel">
					<h6 className="nivel facil">Fácil</h6>
					<h6 className="nivel medio">Medio</h6>
					<h6 className="nivel dificil">Difícil</h6>
				</div>
				<h1 className="titulo-crie">Multiplas escolhas</h1>
				<div className="graficos">{this.renderMultiplasEscolhas()}</div>
				<h1 className="titulo-crie">Dissertativas</h1>
				<div className="graficos">{this.renderTecnicasEDissertativas(this.state.notasDissertativas)}</div>
				<h1 className="titulo-crie">Técnicas</h1>
				<div className="graficos">{this.renderTecnicasEDissertativas(this.state.notasTecnicas)}</div>
			</div>
		);
	}

	render() {
		return (
			<div>
				<div className="container-tela">
					<h1 className="titulo">Dashboard</h1>
					{this.renderGraficoTecnologias()}
					{this.renderContainerComponent()}
				</div>
				{this.state.especificidadeEscolhida && this.renderGraficos()}
			</div>
		);
	}
}
