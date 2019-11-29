import React from 'react';
import { Text, View } from '@react-pdf/renderer';
import { styles, BlocoComentario } from './index'

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
                                  style={resposta.respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                              {`${key}. ${resposta.resposta}`}
                          </Text>
                  })
              }
            </View>
            <BlocoComentario comentario={item.comentario}/>
          </View>
  })
);
