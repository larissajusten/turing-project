import React, { Component } from 'react';
import './buscarQuestao.style.css'
import Paginator from 'react-js-paginator';
import { BotaoPrincipal, CardBuscarQuestao, BuscarQuestao, Notificacao } from '../../component/index'
import { retornarEspecificidades,
        retornarNiveisDeDificuldade,
        retornarQuestoesTecnicasFiltradas,
        retornarQuestoesDissertativasFiltradas,
        retornarQuestoesMultiplasEscolhasFiltradas } from '../../services/index'

const mensagemSucessoNotificacao = 'Busca bem sucedida'
export class BuscarQuestaoScreen extends Component {

  constructor(props) {
    super(props)
    this.state = {
      tipos: ['Dissertativa', 'Múltipla Escolha', 'Técnica'],
      especificidades: [],
      niveis: [],
      tipo: null,
      especificidade: null,
      nivel: null,
      busca: '',
      questoes: null,
      totalPaginas: null,
      per_page: null,
      current_page: 0
    }
    this.busca = {}
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

  retornarQuestoesDissertativasFiltradas = async (especificidade, nivelDeDificuldade) => {
    try {
      let dadosDaResponse = await retornarQuestoesDissertativasFiltradas(this.state.current_page, especificidade, nivelDeDificuldade)
      Notificacao('Sucesso', mensagemSucessoNotificacao, 'success')
      console.log(dadosDaResponse[0])
      this.setState({
        questoes: dadosDaResponse[0],
        totalPaginas: dadosDaResponse[1],
        per_page: dadosDaResponse[2],
        current_page: dadosDaResponse[3],
      })
    }
    catch (error) {
      if (error.response.data.errors) {
        error.response.data.errors.map(message => {
          return Notificacao('Falha', `${message.defaultMessage}`, 'warning')
        })
      } else {
        console.log(error.response.data.message)
        Notificacao('Falha', `${error.response.data.message}`, 'danger')
      }
    }
  }

  retornarQuestoesMultiplasEscolhasFiltradas = async (especificidade, nivelDeDificuldade) => {
    try {
      let dadosDaResponse = await retornarQuestoesMultiplasEscolhasFiltradas(this.state.current_page, especificidade, nivelDeDificuldade)
      Notificacao('Sucesso', mensagemSucessoNotificacao, 'success')
      this.setState({
        questoes: dadosDaResponse[0],
        totalPaginas: dadosDaResponse[1],
        per_page: dadosDaResponse[2],
        current_page: dadosDaResponse[3],
      })
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
  }

  retornarQuestoesTecnicasFiltradas = async (especificidade, nivelDeDificuldade) => {
    try {
      let dadosDaResponse = await retornarQuestoesTecnicasFiltradas(this.state.current_page,  especificidade, nivelDeDificuldade)
      Notificacao('Sucesso', mensagemSucessoNotificacao, 'success')
      this.setState({
        questoes: dadosDaResponse[0],
        totalPaginas: dadosDaResponse[1],
        per_page: dadosDaResponse[2],
        current_page: dadosDaResponse[3],
      })
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
  }

  handleClickEnviarPesquisa = async (event) => {
    event.preventDefault()

    const { especificidade, nivel: nivelDeDificuldade } = this.state

    if (this.state.tipo === this.state.tipos[0]) {
      this.retornarQuestoesDissertativasFiltradas(especificidade, nivelDeDificuldade)
    } else if (this.state.tipo === this.state.tipos[1]) {
      this.retornarQuestoesMultiplasEscolhasFiltradas(especificidade, nivelDeDificuldade)
    } else if (this.state.tipo === this.state.tipos[2]) {
      this.retornarQuestoesTecnicasFiltradas(especificidade, nivelDeDificuldade)
    } else {
      Notificacao('Falha', 'Tipo de questão é nulo', 'warning')
    }
  }

  makeHttpRequestWithPage = async pageNumber => {
    const { especificidade, nivel: nivelDeDificuldade } = this.state

    const dadosDaResponse = await retornarQuestoesTecnicasFiltradas(pageNumber, especificidade, nivelDeDificuldade)

    this.setState({
      questoes: dadosDaResponse[0],
      total: dadosDaResponse[1],
      per_page: dadosDaResponse[2],
      current_page: dadosDaResponse[3],
    })
  }

  renderPesquisa() {
    return (
      <>
        <div className="container-questoes">
          {
            this.state.questoes.map((item, key) => {
              return (
                <CardBuscarQuestao
                  key={key}
                  questao={item.questao}
                  data={item.dataCriacao}
                  especificidade={item.especificidade}
                  nivel={item.nivelDeDificuldade}
                />
              )
            })
          }
        </div>
      </>
    )
  }

  renderBuscar() {
    if (this.state.especificidades && this.state.niveis) {
      return (
        <>
          <div className="container-titulo">
            <span className="titulo-crie">Busque a questão que deseja</span>
          </div>
          <div className="container-inputs">
            <BuscarQuestao
              tipo={this.state.tipo}
              especificidade={this.state.especificidade}
              nivel={this.state.nivel}
              tipos={this.state.tipos}
              especificidades={this.state.especificidades}
              niveis={this.state.niveis}
              handleChange={this.handleChange} />
          </div>

          {
            this.state.questoes &&
              this.renderPesquisa()
          }

          <Paginator
            pageSize={10}
            totalElements={64}
            onPageChangeCallback={this.makeHttpRequestWithPage(this.state.current_page+1)}
          />

          <div className="container-botao">
            <BotaoPrincipal nome="Enviar" onClick={this.handleClickEnviarPesquisa} />
          </div>
        </>
      )
    } else {
      return <h3>Não há especificidade ou niveis no banco para você poder buscar uma questão</h3>
    }
  }

  render() {
    return (
      <div className="container-tela">
        {this.renderBuscar()}
      </div>
    )
  }
}
