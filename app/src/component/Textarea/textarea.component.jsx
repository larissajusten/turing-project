import React, { PureComponent } from 'react';

export class Textarea extends PureComponent {
  escolherOnChange() {
    if(this.props.comIndex) {
      return (event) => this.props.handleChange(event, this.props.index, this.props.idQuestao, this.props.tipo)
    }else if(this.props.comIdResposta) {
      return (event) => this.props.handleChange(event, this.props.index, this.props.idQuestao, this.props.idResposta, this.props.tipo)
    }else {
      return this.props.handleChange
    }
  }

  render() {
    return(
      <>
      <label className="label">{this.props.label}</label>
        <textarea
          className={`questao ${this.props.classe}`}
          name={this.props.name}
          value={this.props.value}
          onChange={this.escolherOnChange()}
          maxLength="500"
          type="textarea"
          label={this.props.labeltextarea}
          placeholder={this.props.placeholder}
          required/>
      </>
    )
  }
}
