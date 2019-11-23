import React, { Component } from 'react';
import { Redirect } from 'react-router-dom'
import { Input, BotaoPrincipal, Notificacao } from '../../component/index'
import { login, retornaPerfil } from '../../services/index'
import './login.style.css'

export class LoginScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      identifier: '',
      deveRedirecionarParaHome: false
    }
  }

  handleChange = (event) => {
    const { name, value } = event.target
    this.setState({
      [name]: value
    })
  }

  handleClickFazerLogin = async(event) => {
    event.preventDefault()
    const user = {
      "login": this.state.identifier,
      "senha": 0
    }
    try{
      const data = await login(user)
      localStorage.setItem("accessToken", data.token)
      const perfil = await retornaPerfil(data.identifier)
      localStorage.setItem("perfilUsuario", perfil)
      this.setState({
        deveRedirecionarParaHome: true
      })
    }
    catch(error){
      if (error.response.data.errors) {
        error.response.data.errors.map(message => {
					return Notificacao('Falha', `${message.defaultMessage}`, 'warning')
        })
      } else {
				Notificacao('Falha', `${error.response.data.message}`, 'danger')
      }
    }
  }

  renderBlocoLogin() {
    return(
      <div className="bloco-login">
        <div className="titulo-login">CWI Turing</div>
        <div className="container-input-login">
          <Input
          classNameDiv="div-input"
          className="class-input"
          placeholder="Usuario"
          name="identifier"
          value={this.state.identifier}
					onChange={this.handleChange}/>

          <div className="container-botao">
					  <BotaoPrincipal classe="botao-input" nome="Entrar" onClick={this.handleClickFazerLogin}/>
				  </div>
        </div>
      </div>
    )
  }

  render() {
    if(this.state.deveRedirecionarParaHome){
      return <Redirect to="/"/>
    }
    return(
      <>
      <div className="container-login">
        {this.renderBlocoLogin()}
      </div>
      </>
    )
  }
}