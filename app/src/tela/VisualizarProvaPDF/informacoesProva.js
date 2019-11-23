import React from 'react';
import { Text, View, StyleSheet } from '@react-pdf/renderer';

const styles = StyleSheet.create({
  infosContainer: {
    flexDirection: "column",
    justifyContent: "flex-start",
    width: 600,
    marginTop: 15,
    borderLeftColor: '#FBB041',
    borderLeftStyle: "solid",
    borderLeftWidth: 1,
    paddingLeft: 10
  },
  infosLinha: {
    flexDirection: "row",
    paddingBottom: 2,
    fontSize: 14
  },
  infosNome: {
    fontWeight: 'black',
    color: 'black',
    textDecoration: 'none',
    opacity: 50
  },
  infosConteudo: {
    fontWeight: 'normal',
    color: 'gray',
    marginLeft: 5
  }
})

const Informacoes = (props) => (
  <View style={styles.infosContainer}>
    <View style={styles.infosLinha}>
      <View>
        <Text style={styles.infosNome}>Nome:</Text>
      </View>
      <Text style={styles.infosConteudo}>{props.nomeCandidato}</Text>
    </View>
    <View style={styles.infosLinha}>
      <Text style={styles.infosNome}>Email:</Text>
      <Text style={styles.infosConteudo}>{props.emailCandidato}</Text>
    </View>
    <View style={styles.infosLinha}>
      <Text style={styles.infosNome}>Data:</Text>
      <Text style={styles.infosConteudo}>{props.data}</Text>
    </View>
    <View style={styles.infosLinha}>
      <Text style={styles.infosNome}>Tempo de duração:</Text>
      <Text style={styles.infosConteudo}>{props.duracao}</Text>
    </View>
    <View style={styles.infosLinha}>
      <Text style={styles.infosNome}>Nota:</Text>
      <Text style={styles.infosConteudo}>{props.nota}</Text>
    </View>
  </View>
);

export default Informacoes;
