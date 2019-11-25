import React, { Component } from 'react';
import { GraficoPizza } from '../GraficoPizza/graficoPizza.component';
import { retornarResultadosMultipla } from '../../services/prova/prova.service';
import { retornarEspecificidades } from '../../services/index';

export class GraficoMultipla extends Component {
	constructor(props) {
		super(props);
		this.state = {
			errosEAcertos: [],
			busca: 'JAVASCRIPT',
			dataFacil: [ {}, {} ],
			dataMedio: [ {}, {} ],
			dataDificil: [ {}, {} ]
		};
    }
    
	async componentDidMount() {
		this.setState(
			{
				especificidades: await retornarEspecificidades(),
				errosEAcertos: await retornarResultadosMultipla('JAVASCRIPT')
			},
			() => {
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
				});
			}
		);
	}

	render() {
    return (
      <> 
		<GraficoPizza cor="#00C49F" data={this.state.dataFacil} nome="Fácil"/>
		<GraficoPizza cor="#FFBB28" data={this.state.dataMedio} nome="Médio"/>
		<GraficoPizza cor="#FF8042" data={this.state.dataDificil} nome="Difícil"/>
        </>
		);
	}
}
