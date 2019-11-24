import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import GraficoPizza from '../../component/GraficoPizza/graficoPizza.component';

export class TelaInicialScreen extends Component {
	constructor(props) {
		super(props);
		this.state = {
			deveRenderizarLogin: false
		};
	}

	componentDidMount() {
		let token = localStorage.getItem('accessToken');
		if (!token) {
			this.setState({
				deveRenderizarLogin: false
			});
		}
	}

	render() {
		if (this.state.deveRenderizarLogin) {
			return <Redirect to="/login" />;
		}

		return (
			<div className="container-tela">
				<h1 className="titulo">Dashboard</h1>
				oi
				<GraficoPizza cor="#00C49F" />
			</div>
		);
	}
}
