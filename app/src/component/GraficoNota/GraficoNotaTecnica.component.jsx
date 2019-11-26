import React, { Component } from 'react';
import { GraficoPizza } from '../GraficoPizza/graficoPizza.component'

export class GraficoNotaTecnica extends Component {
	constructor(props) {
		super(props);
		this.state = {
			notas: props.notas,
            dataFacil: [ {}, {}, {}, {}, {}, {}, {}, {}, {}, {} ],
            dataMedio: [ {}, {}, {}, {}, {}, {}, {}, {}, {}, {} ],
            dataDificil: [ {}, {}, {}, {}, {}, {}, {}, {}, {}, {} ]
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

    componentDidUpdate(){
		if(this.state.notas !== this.props.notas){
			this.setState({
				notas: this.props.notas
			})
		}
	}

    renderGraficoPizzaFacil() {
		if(this.state.dataFacil.length > 0) {
			return <GraficoPizza cor="#00C49F" data={this.state.dataFacil}/>
		} 
	}

	renderGraficoPizzaMedio() {
		if(this.state.dataMedio.length > 0) {
			return <GraficoPizza cor="#FFBB28" data={this.state.dataMedio}/>
		} 
	}

	renderGraficoPizzaDificil() {
		if(this.state.dataDificil.length > 0) {
			return <GraficoPizza cor="#FF8042" data={this.state.dataDificil}/>
		} 
	}

	render() {
    return (
      <> 
        {this.renderGraficoPizzaFacil()}
        {this.renderGraficoPizzaMedio()}
        {this.renderGraficoPizzaDificil()}
      </>
	);
	}
}
