import React, { Component } from 'react';
import { Document, Page, Text, View, StyleSheet, PDFViewer } from '@react-pdf/renderer';
import './visualizarProvaPDF.style.css'
import ProvaTeste from './provaTeste'

export class ProvaPDFScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      prova: ProvaTeste
    }
  }

  render() {
    return(
      <div className="container-pdf">
      <PDFViewer width="100%" height="540">
        <MyDocument prova={this.state.prova} />
      </PDFViewer>
      </div>
    )
  }
}

const styles = StyleSheet.create({
  page: {
    flexDirection: 'row',
    backgroundColor: '#E4E4E4'
  },
  section: {
    alignItems: 'center',
    margin: 10,
    padding: 10,
    flexGrow: 1
  }
});

// Create Document Component
const MyDocument = (props) => (
  <Document title={`Relatório da prova ${props.prova.nomeCandidato}`} >
    <Page size="A4" style={styles.page}>
      <View style={styles.section}>
        <Text>Relatório da prova do candidato {props.prova.nomeCandidato}</Text>
      </View>
    </Page>
  </Document>
);
