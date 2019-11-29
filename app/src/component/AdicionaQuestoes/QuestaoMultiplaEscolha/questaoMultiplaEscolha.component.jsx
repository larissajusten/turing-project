import React, { PureComponent } from 'react';
import { BotaoPrincipal, Input, Select, Notificacao, Textarea } from '../../index'
import { adicionarQuestaoMultiplaEscolha } from '../../../services/index'
import './questaoMultiplaEscolha.style.css'

export class CadastroMultiplaQuestao extends PureComponent {

	constructor(props){
		super(props)
		this.state = {
			linguagens: props.linguagens,
			niveis: props.niveis,
			alternativaA: null,
			alternativaB: null,
			alternativaC: null,
			alternativaD: null,
			alternativaE: null,
			respostaA: '',
			respostaB: '',
			respostaC: '',
			respostaD: '',
			respostaE: '',
			resposta: '',
			especificidade: null,
			nivel: null,
      questao: null
		}
	}

	handleChange = (event) => {
    const { name, value } = event.target
    this.setState({
        [name]: value
    })
	}

	catchErrorENotifica(error){
    if (error.response.data.errors) {
      error.response.data.errors.map(message => {
        return Notificacao('Falha', `${message.defaultMessage}`, 'warning')
      })
    } else {
      Notificacao('Falha', `${error.response.data.message}`, 'danger')
    }
  }

	handleClickSalvarQuestao = async (event) => {
    event.preventDefault()

    const questao = {
      "questao": this.state.questao,
			"nivelDeDificuldade": this.state.nivel,
			"especificidade": this.state.especificidade,
			"alternativaA": {"resposta": this.state.alternativaA, "respostaCorreta": this.state.resposta === 'A' ? "true" : "false"},
			"alternativaB": {"resposta": this.state.alternativaB, "respostaCorreta": this.state.resposta === 'B' ? "true" : "false"},
			"alternativaC": {"resposta": this.state.alternativaC, "respostaCorreta": this.state.resposta === 'C' ? "true" : "false"},
			"alternativaD": {"resposta": this.state.alternativaD, "respostaCorreta": this.state.resposta === 'D' ? "true" : "false"},
			"alternativaE": {"resposta": this.state.alternativaE, "respostaCorreta": this.state.resposta === 'E' ? "true" : "false"},
		}

		try{
			await adicionarQuestaoMultiplaEscolha(questao)
			Notificacao('Sucesso', 'Questão adicionada com sucesso', 'success')
    }
    catch(error){
      this.catchErrorENotifica(error)
    }
  }

  render() {
		return (
			<>
				<div className="container-questao">

        <div className="container-select">
          <div className="input-principal">
            <Select
							questoesWidth="width-select"
              name="especificidade"
              value={this.state.especificidade}
              onChange={this.handleChange}
              object={this.state.linguagens}
              placeholder="Selecione a especificidade"/>
            </div>

          <div className="input-principal">
            <Select
							questoesWidth="width-select"
              name="nivel"
              value={this.state.nivel}
              onChange={this.handleChange}
              object={this.state.niveis}
              placeholder="Selecione o nível"/>
          </div>
        </div>

					<div className="input-principal">
						<Textarea
							label="Questão"
							name="questao"
							value={this.state.questao}
							handleChange={this.handleChange}
							maxLength="500"/>
					</div>

					<Input
						name="alternativaA"
						value={this.state.alternativaA}
						onChange={this.handleChange}
						maxTam="300"
						type="text"
						label="Alternativa A"
						placeholder=""/>

					<Input
						name="alternativaB"
						value={this.state.alternativaB}
						onChange={this.handleChange}
						maxTam="300"
						type="text"
						label="Alternativa B"
						placeholder=""/>

					<Input
						name="alternativaC"
						value={this.state.alternativaC}
						onChange={this.handleChange}
						maxTam="300"
						type="text"
						label="Alternativa C"
						placeholder=""/>

					<Input
						name="alternativaD"
						value={this.state.alternativaD}
						onChange={this.handleChange}
						maxTam="300"
						type="text"
						label="Alternativa D"
						placeholder=""/>

					<Input
						name="alternativaE"
						value={this.state.alternativaE}
						onChange={this.handleChange}
						maxTam="300"
						type="text"
						label="Alternativa E"
						placeholder=""/>

					<div className="input-principal">
						<label className="label">Resposta correta</label>
						<div className="container-radio-buttons">
							<div className="buttonRadio">
								<input type="radio" name="resposta" value="A" onClick={this.handleChange}/>
								A
							</div>
							<div className="buttonRadio">
								<input type="radio" name="resposta" value="B" onClick={this.handleChange}/>
								B
							</div>
							<div className="buttonRadio">
								<input type="radio" name="resposta" value="C" onClick={this.handleChange}/>
								C
							</div>
							<div className="buttonRadio">
								<input type="radio" name="resposta" value="D" onClick={this.handleChange}/>
								D
							</div>
							<div className="buttonRadio">
								<input type="radio" name="resposta" value="E" onClick={this.handleChange}/>
								E
							</div>
						</div>
					</div>

				</div>

				<div className="container-botao">
					<BotaoPrincipal nome="ENVIAR" onClick={this.handleClickSalvarQuestao}/>
				</div>
			</>
		);
	}
}
