import React, { Component } from 'react';
import { Input, BotaoAdicionar, EscolherQuestao } from '../index'
import { incluirDissertativas, 
        incluirMultiplaEscolha, 
        incluirTecnicas, 
        retornarEspecificidades, 
        retornarNiveisDeDificuldade } from '../../services/index'

export class AdicionarQuestao extends Component {

  constructor(props){
    super(props)
    this.state = {
      tipos: [ 'Dissertativa', 'Múltipla Escolha', 'Técnica' ],
      especificidades: [],
      niveis: [],
      tipo: '',
      especificidade: '',
      nivel: '',
      quantidade: ''
    }
  }

  async componentDidMount() {
		this.setState({
			especificidades: await retornarEspecificidades(),
			niveis: await retornarNiveisDeDificuldade()
		})
  }

  handleChange = (event) => {
    const { name, value } = event.target
    this.setState({
        [name]: value
    })
  }

  handleClickEnviarQuestao = async(event) => {
    event.preventDefault()

    const questao = {
        "especificidade": this.state.especificidade,
        "nivelDeDificuldade": this.state.nivel,
        "quantidadeDeQuestoes": this.state.quantidade
    }

    if(this.state.tipo === this.state.tipos[0]){
      try{
        await incluirDissertativas(this.props.idProva, questao)
      }
      catch (error){
        alert(error.response.data.message)
      }
    }else if(this.state.tipo === this.state.tipos[1]){
      try{
        await incluirMultiplaEscolha(this.props.idProva, questao)
      }
      catch (error){
        alert(error.response.data.message)
      }
    }else if(this.state.tipo === this.state.tipos[2]){
      try{
        await await incluirTecnicas(this.props.idProva, questao)
      }
      catch (error){
        alert(error.response.data.message)
      }
    }

    this.setState({
      tipo: '',
      especificidade: '',
      nivel: '',
      quantidade: ''
    })
  }

  render() {
    console.log(this.props.idProva)
    return(
      <div className="container-inputs-prova">
      <EscolherQuestao 
          tipo = {this.state.tipo}
          especificidade = {this.state.especificidade}
          nivel = {this.state.nivel}
          tipos = {this.state.tipos}
          especificidades = {this.state.especificidades}
          niveis = {this.state.niveis}
          handleChange = {this.handleChange}/>
          
      <Input
          name="quantidade"
          value={this.state.quantidade}
          onChange={this.handleChange}
          className="input-quantidade"
          type="number"
          label="Quantidade de questões"
          placeholder=""/>

      <BotaoAdicionar nome="+" onClick={this.handleClickEnviarQuestao}/>
      </div>
    )
  }
}