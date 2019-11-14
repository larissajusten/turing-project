import React, { PureComponent } from 'react';
import './radioButton.style.css';

export class RadioButton extends PureComponent {
  render() {
    return (
      <>
      <div className="buttonRadio">
        <input type="radio" name={this.props.name} value={this.props.value} onClick={this.props.onClick}/>
        A
      </div>
      <div className="buttonRadio">
        <input type="radio" name={this.props.name} value={this.props.value} onClick={this.props.onClick}/>
        B
      </div>
      <div className="buttonRadio">
        <input type="radio" name={this.props.name} value={this.props.value} onClick={this.props.onClick}/>
        C
      </div>
      <div className="buttonRadio">
        <input type="radio" name={this.props.name} value={this.props.value} onClick={this.props.onClick}/>
        D
      </div>
      <div className="buttonRadio">
        <input type="radio" name={this.props.name} value={this.props.value} onClick={this.props.onClick}/>
        E
      </div>
      </>
    )
  }
}