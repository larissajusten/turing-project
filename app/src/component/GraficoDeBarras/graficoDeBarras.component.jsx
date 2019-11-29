import React, { PureComponent } from 'react';
import { BarChart, Bar, Cell, XAxis, YAxis, CartesianGrid, Tooltip } from 'recharts';

export class GraficoDeBarras extends PureComponent {
  render() {
    const data = [
      {
        name: this.props.tecnologias[0].especificidade.toLowerCase(),
        candidatos: this.props.tecnologias[0].quantosUsuarios,
        amt: 100,
      },
      {
        name: this.props.tecnologias[1].especificidade.toLowerCase(),
        candidatos: this.props.tecnologias[1].quantosUsuarios,
        amt: 2,
      },
      {
        name: this.props.tecnologias[2].especificidade.toLowerCase(),
        candidatos: this.props.tecnologias[2].quantosUsuarios,
        amt: 2290,
      },
      {
        name: this.props.tecnologias[3].especificidade.toLowerCase(),
        candidatos: this.props.tecnologias[3].quantosUsuarios,
        amt: 2000,
      },
      {
        name: this.props.tecnologias[4].especificidade.toLowerCase(),
        candidatos: this.props.tecnologias[4].quantosUsuarios,
        amt: 2181,
      },
      {
        name: this.props.tecnologias[5].especificidade.toLowerCase(),
        candidatos: this.props.tecnologias[5].quantosUsuarios,
        amt: 2390
      },
      {
        name: this.props.tecnologias[6].especificidade.toLowerCase(),
        candidatos: this.props.tecnologias[6].quantosUsuarios,
        amt: 2100,
      },
      {
        name: this.props.tecnologias[7].especificidade.toLowerCase(),
        candidatos: this.props.tecnologias[7].quantosUsuarios,
        amt: 2100,
      },
    ]

    const cores = ['#f7e018', '#0172b7', '#82ca9d', '#3873a3', '#950c10', '#950c10', '#0077c6', '#f42e23' ]
    return (
      <>
      <BarChart
        width={600}
        height={300}
        data={data}
        margin={{ top: 5, right: 60, left: 20, bottom: 30 }}>
        <CartesianGrid strokeDasharray="1"/>
        <XAxis dataKey="name" label={{ value: 'Linguagens',  position: 'bottom' }}/>
        <YAxis label={{ value: 'Quantidade de candidatos', angle: -90 }} domain={[0, 'dataMax + 4']}/>
        <Tooltip/>
        <Bar barSize={22} dataKey="candidatos">
          {
          	data.map((item, index) => {
            	return <Cell fill={cores[index]}/>
            })
          }
        </Bar>
      </BarChart>
      </>
    );
  }
}
