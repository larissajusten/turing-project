import React, { Component } from 'react';
import { slide as Menu } from 'react-burger-menu'
import { Link } from 'react-router-dom';
import './header.style.css';

export class Header extends Component {
	constructor(props){
		super(props)
		this.state = {
			perfil: localStorage.getItem('perfilUsuario')
		}
	}

	componentDidMount(){
		localStorage.removeItem('perfilUsuario')
	}

	render() {

		return (
			<div className="header">
				<span className="menu-header" onClick={this.handleClickShowMenu}>MENU</span>
				<Menu width={'250px'}>
					<Link to={"/"}>Home</Link>
					<Link to={"/cadastrar-questao"}>Cadastrar questão</Link>
					<Link to={"/buscar-questao"}>Visualizar questões</Link>
					<Link to={"/cadastrar-prova"}>Cadastrar prova</Link>
					<Link to={"/buscar-provas"}>Busca para correção</Link>
					<Link to={"/provas-corrigidas"}>Provas corrigidas</Link>
				</Menu>
			</div>
		)
	}

}
