import React, { Component } from 'react';
import { Redirect } from 'react-router-dom'
import { Input, BotaoPrincipal, AdicionarQuestaoNaProva, Notificacao, Select } from '../../component/'
import { DominioService, ProvaService, IncluirQuestoesProvaService, EmailService } from '../../services/'
import './cadastroProva.style.css'

export class CadastrarProvaScreen extends Component {

  constructor(props) {
    super(props)
    this.state = {
      tipos: [],
      especificidades: [],
      niveis: [],
      tiposDeProvas: [],
      nomeDoCandidato: '',
      emailDoCandidato: '',
      duracaoDaProva: '',
      tempoParaIniciarProva: '',
      idProva: '',
      tipoProva: '',
      deveRenderizarQuestoes: false,
      deveRedirecionarParaVisualizarProva: false,
      deveRedirecionarParaDashboard: false,
      arrayStates: [this.objeto]
    }
    this.mensagemSucessoNotificacao = 'Questões adicionadas com sucesso'

    this.objeto = { tipo: '', especificidade: '', nivel: '', quantidade: '' }

    this.arrayDeParamsDosInputs = [
      { value: "nomeDoCandidato", name: "nomeDoCandidato", tam: "50", maxNum:"", float: "", type: "text", label: "Digite o nome do candidato"},
      { value: "emailDoCandidato", name: "emailDoCandidato", tam: "50", maxNum:"", float: "", type: "text", label: "Digite o email do candidato"},
      { value: "duracaoDaProva", name: "duracaoDaProva", tam: "6", maxNum:"12", float: "0.01", type: "number", label: "Tempo de duração da prova (minutos)"},
      { value: "tempoParaIniciarProva", name: "tempoParaIniciarProva", tam: "6", maxNum:"8760", float: "0.01", type: "number", label: "Tempo para iniciar a prova (horas)"}
    ]

    this.arrayDeParamsDosInputsCrescer = [
      { value: "emailDoCriador", name: "emailDoCriador", tam: "50", type: "text", label: "Digite o seu email"},
      { value: "numeroDeProvas", name: "numeroDeProvas", tam: "2", type: "number", label: "Digite o email do candidato"},
      { value: "duracaoDaProva", name: "duracaoDaProva", tam: "10", type: "number", label: "Tempo de duração da prova (minutos)"},
      { value: "tempoParaIniciarProva", name: "tempoParaIniciarProva", tam: "8760", type: "number", label: "Tempo para iniciar a prova (horas)"}
    ]

    this.dominioService = new DominioService()
    this.provaService = new ProvaService()
    this.incluirQuestoesProvaService = new IncluirQuestoesProvaService()
    this.emailService = new EmailService()
  }

  async componentDidMount() {
    let tipos = await this.dominioService.retornarTipoDeQuestao()
    let especificidades = await this.dominioService.retornarEspecificidades()
    let niveis = await this.dominioService.retornarNiveisDeDificuldade()
    let tiposDeProvas = await this.dominioService.retornarTipoDeProva()

    let arr = Array.from({length:(this.state.arrayStates.length+2)}, () => ({ }))
    let arrayStates = arr.map(() => ({ ...this.objeto }))

    this.setState({
      tipos,
      especificidades,
      arrayStates,
      niveis,
      tiposDeProvas
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

  catchErrorENotifica(error){
    if (error.response.data.errors) {
      error.response.data.errors.map(message => {
        return Notificacao('Falha', `${message.defaultMessage}`, 'warning')
      })
    } else {
      Notificacao('Falha', `${error.response.data.message}`, 'danger')
    }
  }

  handleClickEnviarBaseProva = async (event) => {
    event.preventDefault()

    const prova = {
      "email": this.state.emailDoCandidato,
      "nomeCandidato": this.state.nomeDoCandidato,
      "tempoDeDuracaoDaProva": this.state.duracaoDaProva,
      "tempoParaInicioProva": this.state.tempoParaIniciarProva
    }

    try {
      let idProvaSalva = await this.provaService.criarProva(prova)
      this.setState({
        idProva: idProvaSalva,
        deveRenderizarQuestoes: true
      })
      Notificacao('Sucesso', 'Prova registrada com sucesso', 'success')
    }
    catch (error) {
      this.catchErrorENotifica(error)
    }
  }

  handleClickEnviarProva = async (event) => {
    event.preventDefault()
    try {
      Notificacao('Sucesso', 'Prova enviada com sucesso', 'success')
      await this.emailService.enviarEmail(this.state.emailDoCandidato)
      this.setState({
        deveRedirecionarParaDashboard: true
      })
    }
    catch (error) {
      this.catchErrorENotifica(error)
    }
  }

  handleClickVisualizarProva = (event) => {
    event.preventDefault()
    this.setState({
      deveRedirecionarParaVisualizarProva: true
    })
  }

  handleClickCancelarProva = async(event) => {
    event.preventDefault()
    try {
      await this.provaService.cancelarProva(this.state.idProva)
      Notificacao('Sucesso', 'Prova cancelada com sucesso', 'success')
      this.setState({
        deveRedirecionarParaDashboard: true
      })
    }
    catch (error) {
      this.catchErrorENotifica(error)
    }

  }

  enviarQuestaoDissertativa = async (questao) => {
    try {
      await this.incluirQuestoesProvaService.incluirDissertativas(this.state.idProva, questao)
      Notificacao('Sucesso', this.mensagemSucessoNotificacao, 'success')
    }
    catch (error) {
      this.catchErrorENotifica(error)
    }
  }

  enviarQuestaoMultiplaEscolha = async (questao) => {
    try {
      await this.incluirQuestoesProvaService.incluirMultiplaEscolha(this.state.idProva, questao)
      Notificacao('Sucesso', this.mensagemSucessoNotificacao, 'success')
    }
    catch (error) {
      this.catchErrorENotifica(error)
    }
  }

  enviarQuestaoTecnica = async (questao) => {
    try {
      await this.incluirQuestoesProvaService.incluirTecnicas(this.state.idProva, questao)
      Notificacao('Sucesso', this.mensagemSucessoNotificacao, 'success')
    }
    catch (error) {
      this.catchErrorENotifica(error)
    }
  }

  handleClickEnviarQuestao = async (id) => {

    const questao = {
      "especificidade": this.state.arrayStates[id].especificidade,
      "nivelDeDificuldade": this.state.arrayStates[id].nivel,
      "quantidadeDeQuestoes": this.state.arrayStates[id].quantidade
    }

    if (this.state.arrayStates[id].tipo === this.state.tipos[0]) {
      this.enviarQuestaoDissertativa(questao)
    } else if (this.state.arrayStates[id].tipo === this.state.tipos[1]) {
      this.enviarQuestaoMultiplaEscolha(questao)
    } else if (this.state.arrayStates[id].tipo === this.state.tipos[2]) {
      this.enviarQuestaoTecnica(questao)
    } else {
      Notificacao('Falha', 'Tipo de questão não selecionado', 'warning')
    }
  }

  renderArrayQuestoes() {
    return (
      this.state.arrayStates.map((item, key) => {
        return <AdicionarQuestaoNaProva
                key={key}
                index={key}
                tipo={item.tipo}
                especificidade={item.especificidade}
                nivel={item.nivel}
                quantidade={item.quantidade}
                handleChange={this.handleChangeArray}
                onClick={this.handleClickEnviarQuestao}
                idProva={this.state.idProva}/>
      })
    )
  }

  renderBotoesEscolhaDeQuestoes(){
    return( <div className="container-botao container-botao-prova">
              <BotaoPrincipal nome="Visualizar" onClick={this.handleClickVisualizarProva}/>
              <BotaoPrincipal nome="Enviar por e-mail" onClick={this.handleClickEnviarProva}/>
              <BotaoPrincipal nome="Cancelar" onClick={this.handleClickCancelarProva} />
            </div>
    )
  }

  renderEscolhaDeQuestoes() {
    return (
      <>
        <div className="container-titulo">
          <span className="titulo-crie">Adicione questões a sua prova</span>
        </div>
        {this.renderArrayQuestoes()}
        {this.renderBotoesEscolhaDeQuestoes()}
      </>
    )
  }

  renderInputsCrescer() {
    return this.arrayDeParamsDosInputsCrescer.map((item, key) => {
      return <Input key={key} name={item.name} value={this.state[item.value]} maxTam={item.tam} type={item.tam} label={item.label}
                  placeholder="" onChange={this.handleChange}/>
    })
  }

  renderInputs() {
    return this.arrayDeParamsDosInputs.map((item, key) => {
      return <Input key={key}
                    name={item.name}
                    value={this.state[item.value]}
                    maxTam={item.tam}
                    maxNum={item.maxNum}
                    step={item.float}
                    type={item.type}
                    label={item.label}
                    placeholder=""
                    onChange={this.handleChange}/>
    })
  }

  renderInputsBaseProva(){
    return (
      <>
        <div className="container-titulo titulo-prova">
          <span className="titulo-crie">Crie sua prova</span>
          <Select
							questoesWidth="width-prova"
							placeholder="Selecione o tipo de prova"
							name="tipoProva"
							value={this.state.tipoProva}
							onChange={this.handleChange}
							object={this.state.tiposDeProvas}
						/>
        </div>
        {this.renderInputs()}
        <div className="container-botao">
          <BotaoPrincipal classe="cadastro-prova-botao" nome="ADICIONAR QUESTÕES" onClick={this.handleClickEnviarBaseProva}/>
        </div>
      </>
    )
  }


  render() {
    if (this.state.deveRedirecionarParaDashboard) {
      return <Redirect to="/" />
    }
    if (this.state.deveRedirecionarParaVisualizarProva) {
      return <Redirect to={`/visualizar-prova/${this.state.idProva}`} />
    }
    return (
      <div className="container-tela cadastro-prova-container">
        {
          this.state.deveRenderizarQuestoes
            ?
            this.renderEscolhaDeQuestoes()
            :
            this.renderInputsBaseProva()
        }
      </div>
    )
  }
}
