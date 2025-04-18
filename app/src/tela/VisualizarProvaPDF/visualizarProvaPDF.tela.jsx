import React, { Component } from 'react';
import { PDFViewer } from '@react-pdf/renderer';
import { MyDocument } from './BlocosPDF/'
import { Notificacao } from '../../component/'
import { BuscarProvaService } from '../../services/'
import './visualizarProvaPDF.style.css'

export class ProvaPDFScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      prova: null,
      idProva: this.props.match.params.idProva
    }
    this.buscarProvaService = new BuscarProvaService()
  }

  async componentDidMount(){
    try{
      const response = await this.buscarProvaService
        .retornaProvaCorrigidaParaPDF(this.state.idProva)
      this.setState({ prova: response })
    } catch(error){
      this.catchErrorENotifica(error)
    }
  }

  render() {
    return(
      <>
      {
        this.state.prova  &&
        <div className="container-pdf">
          <PDFViewer width="100%" height="550">
            <MyDocument prova={this.state.prova} />
          </PDFViewer>
        </div>
      }
      </>
    )
  }
}
