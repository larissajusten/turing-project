import React, { PureComponent } from 'react';
import './select.style.css';

export class Select extends PureComponent {
	render() {
		return (
			<select className= {`select ${this.props.questoesWidth}`}
							onChange={this.props.selectCadastro ? (event) => this.props.onChange(event, this.props.id) : this.props.onChange}
							value={this.props.text}
							name={this.props.name}
							required>

				<option className="placeholder" hidden>
					{this.props.placeholder}
				</option>

				{
					this.props.object.map((item, key) => {
						return <option key={key}>{item}</option>;
					})
				}
			</select>
		);
	}
}
