import React, { Component } from 'react';
import './responderMultiplasRespostas.style.css'
import { BlocoQuestao, BlocoVisualizar } from '../../index'

export class RespondeQuestaoMultiplasRespostas extends Component {
  render() {
    return(
      <div className="container-questoes-resposta">
        <BlocoQuestao
          questaoNome="Questão"
          questao={this.props.questao}/>

        <BlocoVisualizar 
          nome="A"
          conteudo={this.props.conteudoAlternativaA}
          comId={true}
          idQuestao={this.props.idQuestao}
          idAlternativa={this.props.idAlternativa}
          index={this.props.index}
          onClick={this.props.onClick}
          classeConteudo="selecionar-alternativa"/>

        <BlocoVisualizar 
          nome="B"
          conteudo={this.props.conteudoAlternativaB}
          comId={true}
          idQuestao={this.props.idQuestao}
          idAlternativa={this.props.idAlternativa}
          index={this.props.index}
          onClick={this.props.onClick}
          classeConteudo="selecionar-alternativa"/>

        <BlocoVisualizar 
          nome="C"
          conteudo={this.props.conteudoAlternativaC}
          comId={true}
          idQuestao={this.props.idQuestao}
          idAlternativa={this.props.idAlternativa}
          index={this.props.index}
          onClick={this.props.onClick}
          classeConteudo="selecionar-alternativa"/>

        <BlocoVisualizar 
          nome="D"
          conteudo={this.props.conteudoAlternativaD}
          comId={true}
          idQuestao={this.props.idQuestao}
          idAlternativa={this.props.idAlternativa}
          index={this.props.index}
          onClick={this.props.onClick}
          classeConteudo="selecionar-alternativa"/>

        <BlocoVisualizar 
          nome="E"
          conteudo={this.props.conteudoAlternativaE}
          comId={true}
          idQuestao={this.props.idQuestao}
          idAlternativa={this.props.idAlternativa}
          index={this.props.index}
          onClick={this.props.onClick}
          classeConteudo="selecionar-alternativa"/>
      </div>
    )
  }
}