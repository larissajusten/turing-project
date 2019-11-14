import React, { Component } from 'react';
import './style.css';

export class BotaoPrincipal extends Component {
	render() {
		return (
			<div >
				<button className="botao-principal" onClick={this.props.onClick}>
					{this.props.nome}</button>
			</div>
		);
	}
}
