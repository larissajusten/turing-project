import React from 'react';
import { Text, View } from '@react-pdf/renderer';
import { styles } from './index'

export const BlocoNota = (props) => {
  return <View style={styles.containerNota}>
          <Text style={styles.nota}>{props.nota}</Text>
          <Text style={styles.notaTxt}>Nota</Text>
        </View>
}