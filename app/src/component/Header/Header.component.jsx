import React, { Component } from 'react';
import './style.css';

export class Header extends Component {

	render() {

		return (
			<div className="header">
				<span className="menu-header" onClick={this.handleClickShowMenu}>MENU</span>
			</div>
		)
	}

}
