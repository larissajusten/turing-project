import React from 'react';
import { Text, View } from '@react-pdf/renderer';
import { styles } from './'

export const BlocoComentario = (props) => {
  return <View style={styles.containerComentario}>
          <Text style={styles.comentarioTxt}>Comentário:</Text>
          <Text style={styles.comentario}>{props.comentario}</Text>
        </View>
}
