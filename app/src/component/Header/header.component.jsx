import React, { Component } from 'react';
import { slide as Menu } from 'react-burger-menu'
import { Link } from 'react-router-dom';
import './header.style.css';

export class Header extends Component {

	render() {

		return (
			<div className="header">
				<span className="menu-header" onClick={this.handleClickShowMenu}>MENU</span>
				<Menu width={'250px'}>
					<Link to="/">Home</Link>
					<Link to={"/cadastrar-questao"}>Cadastrar questão</Link>
					<Link to={"/buscar-questao"}>Visualizar questões</Link>
					<Link to={"/cadastrar-prova"}>Cadastrar prova</Link>
					<Link to={"/visualizar-prova"}>Visualizar prova</Link>
					<Link to={"/resolver-prova"}>Resolver prova</Link>
					<Link to={"/buscar-provas"}>Busca para correção</Link>
					<Link to={"/corrigir-prova"}>Corrigir prova</Link>
					<Link to={"/provas-corrigidas"}>Provas corrigidas</Link>
					<Link to={"/prova-PDF"}>Provas para PDF</Link>
				</Menu>
			</div>
		)
	}

}
