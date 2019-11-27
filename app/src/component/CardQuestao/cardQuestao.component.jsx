import React, { PureComponent } from 'react'
import './cardQuestao.style.css'


export class CardBuscarQuestao extends PureComponent {
  returnColor() {
      if(this.props.nivel === this.props.niveis[0]){
          return "#00C49F"
      }else if(this.props.nivel === this.props.niveis[1]){
          return "#FFBB28"
      }else{
          return "#FF8042"
      }
  }
  render() {
    const image = require(`../../assets/images-questoes/${this.props.imagem}.png`);
    return (
        <div className={`container-card ${this.props.widthcardquestao}`}>
            <img className="imagem-linguagem" src={image} alt="linguagem"></img>
            <div className="content-postagem">
                <div className="publicada">
                    {this.props.questao}
                </div>

                <div className="infos-postagem">
                    <span className="nivel-questao" style={{borderColor: this.returnColor()}}>{this.props.nivel}</span>
                    <span>{(new Date(this.props.data)).toLocaleString()}
                    </span>
                </div>
            </div>

        </div>
    )
  }
}

//`../../assets/images-questoes/${this.props.imagem}.png`
