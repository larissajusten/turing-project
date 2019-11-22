import React, { Component } from 'react';
import { Document, Page, Text, View, StyleSheet, PDFViewer } from '@react-pdf/renderer';

export class ProvaPDFScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      prova: []
    }
  }

  render() {
    return(
      <>
      <PDFViewer>
        <MyDocument />
      </PDFViewer>
      </>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    width: '1000px'
  }, 
  page: {
    flexDirection: 'row',
    backgroundColor: '#E4E4E4'
  },
  section: {
    margin: 10,
    padding: 10,
    flexGrow: 1
  }
});

// Create Document Component
const MyDocument = () => (
  <Document style={styles.container} >
    <Page size="A4" style={styles.page}>
      <View style={styles.section}>
        <Text>Section #1</Text>
      </View>
      <View style={styles.section}>
        <Text>Section #2</Text>
      </View>
    </Page>
  </Document>
);
