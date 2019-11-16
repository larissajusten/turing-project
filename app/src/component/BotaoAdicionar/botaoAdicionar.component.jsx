import React, { Component } from 'react';
import './botaoAdicionar.style.css';

export class BotaoAdicionar extends Component {
	render() {
		return (
			<>
				<button className="botao-adicionar" onClick={this.props.onClick}>
					<span>{this.props.nome}</span></button>
			</>
		);
	}
}