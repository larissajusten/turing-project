import React, { Component } from 'react';
import './responderMultiplasRespostas.style.css'
import { BlocoQuestao, BotaoAlternativa } from '../../'

export class RespondeQuestaoMultiplasRespostas extends Component {
  render() {
    return(
      <div className="container-questoes-resposta">
        <BlocoQuestao
          questaoNome="Questão"
          questao={this.props.questao}/>

        <BotaoAlternativa
          nome="A"
          conteudo={this.props.alternativaA.resposta}
          comId={true}
          tipo={this.props.tipo}
          idQuestao={this.props.idQuestao}
          idAlternativa={this.props.alternativaA.idAlternativa}
          index={this.props.index}
          onClick={this.props.onClick}
          classeConteudo="selecionar-alternativa"/>

        <BotaoAlternativa
          nome="B"
          conteudo={this.props.alternativaB.resposta}
          comId={true}
          tipo={this.props.tipo}
          idQuestao={this.props.idQuestao}
          idAlternativa={this.props.alternativaB.idAlternativa}
          index={this.props.index}
          onClick={this.props.onClick}
          classeConteudo="selecionar-alternativa"/>

        <BotaoAlternativa
          nome="C"
          conteudo={this.props.alternativaC.resposta}
          comId={true}
          tipo={this.props.tipo}
          idQuestao={this.props.idQuestao}
          idAlternativa={this.props.alternativaC.idAlternativa}
          index={this.props.index}
          onClick={this.props.onClick}
          classeConteudo="selecionar-alternativa"/>

        <BotaoAlternativa
          nome="D"
          conteudo={this.props.alternativaD.resposta}
          comId={true}
          tipo={this.props.tipo}
          idQuestao={this.props.idQuestao}
          idAlternativa={this.props.alternativaD.idAlternativa}
          index={this.props.index}
          onClick={this.props.onClick}
          classeConteudo="selecionar-alternativa"/>

        <BotaoAlternativa
          nome="E"
          conteudo={this.props.alternativaE.resposta}
          comId={true}
          tipo={this.props.tipo}
          idQuestao={this.props.idQuestao}
          idAlternativa={this.props.alternativaE.idAlternativa}
          index={this.props.index}
          onClick={this.props.onClick}
          classeConteudo="selecionar-alternativa"/>
      </div>
    )
  }
}
