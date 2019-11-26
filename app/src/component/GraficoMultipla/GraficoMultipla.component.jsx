import React, { Component } from 'react';
import { GraficoPizza } from '../GraficoPizza/graficoPizza.component'

export class GraficoMultipla extends Component {
	constructor(props) {
		super(props);
		this.state = {
			errosEAcertos: props.notas,
			dataFacil: [ {}, {} ],
			dataMedio: [ {}, {} ],
			dataDificil: [ {}, {} ]
		};
    }
    
	componentDidMount() {
		this.setState({
			dataFacil: [
				{ name: 'Acertaram', value: this.state.errosEAcertos[0] },
				{ name: 'Erraram', value: this.state.errosEAcertos[1] }
			],
			dataMedio: [
				{ name: 'Acertaram', value: this.state.errosEAcertos[2] },
				{ name: 'Erraram', value: this.state.errosEAcertos[3] }
			],
			dataDificil: [
				{ name: 'Acertaram', value: this.state.errosEAcertos[4] },
				{ name: 'Erraram', value: this.state.errosEAcertos[5] }
			]
		})
	}

	componentDidUpdate(){
		if(this.state.errosEAcertos !== this.props.notas){
			this.setState({
				errosEAcertos: this.props.notas
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
