import React, { Component } from 'react';
import './textarea.style.css'

export class Textarea extends Component {
  render() {
    return(
      <>
      <label className="label">{this.props.label}</label>
        <textarea
          className={`questao ${this.props.classe}`}
          name={this.props.name}
          value={this.props.value}
          onChange={this.props.comIndex ? (event) => this.props.handleChange(event, this.props.index, this.props.idQuestao) : this.props.handleChange}
          maxLength={this.props.maxLength}
          type="textarea"
          label={this.props.labeltextarea}
          placeholder={this.props.placeholder}
          required/>
      </>
    )
  }
}