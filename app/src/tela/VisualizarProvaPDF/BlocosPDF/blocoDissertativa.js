import React from 'react';
import { Text, View } from '@react-pdf/renderer';
import { styles } from './index'

export const BlocoQuestaoDissertativa = (props) => (
  props.questoes.map((item, key) => {
    return <View style={styles.containerUnicaResposta} key={key}>
            <View style={styles.containerTipo}>
              <Text style={styles.tipo}>DISSERTATIVA</Text>
            </View>
            <View style={styles.containerQuestao}>
              <Text style={styles.questao}>{item.questao}</Text>
            </View>
            <View style={styles.containerResposta}>
              <Text style={styles.tipoQuestao}>Resposta dissertativa:</Text>
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
