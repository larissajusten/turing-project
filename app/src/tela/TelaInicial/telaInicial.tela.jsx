import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import { GraficoPizza } from '../../component/GraficoPizza/graficoPizza.component';
import { retornarResultadosMultipla } from '../../services/prova/prova.service';
import { Notificacao, Select } from '../../component/index';
import { retornarEspecificidades } from '../../services/index';
import './telaInicial.style.css';

const mensagemSucessoNotificacao = 'Busca bem sucedida';
export class TelaInicialScreen extends Component {
	constructor(props) {
		super(props);
		this.state = {
			deveRenderizarLogin: false,
			especificidades: [],
			errosEAcertos: [],
			busca: 'JAVASCRIPT',
			dataFacil: [ {}, {} ],
			dataMedio: [ {}, {} ],
			dataDificil: [ {}, {} ]
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
		this.setState(
			{
				especificidades: await retornarEspecificidades(),
				errosEAcertos: await retornarResultadosMultipla('JAVASCRIPT')
			},
			() => {
				this.setState({
					dataFacil: [
						{ name: 'Acertaram', value: this.state.errosEAcertos[0] },
						{ name: 'Erraram', value: this.state.errosEAcertos[1] }
					],
					dataMedio: [
						{ name: 'Acertaram', value: this.state.errosEAcertos[2] },
						{ name: 'Erraram', value: this.state.errosEAcertos[3] }
					],
					dataDificil: [
						{ name: 'Acertaram', value: this.state.errosEAcertos[4] },
						{ name: 'Erraram', value: this.state.errosEAcertos[5] }
					]
				});
			}
		);
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
      <>
			<div className="container-tela">
				<h1 className="titulo">Dashboard</h1>
        {this.renderContainerComponent()}
        
        <h1>Multipla escolha</h1>
        <div className="graficos">
					<GraficoPizza cor="#00C49F" data={this.state.dataFacil} />
					<GraficoPizza cor="#FFBB28" data={this.state.dataMedio} />
					<GraficoPizza cor="#FF8042" data={this.state.dataDificil} />
          </div>
          </div>
        </>
		);
	}
}
