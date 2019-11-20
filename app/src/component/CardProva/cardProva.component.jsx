import React, { PureComponent } from 'react'

export class CardProva extends PureComponent {

  render() {
    return (
      <div className="container-card" onClick={(event) => this.props.onClick(event, this.props.id)}>
        <div className="content-card">
          <div className="infos-postagem">
              <span>{this.props.informacaoUm}</span>
              <span>{this.props.informacaoDois}</span>
              <span>{this.props.informacaoTres}</span>
          </div>
        </div>
      </div>
    )
  }
}
