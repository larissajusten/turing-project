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
		if(this.state.errosEAcertos !== this.props.notas){
			this.setState({
				errosEAcertos: this.props.notas
			})
		}
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

	verificaTamanhoParaRenderizar(color, array) {
		if(array.length > 0) {
			return <GraficoPizza cor={color} data={array}/>
		}else {
			return null
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
