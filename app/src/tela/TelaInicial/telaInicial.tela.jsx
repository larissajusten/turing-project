import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import { GraficoPizza } from '../../component/GraficoPizza/graficoPizza.component';
import { retornarResultadosMultipla } from '../../services/prova/prova.service';
import { Notificacao, Select, GraficoMultipla, GraficoNota } from '../../component/index';
import { retornarEspecificidades } from '../../services/index';
import './telaInicial.style.css';

const mensagemSucessoNotificacao = 'Busca bem sucedida';
export class TelaInicialScreen extends Component {
	constructor(props) {
		super(props);
		this.state = {
			deveRenderizarLogin: false,
			especificidades: [],
			especificidadeEscolhida: ''
		};
	}

	async componentDidMount() {
		try {
			let especificidades = await retornarEspecificidades()
			this.salvaResponseENotificaSucesso(especificidades)
		}
		catch(error) {
			this.catchErrorENotifica(error)
		}
			// let token = localStorage.getItem('accessToken');
			// if (!token) {
			// 	this.setState({
			// 		deveRenderizarLogin: true
			// 	});
			// }
	}

	handleChange = (event) => {
		const { name, value } = event.target;
		this.setState({ [name]: value });
	};

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
		//if (this.state.deveRenderizarLogin) {
		//	return <Redirect to="/login" />;
		//}
    return (
      <>
			<div className="container-tela">
				<h1 className="titulo">Dashboard</h1>
				{this.renderContainerComponent()}
        
        <h1 className="titulo-crie">Multipla escolha</h1>
				<div className="graficos">
					<GraficoMultipla />
					<GraficoNota />
				</div>
      </div>
      </>
		);
	}
}
