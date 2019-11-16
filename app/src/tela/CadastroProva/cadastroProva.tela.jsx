import React, { Component } from 'react';
import { Input, BotaoPrincipal, AdicionarQuestao } from '../../component/index'
import { adicionarProva } from '../../services/index'
import './cadastroProva.style.css'

export class CadastrarProvaScreen extends Component {

    constructor(props){
        super(props)
        this.state = {
          email: '',
          duracao: 0,
          tempoParaIniciarProva: 0,
          idProva: '',
          deveRenderizarQuestoes: false
        }
    }
    
    handleChange = (event) => {
        const { name, value } = event.target
        this.setState({
            [name]: value
        })
    }

    handleClickEnviarProva = async (event) => {
        event.preventDefault()

        const prova = {
            "email": this.state.email,
            "tempoDeDuracaoDaProva": this.state.duracao,
            "tempoParaInicioProva": this.state.tempoParaIniciarProva
        }

        const idProvaSalva = await adicionarProva(prova)

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
    renderEscolhaDeQuestoes() {
        return(
            <>
            <div className="container-titulo">
                <span className="titulo-crie">Adicione questões a sua prova</span>
            </div>

            <AdicionarQuestao
                idProva = {this.state.idProva}/>
            <div className="container-botao">
                <BotaoPrincipal nome="Voltar" onClick={this.handleClickVoltarProva}/>
            </div>
            </>
        )
    }

    renderInputsProva(){
        return(
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
                placeholder=""/>

            <Input
                name="duracao"
                value={this.state.duracao}
                onChange={this.handleChange}
                type="number"
                label="Tempo de duração da prova"
                placeholder=""/>

            <Input
                name="tempoParaIniciarProva"
                value={this.state.tempoParaIniciarProva}
                onChange={this.handleChange}
                type="number"
                label="Tempo para iniciar a prova"
                placeholder=""/>
        </div>

        <div className="container-botao">
            <BotaoPrincipal nome="Adicionar questões" onClick={this.handleClickEnviarProva}/>
        </div>
        </>
        )
    }

    render() {
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
