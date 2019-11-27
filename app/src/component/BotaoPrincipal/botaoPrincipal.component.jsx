import React, { Component } from 'react';
import './botaoPrincipal.style.css';

export class BotaoPrincipal extends Component {
	render() {
		return (
			<>
				<button className={`botao-principal ${this.props.classe}`} onClick={this.props.onClick}>
					<span>{this.props.nome}</span></button>
			</>
		);
	}
}
