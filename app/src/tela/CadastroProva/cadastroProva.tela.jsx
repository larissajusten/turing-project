import React, { Component } from 'react';
import { Input, BotaoPrincipal, AdicionarQuestao, BotaoAdicionar } from '../../component/index'
import { adicionarProva } from '../../services/index'
import { Redirect } from 'react-router-dom'
import './cadastroProva.style.css'

const objeto = { tipo: '', especificidade: '', nivel: '', quantidade: '' }

export class CadastrarProvaScreen extends Component {

    constructor(props) {
        super(props)
        this.state = {
            email: '',
            duracao: 0,
            tempoParaIniciarProva: 0,
            idProva: '',
            deveRenderizarQuestoes: false,
            deveRedirecionarParaVisualizarProva: false,
            arrayStates: [objeto]
        }
    }

    handleChange = (event) => {
        const { name, value } = event.target
        this.setState({
            [name]: value
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

        const idProvaSalva = 1 //await adicionarProva(prova)

        this.setState({
            idProva: idProvaSalva,
            deveRenderizarQuestoes: true
        })
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

    renderArrayQuestoes() {
        return (
            this.state.arrayStates.map((item, key) => {
                return <AdicionarQuestao
                        key ={key}
                        tipo={item.tipo}
                        especificidade={item.especificidade}
                        nivel={item.nivel}
                        quantidade={item.quantidade}
                        onChange={this.handleChange}
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
                    <BotaoAdicionar nome="+" onClick={this.handleClickAdicionarQuestao} />
                    <BotaoPrincipal nome="Enviar" onClick={this.handleClickEnviarProva} />
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
                        type="text"
                        label="Digite o email do candidato"
                        placeholder="" />

                    <Input
                        name="duracao"
                        value={this.state.duracao}
                        onChange={this.handleChange}
                        type="number"
                        label="Tempo de duração da prova"
                        placeholder="" />

                    <Input
                        name="tempoParaIniciarProva"
                        value={this.state.tempoParaIniciarProva}
                        onChange={this.handleChange}
                        type="number"
                        label="Tempo para iniciar a prova"
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
            <div className="tela-cadastro">
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
