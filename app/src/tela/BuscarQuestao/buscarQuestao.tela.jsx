import React, { Component } from 'react';
import './buscarQuestao.style.css'
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
      "nivelDeDificuldade": this.state.nivel
    }

    let listaDeQuestoes = ''

    if (this.state.tipo === this.state.tipos[0]) {
      try {
        listaDeQuestoes = await retornarQuestoesDissertativasFiltradas(busca)
        Notificacao('Sucesso', mensagemSucessoNotificacao, 'success')
        this.setState({
          resultados: listaDeQuestoes
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
    } else if (this.state.tipo === this.state.tipos[1]) {
      try {
        listaDeQuestoes = await retornarQuestoesMultiplasEscolhasFiltradas(busca)
        Notificacao('Sucesso', mensagemSucessoNotificacao, 'success')
        this.setState({
          resultados: listaDeQuestoes
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
    } else if (this.state.tipo === this.state.tipos[2]) {
      try {
        listaDeQuestoes = await retornarQuestoesTecnicasFiltradas(busca)
        Notificacao('Sucesso', mensagemSucessoNotificacao, 'success')
        this.setState({
          resultados: listaDeQuestoes
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
    } else {
      Notificacao('Falha', 'Tipo de questão é nulo', 'warning')
    }
  }

  renderPesquisa() {
    return (
      <>
        <div className="container-questoes">
          {
            this.state.resultados.map((item, key) => {
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
            this.state.resultados.length
              ?
              this.renderPesquisa()
              :
              null
          }

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
