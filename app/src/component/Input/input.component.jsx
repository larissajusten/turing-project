import React, { Component } from 'react';
import './input.style.css';

export class Input extends Component {
	render() {
		return (
			<div className={`input-principal ${this.props.classNameDiv}`}>
				<label className="label">{this.props.label}</label>
				<input
					className= {`input ${this.props.className}`}
					type={this.props.type ? this.props.type : 'text'}
					placeholder={this.props.placeholder}
					name={this.props.name}
					minLength={this.props.minTam}
					maxLength={this.props.maxTam}
					min={this.props.minNum}
					max={this.props.maxNum}
					value={this.props.value}
					onChange={this.props.cadastro ? (event) => this.props.onChange(event, this.props.index) : 
										(this.props.comIndex ? (event) => this.props.onChange(event, this.props.index, this.props.idQuestao, this.props.tipo) : 
										(this.props.comIdResposta ? (event) => this.props.onChange(event, this.props.index, this.props.idQuestao, this.props.idResposta, this.props.tipo)
										: this.props.onChange ))}
					required
				/>
			</div>
		);
	}
}
