import React from 'react';
import { Text, View } from '@react-pdf/renderer';
import { styles } from './index'

export const BlocoQuestaoMultiplaEscolha = (props) => (
  props.questoes.map((item, key) => {
    return <View style={styles.container} key={key}>
            <View style={styles.containerTipo}>
              <Text style={styles.tipo}>MULTIPLA ESCOLHA</Text>
            </View>
            <View style={styles.containerQuestao}>
              <Text style={styles.questao}>{item.questao}</Text>
            </View>
            <View style={styles.containerRespostaMultiplaEscolha}>
              <Text style={item.alternativaA.respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`1. ${item.alternativaA.resposta}`}
              </Text>
              <Text style={item.alternativaB.respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`1. ${item.alternativaB.resposta}`}
              </Text>
              <Text style={item.alternativaC.respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`1. ${item.alternativaC.resposta}`}
              </Text>
              <Text style={item.alternativaD.respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`1. ${item.alternativaD.resposta}`}
              </Text>
              <Text style={item.alternativaE.respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`1. ${item.alternativaE.resposta}`}
                </Text>
            </View>
            <View style={styles.containerComentario}>
              <Text style={styles.comentarioTxt}>Comentário:</Text>
              <Text style={styles.comentario}>{item.comentario}</Text>
            </View>
          </View>
  })
);
