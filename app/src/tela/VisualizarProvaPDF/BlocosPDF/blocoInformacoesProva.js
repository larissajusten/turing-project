import React from 'react';
import { Text, View } from '@react-pdf/renderer';
import { styles } from './index'

export const Informacoes = (props) => (
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
