import React, { Component } from 'react';
import { Input, BotaoPrincipal, AdicionarQuestao, BotaoAdicionar, Notificacao } from '../../component/index'
import { adicionarProva,
        incluirDissertativas,
        incluirMultiplaEscolha,
        incluirTecnicas,
        retornarEspecificidades,
        retornarNiveisDeDificuldade } from '../../services/index'
import { Redirect } from 'react-router-dom'
import './cadastroProva.style.css'

const mensagemSucessoNotificacao = 'Questões adicionadas com sucesso'
const objeto = { tipo: null, especificidade: null, nivel: null, quantidade: null }

export class CadastrarProvaScreen extends Component {

  constructor(props) {
    super(props)
    this.state = {
      email: null,
      duracao: 0,
      tempoParaIniciarProva: 0,
      idProva: null,
      deveRenderizarQuestoes: false,
      deveRedirecionarParaVisualizarProva: false,
      arrayStates: [objeto],
      tipos: ['Dissertativa', 'Múltipla Escolha', 'Técnica'],
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

  handleChange = (event) => {
    const { name, value } = event.target
    this.setState({
      [name]: value
    })
  }

  handleChangeArray = (event, id) => {
    const { name, value } = event.target

    const array = [...this.state.arrayStates]
    array[id][name] = value;

    this.setState({
      arrayStates: array
    })
  }

  handleClickAdicionarQuestao = (event) => {
    event.preventDefault()
    this.setState({
      arrayStates: [...this.state.arrayStates, objeto]
    })
  }

  handleClickEnviarBaseProva = async (event) => {
    event.preventDefault()

    const prova = {
      "email": this.state.email,
      "tempoDeDuracaoDaProva": this.state.duracao,
      "tempoParaInicioProva": this.state.tempoParaIniciarProva
    }

    try {
      let idProvaSalva = await adicionarProva(prova)
      this.setState({
        idProva: idProvaSalva,
        deveRenderizarQuestoes: true
      })
      Notificacao('Sucesso', 'Prova enviada com sucesso', 'success')
    }
    catch (error) {
      if (error.response.data.errors) {
        error.response.data.errors.map(message => {
          return Notificacao('Falha', `${message.defaultMessage}`, 'danger')
        })
      } else {
        Notificacao('Falha', `${error.response.data.message}`, 'danger')
      }
    }
  }

  handleClickVoltarProva = (event) => {
    event.preventDefault()
    this.setState({
      deveRenderizarQuestoes: false
    })
  }

  handleClickEnviarProva = (event) => {
    event.preventDefault()

    localStorage.setItem('idProva', this.state.idProva)

    this.setState({
      deveRedirecionarParaVisualizarProva: true
    })
  }

  handleClickEnviarQuestao = async (id) => {

    const questao = {
      "especificidade": this.state.arrayStates[id].especificidade,
      "nivelDeDificuldade": this.state.arrayStates[id].nivel,
      "quantidadeDeQuestoes": this.state.arrayStates[id].quantidade
    }

    if (this.state.arrayStates[id].tipo === this.state.tipos[0]) {
      try {
        await incluirDissertativas(this.state.idProva, questao)
        Notificacao('Sucesso', mensagemSucessoNotificacao, 'success')
      }
      catch (error) {
        if (error.response.data.errors) {
          error.response.data.errors.map(message => {
            return Notificacao('Falha', `${message.defaultMessage}`, 'danger')
          })
        } else {
          Notificacao('Falha', `${error.response.data.message}`, 'danger')
        }
      }
    } else if (this.state.arrayStates[id].tipo === this.state.tipos[1]) {
      try {
        await incluirMultiplaEscolha(this.state.idProva, questao)
        Notificacao('Sucesso', mensagemSucessoNotificacao, 'success')
      }
      catch (error) {
        if (error.response.data.errors) {
          error.response.data.errors.map(message => {
            return Notificacao('Falha', `${message.defaultMessage}`, 'danger')
          })
        } else {
          Notificacao('Falha', `${error.response.data.message}`, 'danger')
        }
      }
    } else if (this.state.arrayStates[id].tipo === this.state.tipos[2]) {
      try {
        await incluirTecnicas(this.state.idProva, questao)
        Notificacao('Sucesso', mensagemSucessoNotificacao, 'success')
      }
      catch (error) {
        if (error.response.data.errors) {
          error.response.data.errors.map(message => {
            return Notificacao('Falha', `${message.defaultMessage}`, 'warning')
          })
        } else {
          Notificacao('Falha', `${error.response.data.message}`, 'danger')
        }
      }
    } else {
      Notificacao('Falha', 'Tipo de questão não selecionado', 'warning')
    }
  }

  renderArrayQuestoes() {
    return (
      this.state.arrayStates.map((item, key) => {
        return <AdicionarQuestao
          key={key}
          id={key}
          tipo={item.tipo}
          especificidade={item.especificidade}
          nivel={item.nivel}
          quantidade={item.quantidade}
          handleChange={this.handleChangeArray}
          onClick={this.handleClickEnviarQuestao}
          idProva={this.state.idProva} />
      })
    )
  }

  renderEscolhaDeQuestoes() {
    return (
      <>
        <div className="container-titulo">
          <span className="titulo-crie">Adicione questões a sua prova</span>
        </div>

        {
          this.renderArrayQuestoes()
        }

        <div className="container-botao">
          <BotaoAdicionar className="botao-adicionar" nome="Adicionar mais questões" adicionar={true} onClick={this.handleClickAdicionarQuestao} />
          <BotaoPrincipal nome="Visualizar" onClick={this.handleClickEnviarProva} />
          <BotaoPrincipal nome="Voltar" onClick={this.handleClickVoltarProva} />
        </div>
      </>
    )
  }

  renderInputsProva() {
    return (
      <>
        <div className="container-titulo">
          <span className="titulo-crie">Crie sua prova</span>
        </div>

        <div className="container-questao">
          <Input
            name="email"
            value={this.state.email}
            onChange={this.handleChange}
            maxTam="50"
            type="text"
            label="Digite o email do candidato"
            placeholder="" />

          <Input
            name="duracao"
            value={this.state.duracao}
            onChange={this.handleChange}
            maxNum="10"
            type="number"
            label="Tempo de duração da prova (minutos)"
            placeholder="" />

          <Input
            name="tempoParaIniciarProva"
            value={this.state.tempoParaIniciarProva}
            onChange={this.handleChange}
            maxNum="8760"
            type="number"
            label="Tempo para iniciar a prova (horas)"
            placeholder="" />
        </div>

        <div className="container-botao">
          <BotaoPrincipal nome="Adicionar questões" onClick={this.handleClickEnviarBaseProva} />
        </div>
      </>
    )
  }

  render() {

    if (this.state.deveRedirecionarParaVisualizarProva) {
      return <Redirect to="/visualizar-prova" />
    }

    return (
      <div className="container-tela">
        {
          this.state.deveRenderizarQuestoes
            ?
            this.renderEscolhaDeQuestoes()
            :
            this.renderInputsProva()
        }
      </div>
    )
  }
}
