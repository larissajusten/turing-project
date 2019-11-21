import React, { PureComponent } from 'react';

export class Textarea extends PureComponent {
  render() {
    return(
      <>
      <label className="label">{this.props.label}</label>
        <textarea
          className={`questao ${this.props.classe}`}
          name={this.props.name}
          value={this.props.value}
          onChange={this.props.comIndex ? (event) => this.props.handleChange(event, this.props.index, this.props.idQuestao, this.props.tipo) : this.props.handleChange}
          maxLength="500"
          type="textarea"
          label={this.props.labeltextarea}
          placeholder={this.props.placeholder}
          required/>
      </>
    )
  }
}
