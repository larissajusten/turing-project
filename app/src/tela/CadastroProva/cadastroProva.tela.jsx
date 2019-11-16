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
          idProva: ''
        }
        this.quantidadeParaAdicionar = 1
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
            idProva: idProvaSalva
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
            <BotaoPrincipal nome="Enviar" onClick={this.handleClickEnviarProva}/>
        </div>
        </>
        )
    }

    render() {
        return (
            <div className="tela-cadastro">
                {this.renderInputsProva()}
                {this.renderEscolhaDeQuestoes()}
            </div>
        )
    }
}
