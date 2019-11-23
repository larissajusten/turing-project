import React, { Component } from 'react';
import { Input, BotaoPrincipal, Notificacao } from '../../component/index'
import './login.style.css'

export class LoginScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      email: '',
      senha: '',
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
      "email": this.state.email,
      "senha": this.state.senha
    }
    try{
      const data = 0//await login(user)
      localStorage.setItem("accessToken", data.accessToken)
      localStorage.setItem("perfil", data.perfil)
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
        <div className="container-inputs-login">
          <Input
          className="div-input"
          placeholder="Email"
          name="email"
          value={this.state.email}
					onChange={this.handleChange}/>

          <Input
          className="div-input"
          placeholder="Senha"
          type="password"
          name="senha"
          value={this.state.senha}
					onChange={this.handleChange}/>

          <div className="container-botao">
					  <BotaoPrincipal classe="botao-input" nome="Entrar" onClick={this.handleClickSalvarQuestao}/>
				  </div>
        </div>
      </div>
    )
  }

  render() {
    return(
      <>
      <div className="container-login">
        {this.renderBlocoLogin()}
      </div>
      </>
    )
  }
}