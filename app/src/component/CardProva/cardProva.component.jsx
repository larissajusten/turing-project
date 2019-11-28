import React, { Component } from 'react'
import './cardProva.style.css'
import { BotaoPrincipal } from '../index'

export class CardProva extends Component {

  render() {
    return (
      <div className="container-card">
        <div className="content-card">
          <div>
            <span>Nome do candidato:</span>
            <span>{this.props.informacaoUm}</span>
          </div>
          <div>
            <span>E-mail do candidato:</span>
            <span>{this.props.informacaoDois}</span>
          </div>
          <div>
            <span>Duração:</span>
            <span>{this.props.informacaoTres}</span>
          </div>
        </div>
        {
            this.props.paraCorrigir &&
            <>
            <div className="container-linguagens-card-prova">
              {
                this.props.especificidades.map((item, key) => {
                  const image = require(`../../assets/images-questoes/${item}.png`);
                  return <img className="imagem-linguagem-card-prova" src={image} alt="linguagem"/>
                })
              }
            </div>
            </>
          }
        <BotaoPrincipal classe="tamanho-botao" nome={this.props.nomeBotao} onClick={(event) => this.props.onClick(event, this.props.id)}/>
      </div>
    )
  }
}
