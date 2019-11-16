import React, { Component } from 'react';
import './input.style.css';

export class Input extends Component {
	render() {
		return (
			<div className={`input-principal ${this.props.className}`}>
				<label className="label">{this.props.label}</label>
				<input
					className= {`input ${this.props.className}`}
					type={this.props.type ? this.props.type : 'text'}
					placeholder={this.props.placeholder}
					name={this.props.name}
					value={this.props.value}
					onChange={this.props.cadastro ? () => this.props.onChange(this.props.id) : this.props.onChange}
					required
				/>
			</div>
		);
	}
}
