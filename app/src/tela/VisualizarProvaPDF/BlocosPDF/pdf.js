import React from 'react';
import { Document, Page, Text, View } from '@react-pdf/renderer';
import { Informacoes,
  BlocoQuestaoTecnica,
  BlocoQuestaoDissertativa,
  BlocoQuestaoMultiplaEscolha, styles } from './'

export const MyDocument = (props) => (
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

        {
          props.prova.questoesTecnicas.length > 0 &&
          <BlocoQuestaoTecnica questoes={props.prova.questoesTecnicas}/>
        }
        {
          props.prova.questoesDissertativas.length > 0 &&
          <BlocoQuestaoDissertativa questoes={props.prova.questoesDissertativas}/>
        }
        {
          props.prova.questoesMultiplaEscolha.length > 0 &&
          <BlocoQuestaoMultiplaEscolha questoes={props.prova.questoesMultiplaEscolha}/>
        }
      </View>
    </Page>
  </Document>
);
