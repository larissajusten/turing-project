import React, { Component } from 'react';
import { retornarResultadosDissertativa, retornarResultadosTecnica, retornarEspecificidades } from '../../services/index';
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

	async componentDidMount() {
		this.setState({
		notasDissertativas: await retornarResultadosDissertativa('JAVASCRIPT'),
		notasTecnicas: await retornarResultadosTecnica('JAVASCRIPT')
		})
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
		console.log(this.state.notasDissertativas);
    return (
      <>
			<div className="container-tela">
				<h1 className="titulo">Dashboard</h1>
				{this.renderContainerComponent()}
				
				<h1 className="titulo-crie">Multiplas escolhas</h1>
				<div className="graficos">
					<GraficoMultipla />	
				</div>
				<h1 className="titulo-crie">Dissertativas</h1>
				<div className="graficos">
					<GraficoNota notas={this.state.notasDissertativas}/>	
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
