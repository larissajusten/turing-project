import React, { Component } from 'react';
import { BotaoPrincipal } from '../../component';
import './style.css';
import { Input } from '../../component/Input/Input.component';
import { Select } from '../../component/Select/select.component';

export class CadastroMultiplaQuestao extends Component {
	state = {
		linguagens: [ 'JS', 'Java', 'React' ],
		niveis: [ 'Iniciante', 'Intermediário', 'Avançado' ]
	};

	render() {
		return (
			<div className="tela-cadastro">
				<div className="container-tela-cadastro">
					<div className="esquerda">
						<Select object={this.state.niveis} placeholder="Selecione o nível" />
						<Input className="questao" type="text" label="Questão" placeholder="" />
						<Input className="input" type="text" label="Alternativa A" placeholder="" />
						<Input className="input" type="text" label="Alternativa B" placeholder="" />
						<Input className="input" type="text" label="Alternativa C" placeholder="" />
					</div>
					<div className="direita">
						<Select object={this.state.linguagens} placeholder="Selecione a especificidade" />
						<Input className="input" type="text" label="Alternativa D" placeholder="" />
						<Input className="input" type="text" label="Alternativa E" placeholder="" />
					</div>
					<div className="botao-cadastro">
						<BotaoPrincipal nome="SALVAR" />
					</div>
				</div>
			</div>
		);
	}
}
