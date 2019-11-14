import React, { Component } from 'react';
import './style.css';

export class Input extends Component {
	render() {
		return (
			<div className="input-principal">
				<label className="label">{this.props.label}</label>
				<input
					className={this.props.className}
					type={this.props.type}
					placeholder={this.props.placeholder}
					name={this.props.name}
					value={this.props.value}
					onChange={this.props.onChange}
					required
				/>
			</div>
		);
	}
}
