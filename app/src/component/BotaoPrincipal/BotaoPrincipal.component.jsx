import React, { Component } from 'react';
import './BotaoPrincipal.style.css';

export class BotaoPrincipal extends Component {
	render() {
		return (
			<div >
				<button className="botao-principal" onClick={this.props.onClick}>
					<span>{this.props.nome}</span></button>
			</div>
		);
	}
}
