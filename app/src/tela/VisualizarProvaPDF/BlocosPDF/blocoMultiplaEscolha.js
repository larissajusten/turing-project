import React from 'react';
import { Text, View } from '@react-pdf/renderer';
import { styles, BlocoComentario } from './index'

export const BlocoQuestaoMultiplaEscolha = (props) => (
  props.questoes.map((item, key) => {
    console.log(item)
    return <View style={styles.container} key={key}>
            <View style={styles.containerEspecificidade}>
              <Text style={styles.especificidade}>{item.especificidade}</Text>
            </View>
            <View style={styles.containerNivel}>
              <Text style={styles.nivel}>{item.nivelDeDificuldade}</Text>
            </View>
            <View style={styles.containerTipo}>
              <Text style={styles.tipo}>MULTIPLA ESCOLHA</Text>
            </View>
            <View style={styles.containerQuestao}>
              <Text style={styles.questao}>{item.questao}</Text>
            </View>
            <View style={styles.containerRespostaMultiplaEscolha}>
              {
                item.alternativasMultiplasEscolhas.map((resposta, key) => {
                  return <Text style={resposta.respostaCorreta ? styles.respostaCorreta : (item.resposta.id === resposta.id ? styles.respostaCorreta : styles.respostaMultiplaEscolha)}>
                          {`${key}. ${resposta.resposta}`}
                        </Text>
                })
              }
            </View>
            <BlocoComentario comentario={item.comentario}/>
          </View>
  })
);
