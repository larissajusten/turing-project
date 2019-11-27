import React, { Component } from 'react';
import { GraficoPizza } from '../GraficoPizza/graficoPizza.component'

export class GraficoNota extends Component {
	constructor(props) {
		super(props);
		this.state = {
			notas: props.notas,
			dataFacil: [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}],
			dataMedio: [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}],
			dataDificil: [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}]
		};
	}

	async componentDidMount() {
		const f = this.state.notas
			.filter(n => n.nivelDeDificuldade === 'FACIL')
			.map(nota => ({ name: nota.notaQuestao, value: nota.totalDePessoas }))

		const m = this.state.notas
			.filter(n => n.nivelDeDificuldade === 'MEDIO')
			.map(nota => ({ name: nota.notaQuestao, value: nota.totalDePessoas }))

		const d = this.state.notas
			.filter(n => n.nivelDeDificuldade === 'DIFICIL')
			.map(nota => ({ name: nota.notaQuestao, value: nota.totalDePessoas }))

		this.setState({
			dataFacil: f,
			dataMedio: m,
			dataDificil: d
		})
	}

	componentDidUpdate() {
		if (this.state.notas !== this.props.notas) {
			this.setState({
				notas: this.props.notas
			})
		}
	}

	verificaTamanhoParaRenderizar(color, array) {
		if(array.length > 0) {
			return <GraficoPizza cor={color} data={array}/>
		}else {
			return <h1 className="titulo-crie"> Não há questões para visualizar </h1>
		}
	}

	render() {
		return (
			<>
				{this.verificaTamanhoParaRenderizar("#00C49F", this.state.dataFacil)}
				{this.verificaTamanhoParaRenderizar("#FFBB28", this.state.dataMedio)}
				{this.verificaTamanhoParaRenderizar("#FF8042", this.state.dataDificil)}
			</>
		);
	}
}
