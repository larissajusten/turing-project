import React from 'react';
import { Text, View, StyleSheet } from '@react-pdf/renderer';

const borderRadiusBloquinhos = 2;
const borderRadiusBlocosGandes = 5;

// const colorNivel = (tipo) => {
//   if(tipo = 'FACIL'){
//     return '#25E015'
//   }else if(tipo = 'MEDIO'){
//     return '#E0D815'
//   }else{
//     return '#E01515'
//   }
// } 

const styles = StyleSheet.create({
  container: {
    alignSelf: "flex-start",
    flexDirection: "column",
    width: 550,
    height: 200,
    marginTop: 15,
    paddingTop: 8,
    paddingLeft: 15,
    borderColor: '#E1DDDD',
    borderStyle: "solid",
    borderWidth: 2,
    borderRadius: borderRadiusBlocosGandes,
    position: 'relative'
  },
  containerEspecificidade: {
    position: 'absolute',
    top: 8,
    right: 10,
    borderColor: '#FBB041',
    borderStyle: "solid",
    borderWidth: 1,
    borderRadius: borderRadiusBloquinhos,
    width: 70,
    alignItems: 'center',
    justifyContent: 'center'
  },
  especificidade: {
    fontSize: 10,
    color: '#FBB041'
  },
  containerNivel: {
    position: 'absolute',
    top: 8,
    right: 85,
    borderColor: '#25E015',
    borderStyle: "solid",
    borderWidth: 1,
    borderRadius: borderRadiusBloquinhos,
    width: 40,
    alignItems: 'center',
    justifyContent: 'center'
  },
  nivel: {
    fontSize: 10,
    color: '#25E015'
  },
  containerTipo: {
    position: 'absolute',
    top: 8,
    right: 130,
    borderColor: 'black',
    borderStyle: "solid",
    borderWidth: 1,
    borderRadius: borderRadiusBloquinhos,
    width: 50,
    alignItems: 'center',
    justifyContent: 'center'
  },
  tipo: {
    fontSize: 10,
    color: 'black'
  },
  containerQuestao: {
    height: 60,
    width: 400
  },
  questao: {
    fontWeight: 'black',
    fontSize: 14,
    color: 'black',
    textDecoration: 'none'
  },
  containerResposta: {
    height: 60,
    width: 400
  },
  tipoQuestao: {
    fontWeight: 'black',
    fontSize: 12,
    color: 'black',
    textDecoration: 'none'
  },
  resposta: {
    fontWeight: 'thin',
    fontSize: 10,
    color: 'black',
    textDecoration: 'none',
    paddingTop: 2
  },
  containerComentario: {
    height: 60,
    width: 400
  },
  comentarioTxt: {
    fontWeight: 'black',
    fontSize: 12,
    color: 'black',
    textDecoration: 'none'
  },
  comentario: {
    fontWeight: 'thin',
    fontSize: 10,
    color: 'black',
    textDecoration: 'none',
    paddingTop: 2
  },
  containerNota: {
    position: 'absolute',
    right: 15,
    bottom: 8,
    height: 50,
    width: 50,
    border: 1,
    borderRadius: 50,
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center'
  },
  notaTxt: {
    fontWeight: 'thin',
    fontSize: 12,
    color: 'black',
    textDecoration: 'none'
  }
})

const BlocoQuestaoTecnica = (props) => (
  props.questoes.map((item, key) => {
    return <View style={styles.container} key={key}>
            <View style={styles.containerEspecificidade}>
              <Text style={styles.especificidade}>{item.especificidade}</Text>
            </View>
            <View style={styles.containerNivel}>
              <Text style={styles.nivel}>{item.nivelDeDificuldade}</Text>
            </View>
            <View style={styles.containerTipo}>
              <Text style={styles.tipo}>TÉCNICA</Text>
            </View>
            <View style={styles.containerQuestao}>
              <Text style={styles.questao}>{item.questao}</Text>
            </View>
            <View style={styles.containerResposta}>
              <Text style={styles.tipoQuestao}>Resposta técnica:</Text>
              <Text style={styles.resposta}>{item.resposta}</Text>
            </View>
            <View style={styles.containerComentario}>
              <Text style={styles.comentarioTxt}>Comentário:</Text>
              <Text style={styles.comentario}>{item.comentario}</Text>
            </View>
            <View style={styles.containerNota}>
              <Text style={styles.nota}>{item.nota}</Text>
              <Text style={styles.notaTxt}>Nota</Text>
            </View>
          </View>
  })
);

export default BlocoQuestaoTecnica;
