import React, { Component } from 'react';
import { retornarResultadosDissertativa, retornarResultadosTecnica } from '../../services/prova/prova.service';
import { Notificacao, Select, GraficoMultipla, GraficoNota, GraficoNotaTecnica } from '../../component/index';
import './telaInicial.style.css';

const mensagemSucessoNotificacao = 'Busca bem sucedida';
export class TelaInicialScreen extends Component {
	constructor(props) {
		super(props);
		this.state = {
			deveRenderizarLogin: false,
			especificidades: [], 
			notasDissertativas: [],
			notasTecnicas: []
		};
	}

	//	componentDidMount() {
	//		let token = localStorage.getItem('accessToken');
	//		if (!token) {
	//			this.setState({
	//				deveRenderizarLogin: true
	//			});
	//		}
	//  }

	async componentDidMount() {
		this.setState({
		notasDissertativas: await retornarResultadosDissertativa('JAVASCRIPT'),
		notasTecnicas: await retornarResultadosTecnica('JAVASCRIPT')
		})
	}
		

	handleChange = (event) => {
		const { name, value } = event.target;
		this.setState({
			[name]: value
		});
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

	salvaResponseENotificaSucesso() {
		Notificacao('Sucesso', mensagemSucessoNotificacao, 'success');
	}

	renderContainerComponent() {
		if (this.state.especificidades) {
			return (
				<div className="input-principal">
					<Select
						questoesWidth="width-select"
						name="especificidade"
						value={this.state.especificidades}
						onChange={this.handleChange}
						object={this.state.especificidades}
						placeholder="Selecione a especificidade"
					/>
				</div>
			);
		}
	}

	render() {
		//if (this.state.deveRenderizarLogin) {
		//	return <Redirect to="/login" />;
		//}

		console.log(this.state.notasDissertativas);
		
    return (
      <>
		<div className="container-tela">
			<h1 className="titulo">Dashboard</h1>
        {this.renderContainerComponent()}
       
        <h1>Multiplas escolhas</h1>
        <div className="graficos">
			<GraficoMultipla />	
        </div>
		<h1>Dissertativas</h1>
        <div className="graficos">
			<GraficoNota notas={this.state.notasDissertativas}/>	
        </div>
		<h1>Técnicas</h1>
        <div className="graficos">
			<GraficoNotaTecnica notas={this.state.notasTecnicas}/>	
        </div>
        </div>
        </>
		);
	}
}
