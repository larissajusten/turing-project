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
      niveis: []
    }
  }

  async componentDidMount() {
		this.setState({
			especificidades: await retornarEspecificidades(),
			niveis: await retornarNiveisDeDificuldade()
		})
  }

  handleClickEnviarQuestao = async(event) => {
    event.preventDefault()

    const questao = {
        "especificidade": this.props.especificidade,
        "nivelDeDificuldade": this.props.nivel,
        "quantidadeDeQuestoes": this.props.quantidade
    }

    if(this.props.tipo === this.state.tipos[0]){
      try{
        await incluirDissertativas(this.props.idProva, questao)
      }
      catch (error){
        alert(error.response.data.message)
      }
    }else if(this.props.tipo === this.state.tipos[1]){
      try{
        await incluirMultiplaEscolha(this.props.idProva, questao)
      }
      catch (error){
        alert(error.response.data.message)
      }
    }else if(this.props.tipo === this.state.tipos[2]){
      try{
        await await incluirTecnicas(this.props.idProva, questao)
      }
      catch (error){
        alert(error.response.data.message)
      }
    }
  }

  render() {
    console.log(this.props.idProva)
    return(
      <div className="container-inputs-prova">
      <EscolherQuestao 
          tipo = {this.props.tipo}
          especificidade = {this.props.especificidade}
          nivel = {this.props.nivel}
          tipos = {this.state.tipos}
          especificidades = {this.state.especificidades}
          niveis = {this.state.niveis}
          handleChange = {this.props.handleChange}/>
          
      <Input
          name="quantidade"
          value={this.props.quantidade}
          onChange={this.props.handleChange}
          className="input-quantidade"
          type="number"
          label="Quantidade de questões"
          placeholder=""/>
      
      <div className="container-botao-adicionar">
        <BotaoAdicionar Adicionar nome="+" onClick={this.handleClickEnviarQuestao}/>
      </div>

      </div>
    )
  }
}