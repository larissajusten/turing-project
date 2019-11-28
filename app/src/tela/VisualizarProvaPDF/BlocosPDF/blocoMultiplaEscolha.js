import React from 'react';
import { Text, View } from '@react-pdf/renderer';
import { styles, BlocoComentario } from './index'

export const BlocoQuestaoMultiplaEscolha = (props) => (
  props.questoes.map((item, key) => {
    console.log(item)
    return <View style={styles.container} key={key}>
            <View style={styles.containerTipo}>
              <Text style={styles.tipo}>MULTIPLA ESCOLHA</Text>
            </View>
            <View style={styles.containerQuestao}>
              <Text style={styles.questao}>{item.questao}</Text>
            </View>
            <View style={styles.containerRespostaMultiplaEscolha}>
              <Text style={item.resposta[0].respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`1. ${item.alternativaA.resposta}`}
              </Text>
              <Text style={item.resposta.respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`2. ${item.alternativaB.resposta}`}
              </Text>
              <Text style={item.resposta.respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`3. ${item.alternativaC.resposta}`}
              </Text>
              <Text style={item.resposta.respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`4. ${item.alternativaD.resposta}`}
              </Text>
              <Text style={item.resposta.respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`5. ${item.alternativaE.resposta}`}
                </Text>
            </View>
            <BlocoComentario comentario={item.comentario}/>
          </View>
  })
);
