import React, { Component } from 'react';
import { Redirect } from 'react-router-dom'
import { retornarResultadosMultipla,
				retornarResultadosDissertativa,
				retornarResultadosTecnica,
				retornarEspecificidades } from '../../services/index';
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
			notasTecnicas: []
		};
	}

	async componentDidMount() {
		this.setState({
			especificidades: await retornarEspecificidades()
		})
		let token = localStorage.getItem('accessToken');
		if (!token) {
			this.setState({
				deveRenderizarLogin: true
			});
		}
	}	

	handleChange = async (event) => {
		const { name, value } = event.target;
		this.setState({ 
			[name]: value
		}, async () => {
			this.setState({
				dataMultipla: await retornarResultadosMultipla(this.state.especificidadeEscolhida),
				notasDissertativas: await retornarResultadosDissertativa(this.state.especificidadeEscolhida),
				notasTecnicas: await retornarResultadosTecnica(this.state.especificidadeEscolhida)
			})
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
		this.setState({ especificidades })
		Notificacao('Sucesso', mensagemSucessoNotificacao, 'success');
	}

	renderContainerComponent() {
		if (this.state.especificidades) {
			return (
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
			);
		}
		else {
			return <span className="titulo-crie"> Não há especificidades para gerar gráficos </span>
		}
	}

	render() {
		console.log(this.state.dataMultipla)
		console.log(this.state.dataMultipla)
		console.log(this.state.notasDissertativas)
		console.log(this.state.notasTecnicas)
		if (this.state.deveRenderizarLogin) {
			return <Redirect to="/login" />;
		}

    return (
      <>
			<div className="container-tela">
				<h1 className="titulo">Dashboard</h1>
				{this.renderContainerComponent()}
				
				<h1 className="titulo-crie">Multiplas escolhas</h1>
				<div className="graficos">
					<GraficoMultipla notas={this.state.notasDissertativas}/>	
				</div>
				<h1 className="titulo-crie">Dissertativas</h1>
				<div className="graficos">
					<GraficoNotaDissertativa notas={this.state.notasDissertativas}/>	
				</div>
				<h1 className="titulo-crie">Técnicas</h1>
				<div className="graficos">
					<GraficoNotaTecnica notas={this.state.notasTecnicas}/>	
				</div>
      </div>
      </>
		);
	}
}
