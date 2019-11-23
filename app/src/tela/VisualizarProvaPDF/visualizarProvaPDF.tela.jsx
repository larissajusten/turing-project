import React, { Component } from 'react';
import { Document, Page, Text, View, StyleSheet, PDFViewer } from '@react-pdf/renderer';
import './visualizarProvaPDF.style.css'
import Informacoes from './informacoesProva'
import BlocoQuestaoTecnica from './blocoTecnica'
import BlocoQuestaoDissertativa from './blocoDissertativa'
import BlocoQuestaoMultiplaEscolha from './blocoMultiplaEscolha'
import { Notificacao } from '../../component/index'
import { retornaProvaParaPDF } from '../../services/index'

const styles = StyleSheet.create({
  titulo: {
    color: '#FBB041'
  },
  page: {
    flexDirection: 'row',
    backgroundColor: '#FFFFFF'
  },
  section: {
    alignItems: 'center',
    margin: 10,
    padding: 10,
    flexGrow: 1
  }
});

const MyDocument = (props) => (
  <Document title={`Relatório da prova ${props.prova.nomeCandidato}`} >
    <Page size="A4" style={styles.page}>
      <View style={styles.section}>
        <Text style={styles.titulo}>Relatório da prova de {props.prova.nomeCandidato}</Text>
        <Informacoes 
          nomeCandidato={props.prova.nomeCandidato} 
          emailCandidato={props.prova.emailCandidato}
          data={props.prova.dataCriacao}
          duracao={props.prova.tempoDeDuracaoDaProva}
          nota={props.prova.nota}
          />
        <BlocoQuestaoTecnica questoes={props.prova.questoesTecnicas}/>
        <BlocoQuestaoDissertativa questoes={props.prova.questoesDissertativas}/>
        <BlocoQuestaoMultiplaEscolha questoes={props.prova.questoesDeMultiplaEscolha}/>
      </View>
    </Page>
  </Document>
);

export class ProvaPDFScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      prova: '',
      idProva: localStorage.getItem('idParaPDF')
    }
  }

  async componentDidMount(){
    try{
      const response = await retornaProvaParaPDF(this.state.idProva)
      this.setState({
        prova: response
      })
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
      <div className="container-pdf">
      <PDFViewer width="100%" height="100vh">
        <MyDocument prova={this.state.prova} />
      </PDFViewer>
      </div>
    )
  }
}
