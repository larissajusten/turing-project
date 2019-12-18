import React, { Component } from 'react';
import { Redirect } from 'react-router-dom'
import { Input, BotaoPrincipal, AdicionarQuestaoNaProva, Notificacao, Select } from '../../component/'
import { DominioService,
        ProvaService,
        IncluirQuestoesProvaService,
        EmailService,
        ProvaCrescerService,
        IncluirQuestoesProvaCrescerService } from '../../services/'
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
      emailDoCriador: '',
      numeroDeProvas: '',
      idProva: '',
      tipoProvaEscolhida: '',
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
      { value: "emailDoCriador", name: "emailDoCriador", tam: "50", maxNum:"", float: "", type: "text", label: "Digite o seu email"},
      { value: "numeroDeProvas", name: "numeroDeProvas", tam: "8", maxNum:"10000000", float: "", type: "number", label: "Digite o número de provas"},
      { value: "duracaoDaProva", name: "duracaoDaProva", tam: "6", maxNum:"12", float: "0.01", label: "Tempo de duração da prova (minutos)"},
      { value: "tempoParaIniciarProva", name: "tempoParaIniciarProva", tam: "6", maxNum:"8760", float: "0.01", label: "Tempo para iniciar a prova (horas)"}
    ]

    this.dominioService = new DominioService()
    this.provaService = new ProvaService()
    this.provaCrescerService = new ProvaCrescerService()
    this.incluirQuestoesProvaService = new IncluirQuestoesProvaService()
    this.incluirQuestoesProvaCrescerService = new IncluirQuestoesProvaCrescerService()
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

  
  /* Crescer */
  handleClickEnviarBaseCrescerProva = async (event) => {
    

    const prova = {
      "quantidade": this.state.numeroDeProvas,
      "tipo": this.state.tipoProvaEscolhida,
      "tempoDeDuracaoDaProva": this.state.duracaoDaProva,
      "tempoParaInicioProva": this.state.tempoParaIniciarProva
    }

    try {
      let idProvaSalva = await this.provaCrescerService.criarProvaCrescer(prova)
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

  handleClickEnviarProvaCrescer = async (event) => {
    
    try {
      Notificacao('Sucesso', 'Prova enviada com sucesso', 'success')
      await this.emailService.enviarEmailCrescer(this.state.emailDoCriador)
      this.setState({
        deveRedirecionarParaDashboard: true
      })
    }
    catch (error) {
      this.catchErrorENotifica(error)
    }
  }

  enviarQuestoesDoCrescer(id, questao) {
    if (this.state.arrayStates[id].tipo === this.state.tipos[0]) {
      this.enviarQuestaoDissertativaCrescer(questao)
    } else if (this.state.arrayStates[id].tipo === this.state.tipos[1]) {
      this.enviarQuestaoMultiplaEscolhaCrescer(questao)
    } else if (this.state.arrayStates[id].tipo === this.state.tipos[2]) {
      this.enviarQuestaoTecnicaCrescer(questao)
    } else {
      Notificacao('Falha', 'Tipo de questão não selecionado', 'warning')
    }
  }

  enviarQuestaoMultiplaEscolhaCrescer = async (questao) => {
    try {
      await this.incluirQuestoesProvaCrescerService.incluirMultiplaEscolha(questao)
      Notificacao('Sucesso', this.mensagemSucessoNotificacao, 'success')
    }
    catch (error) {
      this.catchErrorENotifica(error)
    }
  }

  enviarQuestaoTecnicaCrescer = async (questao) => {
    try {
      await this.incluirQuestoesProvaCrescerService.incluirTecnicas(questao)
      Notificacao('Sucesso', this.mensagemSucessoNotificacao, 'success')
    }
    catch (error) {
      this.catchErrorENotifica(error)
    }
  }

  enviarQuestaoDissertativaCrescer = async (questao) => {
    try {
      await this.incluirQuestoesProvaCrescerService.incluirDissertativas(questao)
      Notificacao('Sucesso', this.mensagemSucessoNotificacao, 'success')
    }
    catch (error) {
      this.catchErrorENotifica(error)
    }
  }


  /* Normal */
  handleClickEnviarBaseProva = async (event) => {
    

    const prova = {
      "email": this.state.emailDoCandidato,
      "nomeCandidato": this.state.nomeDoCandidato,
      "tipo": this.state.tipoProvaEscolhida,
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
    
    this.setState({
      deveRedirecionarParaVisualizarProva: true
    })
  }

  handleClickCancelarProva = async(event) => {
    
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

  enviarQuestoesDaProva(id, questao) {
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

    if(this.state.tipoProvaEscolhida === this.state.tiposDeProvas[0]) {
      this.enviarQuestoesDaProva(id, questao)
    }else {
      this.enviarQuestoesDoCrescer(id, questao)
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

  verificaTipoParaBotoes() {
    if(this.state.tipoProvaEscolhida === this.state.tiposDeProvas[0]) {
      return this.renderBotoesEscolhaDeQuestoes()
    }else {
      return <div className="container-botao container-botao-prova">
              <BotaoPrincipal nome="Enviar por e-mail" onClick={this.handleClickEnviarProvaCrescer}/>
            </div>
    }
  }

  renderEscolhaDeQuestoes() {
    return (
      <>
        <div className="container-titulo">
          <span className="titulo-crie">Adicione questões a sua prova</span>
        </div>
        {this.renderArrayQuestoes()}
        {this.verificaTipoParaBotoes()}
      </>
    )
  }

  renderInputs(arrayDeInputs) {
    return arrayDeInputs.map((item, key) => {
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

  verificaTipo() {
    if(this.state.tipoProvaEscolhida === this.state.tiposDeProvas[0]) {
      return <>
            {this.renderInputs(this.arrayDeParamsDosInputs)}
            <div className="container-botao">
              <BotaoPrincipal classe="cadastro-prova-botao" nome="ADICIONAR QUESTÕES" onClick={this.handleClickEnviarBaseProva}/>
            </div>
            </>
    }else if(this.state.tipoProvaEscolhida === this.state.tiposDeProvas[1]) {
      return <>
            {this.renderInputs(this.arrayDeParamsDosInputsCrescer)}
            <div className="container-botao">
              <BotaoPrincipal classe="cadastro-prova-botao" nome="ADICIONAR QUESTÕES" onClick={this.handleClickEnviarBaseCrescerProva}/>
            </div>
            </>
    }else {
      return <h1>Escolha um tipo</h1>
    }
  }

  renderInputsBaseProva(){
    return (
      <>
        <div className="container-titulo titulo-prova">
          <span className="titulo-crie">Crie sua prova</span>
          <Select
            questoesWidth="width-prova"
            placeholder="Selecione o tipo de prova"
            name="tipoProvaEscolhida"
            value={this.state.tipoProvaEscolhida}
            onChange={this.handleChange}
            object={this.state.tiposDeProvas}/>
        </div>
        {this.verificaTipo()}
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
