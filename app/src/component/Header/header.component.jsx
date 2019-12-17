import React, { Component } from 'react'
import { slide as Menu } from 'react-burger-menu'
import { Link } from 'react-router-dom'
import './header.style.css'

export class Header extends Component {
  constructor(props) {
    super(props)
    this.state = {
      menuAberto: false
    }
  }

  render() {
    return (
      <div className="header">
        <span
          className="menu-header"
          onClick={() => this.setState({ menuAberto: true })}>
          MENU
        </span>

        <Menu isOpen={this.state.menuAberto} width={'250px'}>
          <Link to={'/'}>Home</Link>
          <Link
            onClick={() => this.setState({ menuAberto: false })}
            to={'/cadastrar-questao'}>
            Cadastrar questão
          </Link>
          <Link
            onClick={() => this.setState({ menuAberto: false })}
            to={'/buscar-questao'}>
            Visualizar questões
          </Link>
          <Link
            onClick={() => this.setState({ menuAberto: false })}
            to={'/cadastrar-prova'}>
            Cadastrar prova
          </Link>
          <Link
            onClick={() => this.setState({ menuAberto: false })}
            to={'/buscar-provas'}>
            Busca para correção
          </Link>
          <Link
            onClick={() => this.setState({ menuAberto: false })}
            to={'/provas-corrigidas'}>
            Provas corrigidas
          </Link>
        </Menu>
      </div>
    )
  }
}
