import React, { PureComponent } from 'react'
import './cardQuestao.style.css'

export class CardQuestao extends PureComponent {

  render() {
    return (
        <div className="container-card">

            <div className="content-postagem">
                <div className="publicada">
                    {this.props.questao}
                </div>

                <div className="infos-postagem">
                    <span>{this.props.especificidade}</span>
                    <span>{this.props.nivel}</span>
                    <span>{this.props.data}</span>
                </div>
            </div>

        </div>
    )
  }
}
