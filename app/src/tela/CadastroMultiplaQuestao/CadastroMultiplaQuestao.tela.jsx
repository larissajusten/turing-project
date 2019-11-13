import React, { Component } from 'react';
import { BotaoPrincipal } from '../../component';
import './style.css';
import { Input } from '../../component/Input/Input.component';

export class CadastroMultiplaQuestao extends Component {
	render() {
		return (
			<div className="tela-cadastro">
				<BotaoPrincipal nome="SALVAR">Hello</BotaoPrincipal>
				<Input type="text" label="oi" placeholder="Esse é o placeholder..." />
			</div>
		);
	}
}
