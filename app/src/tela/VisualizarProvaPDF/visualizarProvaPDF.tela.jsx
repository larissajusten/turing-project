import React, { Component } from 'react';
import { PDFViewer } from '@react-pdf/renderer';
import { MyDocument } from './BlocosPDF/index'
import { Notificacao } from '../../component/index'
import { retornaProvaCorrigidaParaPDF } from '../../services/index'
import './visualizarProvaPDF.style.css'

export class ProvaPDFScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      prova: null,
      idProva: localStorage.getItem('idParaPDF')
    }
  }

  async componentDidMount(){
    try{
      const response = await retornaProvaCorrigidaParaPDF(this.state.idProva)
      this.setState({ prova: response })
    } catch(error){
      if (error.response.data.errors) {
        error.response.data.errors.map(message => {
          return Notificacao('Falha', `${message.defaultMessage}`, 'warning')
        })
      } else {
        Notificacao('Falha', `${error.response.data.message}`, 'danger')
      }
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
