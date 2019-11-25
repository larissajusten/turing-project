import React, { Component } from 'react';
import { GraficoPizza } from '../GraficoPizza/graficoPizza.component';
import { retornarResultadosDissertativa } from '../../services/prova/prova.service';
import { retornarEspecificidades } from '../../services/index';

export class GraficoNota extends Component {
	constructor(props) {
		super(props);
		this.state = {
			notas: [],
			busca: 'JAVASCRIPT',
            dataFacil: [ {}, {}, {}, {}, {}, {}, {}, {}, {}, {} ],
            dataMedia: [ {}, {}, {}, {}, {}, {}, {}, {}, {}, {} ],
            dataDificil: [ {}, {}, {}, {}, {}, {}, {}, {}, {}, {} ]
		};
    }
    
	async componentDidMount() {
		this.setState(
			{
				especificidades: await retornarEspecificidades(),
				notas: await retornarResultadosDissertativa('JAVASCRIPT')
			},
			() => {
				this.setState({
					
				});
			}
		);
	}

	render() {
        console.log('====================================');
        console.log(this.state.notas);
        console.log('====================================');
    return (
      <> 
		
      </>
		);
	}
}
