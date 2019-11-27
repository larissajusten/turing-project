import React from 'react';
import { Text, View } from '@react-pdf/renderer';
import { styles, BlocoComentario, BlocoNota } from './index'

export const BlocoQuestaoTecnica = (props) => (
  props.questoes.map((item, key) => {
    return <View style={styles.containerUnicaResposta} key={key}>
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
            <BlocoComentario comentario={item.comentario}/>
            <BlocoNota nota={item.nota}/>
          </View>
  })
);
