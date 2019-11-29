import React, { Component } from 'react';
import './buscarQuestao.style.css'
import { BotaoPrincipal, CardBuscarQuestao, BuscarQuestao, Notificacao, Paginacao } from '../../component/index'
import { retornarEspecificidades,
        retornarNiveisDeDificuldade,
        retornarQuestoesTecnicasFiltradas,
        retornarQuestoesDissertativasFiltradas,
        retornarQuestoesMultiplasEscolhasFiltradas,
        retornarTipoDeQuestao} from '../../services/index'

const mensagemSucessoNotificacao = 'Busca bem sucedida'
export class BuscarQuestaoScreen extends Component {

  constructor(props) {
    super(props)
    this.state = {
      tipos: [],
      especificidades: [],
      niveis: [],
      tipo: '',
      especificidade: '',
      nivel: '',
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
      tipos: await retornarTipoDeQuestao(),
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

  salvaResponseENotificaSucesso(dadosDaResponse) {
    Notificacao('Sucesso', mensagemSucessoNotificacao, 'success')
    this.setState({
      questoes: dadosDaResponse[0],
      totalPaginas: dadosDaResponse[1],
      per_page: dadosDaResponse[2],
      current_page: dadosDaResponse[3],
    })
  }

  catchErrorENotifica(error){
    if (error.response.data.errors) {
      error.response.data.errors.map(message => {
        return Notificacao('Falha', `${message.defaultMessage}`, 'warning')
      })
    } else {
      Notificacao('Falha', `${error.response.data.message}`, 'danger')
    }
  }

  retornarQuestoesDissertativasFiltradas = async (especificidade, nivelDeDificuldade) => {
    try {
      let dadosDaResponse = await retornarQuestoesDissertativasFiltradas(this.state.current_page, especificidade, nivelDeDificuldade)
      this.salvaResponseENotificaSucesso(dadosDaResponse)
    }
    catch (error) {
      this.catchErrorENotifica(error)
    }
  }

  retornarQuestoesMultiplasEscolhasFiltradas = async (especificidade, nivelDeDificuldade) => {
    try {
      let dadosDaResponse = await retornarQuestoesMultiplasEscolhasFiltradas(this.state.current_page, especificidade, nivelDeDificuldade)
      this.salvaResponseENotificaSucesso(dadosDaResponse)
    }
    catch (error) {
      this.catchErrorENotifica(error)
    }
  }

  retornarQuestoesTecnicasFiltradas = async (especificidade, nivelDeDificuldade) => {
    try {
      let dadosDaResponse = await retornarQuestoesTecnicasFiltradas(this.state.current_page,  especificidade, nivelDeDificuldade)
      this.salvaResponseENotificaSucesso(dadosDaResponse)
    }
    catch (error) {
      this.catchErrorENotifica(error)
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

  buscaPagina = async pageNumber => {
    const { especificidade, nivel: nivelDeDificuldade } = this.state
    let dadosDaResponse

    if (this.state.tipo === this.state.tipos[0]) {
      dadosDaResponse = await retornarQuestoesDissertativasFiltradas(pageNumber, especificidade, nivelDeDificuldade)
    } else if (this.state.tipo === this.state.tipos[1]) {
      dadosDaResponse = await retornarQuestoesMultiplasEscolhasFiltradas(pageNumber, especificidade, nivelDeDificuldade)
    } else {
      dadosDaResponse = await retornarQuestoesTecnicasFiltradas(pageNumber, especificidade, nivelDeDificuldade)
    }

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
          <div className="container-cards-questoes">
          {
            this.state.questoes.map((item, key) => {
              return (
                <CardBuscarQuestao
                  key={key}
                  widthcardquestao="width-card-questao"
                  questao={item.questao}
                  data={item.dataCriacao}
                  especificidade={item.especificidade}
                  nivel={item.nivelDeDificuldade}
                  imagem={item.especificidade}
                  niveis={this.state.niveis}
                />
              )
            })
          }
          </div>

          <Paginacao
            totalPaginas={this.state.totalPaginas}
            paginaAtual={this.state.current_page}
            onClick={this.buscaPagina}/>
        </div>
      </>
    )
  }

  renderBuscar() {
    if (this.state.especificidades && this.state.niveis ) {
      return (
        <>
          <div className="container-titulo">
            <span className="titulo-crie">Busque a questão que deseja visualizar</span>
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

          <div className="container-botao">
            <BotaoPrincipal nome="ENVIAR" onClick={this.handleClickEnviarPesquisa} />
          </div>

          {
            this.state.questoes &&
              this.renderPesquisa()
          }
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
