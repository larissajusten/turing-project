import React, { PureComponent } from 'react'
import './renderQuestaoUnica.style.css'

export class renderQuestaoUnica extends PureComponent {
  render() {
    return(
      <div className="container-questao-unica">

        <div className="container-pergunta-questao">
          <span>Questão</span>
          <div className="content-pergunta">
            {this.props.questao}
          </div>
        </div>

        <div>
          <div className="container-especificacao">
            {this.props.nivel}
            <span>Nivel</span>
          </div>

          <div className="container-especificacao">
            {this.props.especificidade}
            <span>Especificidade</span>
          </div>
        </div>

        

      </div>
    )
  }
}