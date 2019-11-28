import React, { PureComponent } from 'react';
import { BarChart, Bar, Cell, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';

const label = (props) => {
  if(props[0].especificidade){
    return "javascript"
  }else if(props[1].especificidade){
    return "java"
  }else if(props[2].especificidade){
    return "c"
  }else if(props[3].especificidade){
    return "php"
  }else if(props[4].especificidade){
    return "python"
  }else if(props[5].especificidade){
    return "ruby"
  }else if(props[6].especificidade){
    return "typescript"
  }else if(props[7].especificidade){
    return "swift"
  }
}

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
    //width={100} wrapperStyle={{ top: 40, right: 20, backgroundColor: '#f5f5f5', border: '1px solid #d5d5d5', borderRadius: 3, lineHeight: '40px'}}
    return (
      <>
      <BarChart
        width={600}
        height={300}
        data={data}
        margin={{ top: 5, right: 60, left: 20, bottom: 30 }}>
        <CartesianGrid strokeDasharray="1"/>
        <XAxis dataKey="name" label={{ value: 'Linguagens',  position: 'bottom' }}/>
        <YAxis label={{ value: 'Quantidade', angle: -90}} domain={[0, 'dataMax + 4']}/>
        <Tooltip/>
        <Bar barSize={22} dataKey="candidatos"  label={label(this.props.tecnologias)}>
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
