import React, { Component } from 'react';
import { Redirect } from 'react-router-dom'

export class TelaInicialScreen extends Component {
  constructor(props){
    super(props)
    this.state = {
      deveRenderizarLogin: false
    }
  }

  componentDidMount() {
    let token = localStorage.getItem('accessToken')
    console.log(token)
    if(!token){
      this.setState({
        deveRenderizarLogin: true
      })
    }
  }

  render() {
    if(this.state.deveRenderizarLogin){
      return <Redirect to="/login"/>
    }

    return (
      <div className="container-tela">
        <h1 className="titulo">Dashboard</h1>
      </div>
    )
  }
}