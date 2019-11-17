import React, { Component } from 'react';
import './botaoAdicionar.style.css';

export class BotaoAdicionar extends Component {
	render() {
		return (
			<>
				<button className="botao-adicionar" onClick={this.props.adicionar ? (e) => this.props.onClick(e) : () => this.props.onClick(this.props.id)}>
					<span>{this.props.nome}</span></button>
			</>
		);
	}
}