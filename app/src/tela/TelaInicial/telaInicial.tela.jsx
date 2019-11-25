import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import { GraficoPizza } from '../../component/GraficoPizza/graficoPizza.component';
import { retornarResultadosMultipla } from '../../services/prova/prova.service';
import { CadastroMultiplaQuestao, CadastroDissertativa, Notificacao, Select } from '../../component/index';
import { retornarEspecificidades, retornarNiveisDeDificuldade, retornarTipoDeQuestao } from '../../services/index';

const mensagemSucessoNotificacao = 'Busca bem sucedida';
export class TelaInicialScreen extends Component {
	constructor(props) {
		super(props);
		this.state = {
			deveRenderizarLogin: false,
			especificidades: [],
			errosEAcertos: [],
			busca: 'JAVASCRIPT',
			data: [ { name: 'Acertaram', value: 10 }, { name: 'Erraram', value: 10 } ]
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
			especificidades: await retornarEspecificidades(),
			errosEAcertos: await retornarResultadosMultipla('JAVASCRIPT')
		});
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

		return (
			<div className="container-tela">
				<h1 className="titulo">Dashboard</h1>
				{this.renderContainerComponent()}

				<GraficoPizza cor="#00C49F" data={this.state.data} />
			</div>
		);
	}
}
