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
              <Text style={item.alternativasMultiplaEscolhas[0].respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`1. valueO`}
              </Text>
              <Text style={item.alternativasMultiplaEscolhas[1].respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`2. ${item.alternativasMultiplaEscolhas[1].resposta}`}
              </Text>
              <Text style={item.alternativasMultiplaEscolhas[2].respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`3. ${item.alternativasMultiplaEscolhas[2].resposta}`}
              </Text>
              <Text style={item.alternativasMultiplaEscolhas[3].respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`4. ${item.alternativasMultiplaEscolhas[3].resposta}`}
              </Text>
              <Text style={item.alternativasMultiplaEscolhas[4].respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
                {`5. ${item.alternativasMultiplaEscolhas[4].resposta}`}
              </Text>
            </View>
            <BlocoComentario comentario={item.comentario}/>
          </View>
  })
);

/*
  item.alternativasMultiplaEscolhas.map((resposta, key) => {
    return <Text key={key} 
                  style={resposta.respostaCorreta ? styles.respostaCorreta : styles.respostaMultiplaEscolha}>
              {`${key}. ${resposta.resposta}`}
          </Text>
  })
*/
