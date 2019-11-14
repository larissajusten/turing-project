import React, { Component } from 'react';
import './buscarQuestao.style.css'
import { Select, Input, BotaoPrincipal, CardQuestao } from '../../component/index'
import { retornarEspecificidades,
          retornarNiveisDeDificuldade,
          retornaQuestoesTecnicas } from '../../services/index'

export class BuscarQuestao extends Component {

  constructor(props){
    super(props)
    this.state = {
      tipos: [ 'Dissertativa', 'Múltipla Escolha', 'Técnica'],
			especificidades: [],
			niveis: [],
      tipo: '',
      especificidade: '',
      nivel:'',
      quantidade: '',
      resultados: []
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

  handleClickEnviarPesquisa = async (event) => {
    event.preventDefault()

    const busca = {
      "especificidade": this.state.especificidade,
      "nivelDeDificuldade": this.state.nivel,
      "quantidadeDeQuestoes": this.state.quantidade
    }

    let listaDeQuestoes = await retornaQuestoesTecnicas(busca)
      /*if(this.state.tipo === this.state.tipos[0]){
        await enviarBusca(busca)
      }else if(this.state.tipo === this.state.tipos[1]){
        await retornaQuestoesTecnicas(busca)
      }else if(this.state.tipo === this.state.tipos[2]){
        await enviarBusca(busca)
      }*/
    this.setState({
      resultados: listaDeQuestoes
    })
  }

  renderPesquisa() {
    return (
      <>
      <div className="container-questoes">
        {
          this.state.resultados.map((item, key) => {
            return (
              <CardQuestao
                key = {key}
                questao = {item.questao}
                data = {item.dataCriacao}
                especificidade = {item.especificidade}
                nivel = {item.nivelDeDificuldade}
              />
            )
          })
        }
      </div>
      </>
    )
  }

  renderBuscar() {
    if(this.state.especificidades && this.state.niveis){
      return (
        <>
        <div className="container-titulo">
          <span className="titulo-crie">Busque a questão que deseja</span>
        </div>

        <div className="container-inputs-buscar">
          <div className="input-principal width-tipo">
            <label className="label">Tipo</label>
            <Select
              name="tipo"
              value={this.state.tipo}
              onChange={this.handleChange}
              object={this.state.tipos}
              placeholder="Selecione o tipo"
              questoesWidth="width-tipo"/>
          </div>

          <div className="input-principal width-especificidade">
            <label className="label">Especificidade</label>
            <Select
              name="especificidade"
              value={this.state.especificidade}
              onChange={this.handleChange}
              object={this.state.especificidades}
              placeholder="Selecione a especificidade"
              questoesWidth="width-especificidade"/>
          </div>

          <div className="input-principal width-nivel">
            <label className="label">Nivel</label>
            <Select
              name="nivel"
              value={this.state.nivel}
              onChange={this.handleChange}
              object={this.state.niveis}
              placeholder="Selecione o nível"
              questoesWidth="width-nivel"/>
          </div>

          <Input
            name="quantidade"
            value={this.state.quantidade}
            onChange={this.handleChange}
            className="input"
            label="Quantidade"
            type="number"
            placeholder=""/>
        </div>

        {
          this.state.resultados.length
          ?
          this.renderPesquisa()
          :
          null
        }

        <div className="botao-cadastro">
					<BotaoPrincipal nome="Enviar" onClick={this.handleClickEnviarPesquisa}/>
				</div>
        </>
      )
    }
  }

  render() {
    return (
      <>
      <div className="tela-cadastro">
        {this.renderBuscar()}
      </div>
      </>
    )
  }
}
