import { StyleSheet } from '@react-pdf/renderer';

const borderRadiusBloquinhos = 2;
const borderRadiusBlocosGandes = 5;

export const styles = StyleSheet.create({
  container: {
    alignSelf: "flex-start",
    flexDirection: "column",
    width: 550,
    height: 250,
    marginTop: 15,
    paddingTop: 8,
    paddingLeft: 15,
    borderColor: '#E1DDDD',
    borderStyle: "solid",
    borderWidth: 2,
    borderRadius: borderRadiusBlocosGandes,
    position: 'relative'
  },
  containerUnicaResposta: {
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
  containerQuestao: {
    height: 80,
    width: 400
  },
  questao: {
    fontWeight: 'black',
    fontSize: 10,
    color: 'black',
    textDecoration: 'none'
  },
  containerResposta: {
    height: 60,
    width: 400
  },
  containerRespostaMultiplaEscolha: {
    height: 100,
    width: 500
  },
  tipoQuestao: {
    fontWeight: 'black',
    fontSize: 12,
    color: 'black',
    paddingLeft: 3,
    borderLeft: 1,
    borderLeftWidth: 1,
    borderLeftStyle: 'solid',
    borderLeftColor: '#fbb041',
    textDecoration: 'none'
  },
  resposta: {
    fontWeight: 'thin',
    fontSize: 10,
    color: 'black',
    textDecoration: 'none',
    paddingTop: 2
  },
  respostaMultiplaEscolha: {
    fontWeight: 'thin',
    fontSize: 12,
    color: 'black',
    textDecoration: 'none',
    marginBottom: 5
  },
  containerComentario: {
    height: 40,
    width: 400
  },
  comentarioTxt: {
    fontWeight: 'black',
    fontSize: 12,
    color: 'black',
    paddingLeft: 3,
    borderLeft: 1,
    borderLeftWidth: 1,
    borderLeftStyle: 'solid',
    borderLeftColor: '#fbb041',
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
  },
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
  },
  containerTipo: {
    position: 'absolute',
    top: 8,
    right: 10,
    borderColor: 'black',
    borderStyle: "solid",
    borderWidth: 1,
    borderRadius: borderRadiusBloquinhos,
    width: 90,
    alignItems: 'center',
    justifyContent: 'center'
  },
  tipo: {
    fontSize: 10,
    color: 'black'
  },
  respostaCorreta: {
    fontWeight: 'thin',
    fontSize: 12,
    color: '#25E015',
    textDecoration: 'none',
    marginBottom: 5,
  },
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
})
