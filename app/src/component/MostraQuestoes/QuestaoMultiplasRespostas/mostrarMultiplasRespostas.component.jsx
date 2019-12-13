import React, { Component } from 'react'
import './mostrarMultiplasRespostas.style.css'
import { BotaoAdicionar, BlocoVisualizar, BlocoQuestao } from '../../'

export class MostrarMultiplasRespostas extends Component {

  render() {
    return (
      <div className="container-questao-multipla-escolha">
        <div className="primeira-div">

          <BlocoQuestao
            widthpergunta={"width-questao"}
            questaoNome={this.props.questaoNome}
            questao={this.props.questao}/>

          <BotaoAdicionar className="botao-remover" nome="-" adicionar={false} onClick={this.props.onClick} id={this.props.id} />
        </div>

        <div className="container-alternativas">
          <div className="coluna">
            <BlocoVisualizar
              nome="Alternativa A"
              conteudo={this.props.alternativaA} />

            <BlocoVisualizar
              nome="Alternativa B"
              conteudo={this.props.alternativaB} />

            <BlocoVisualizar
              nome="Alternativa C"
              conteudo={this.props.alternativaC} />

            <BlocoVisualizar
              nome="Alternativa D"
              conteudo={this.props.alternativaD} />

            <BlocoVisualizar
              nome="Alternativa E"
              conteudo={this.props.alternativaE} />
          </div>
          <div className="coluna">
            <div className="container-especificacoes">
              <div className="container-especificacao-mult">
                <label className="especificacao-nome">Nivel</label>
                <div className="especificacao">{this.props.nivel}</div>
              </div>
            </div>

            <div className="container-especificacoes">
              <div className="container-especificacao-mult">
                <label className="especificacao-nome">Resposta correta</label>
                <div className="especificacao">{this.props.respostaCorreta}</div>
              </div>

              <div className="container-especificacao-mult">
                <label className="especificacao-nome">Especificidade</label>
                <div className="especificacao">{this.props.especificidade}</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    )
  }
}
