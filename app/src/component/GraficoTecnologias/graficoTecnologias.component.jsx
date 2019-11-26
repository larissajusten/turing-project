import React, { Component } from 'react';
import { GraficoPizza } from '../GraficoPizza/graficoPizza.component'

export class GraficoTecnologias extends Component {
  constructor(props) {
    super(props);
    this.state = {
      tecnologias: props.tecnologias,
      dataTecnologias: [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}]
    }
  }

  async componentDidMount() {
    const tech = this.state.tecnologias
      .map(tecnologia => ({ name: tecnologia.especificidade, value: tecnologia.quantosUsuarios }))
    this.setState({
      dataTecnologias: tech
    })
  }

  componentDidUpdate() {
    if (this.state.tecnologias !== this.props.tecnologias) {
      this.setState({
        tecnologias: this.props.tecnologias
      })
    }
  }

  renderGraficoTecnologias() {
    if (this.state.dataTecnologias.length > 0) {
      return <GraficoPizza cor="#28a745" data={this.state.dataTecnologias} />
    }
  }

  render() {
    return (
      <>
        {this.renderGraficoTecnologias()}
      </>
    );
  }
}