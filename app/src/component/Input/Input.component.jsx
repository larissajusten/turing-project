import React, { Component } from 'react';
import './style.css';

export class Input extends Component {
	render() {
		return (
			<div className="input-principal">
				<label className="label">{this.props.label}</label>
                <input className="input"
                    type={this.props.type} placeholder={this.props.placeholder} />
			</div>
		);
	}
}
