import React, { Component } from 'react';
import { slide as Menu } from 'react-burger-menu'
import { Link } from 'react-router-dom';
import './style.css';

export class Header extends Component {

	render() {

		return (
			<div className="header">
				<span className="menu-header" onClick={this.handleClickShowMenu}>MENU</span>
				<Menu width={'250px'}>
					<Link to="/">Home</Link>
					<Link to={"/cadastrar-questao"}>Cadastrar</Link>
					<Link to={"/buscar-questao"}>Buscar</Link>
					<Link to="/">Prova</Link>
				</Menu>
			</div>
		)
	}

}
