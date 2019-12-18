import React from 'react';
import { Text, View } from '@react-pdf/renderer';
import { styles, BlocoNota } from './'

const verificarResposta = (resposta, respostaEscolhidaPeloUsuario) => {
  if((resposta.id === respostaEscolhidaPeloUsuario.id) && resposta.respostaCorreta){
    return styles.respostaCorreta
  }else if(resposta.id === respostaEscolhidaPeloUsuario.id){
    return styles.respostaErrada
  }else if(resposta.respostaCorreta){
    return styles.respostaCorreta
  }else{
    return styles.respostaMultiplaEscolha
  }
}

export const BlocoQuestaoMultiplaEscolha = (props) => (
  props.questoes.map((item, key) => {
    return <View style={styles.container} key={key}>
            <View style={styles.containerEspecificidade}>
              <Text style={styles.especificidade}>{item.especificidade}</Text>
            </View>
            <View style={styles.containerTipoMultipla}>
              <Text style={styles.tipo}>MULTIPLA ESCOLHA</Text>
            </View>
            <View style={styles.containerQuestao}>
              <Text style={styles.questao}>{item.questao}</Text>
            </View>
            <View style={styles.containerRespostaMultiplaEscolha}>
              {
                item.alternativasMultiplaEscolhas.map((resposta, key) => {
                  return <Text key={key}
                                style={verificarResposta(resposta, item.resposta)}>
                            {`${key}. ${resposta.resposta}`}
                        </Text>
                })
              }
            </View>
            <BlocoNota nota={item.nota}/>
          </View>
  })
);
