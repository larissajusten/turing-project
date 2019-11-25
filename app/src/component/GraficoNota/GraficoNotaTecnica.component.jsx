import React, { Component } from 'react';
import { GraficoPizza } from '../GraficoPizza/graficoPizza.component';
import { retornarResultadosTecnica } from '../../services/prova/prova.service';
import { retornarEspecificidades } from '../../services/index';

export class GraficoNotaTecnica extends Component {
	constructor(props) {
		super(props);
		this.state = {
			notas: [],
			busca: 'JAVASCRIPT',
            dataFacil: [ {}, {}, {}, {}, {}, {}, {}, {}, {}, {} ],
            dataMedio: [ {}, {}, {}, {}, {}, {}, {}, {}, {}, {} ],
            dataDificil: [ {}, {}, {}, {}, {}, {}, {}, {}, {}, {} ]
		};
    }
    
	async componentDidMount() {
		this.setState({
			 notas: await retornarResultadosTecnica('JAVASCRIPT')
			},
			() => {
                const f = this.state.notas
                    .filter(n => n.nivelDeDificuldade === 'FACIL')
                    .map(nota => ({ name: nota.notaQuestao, value: nota.totalDePessoas }));

                this.setState({
                    dataFacil: f
                });

                const m = this.state.notas
                    .filter(n => n.nivelDeDificuldade === 'MEDIO')
                    .map(nota => ({ name: nota.notaQuestao, value: nota.totalDePessoas }));

                this.setState({
                    dataMedio: m
                });

                const d = this.state.notas
                    .filter(n => n.nivelDeDificuldade === 'DIFICIL')
                    .map(nota => ({ name: nota.notaQuestao, value: nota.totalDePessoas }));

                this.setState({
                    dataDificil: d
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
