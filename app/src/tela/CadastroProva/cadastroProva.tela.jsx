import React, { Component } from 'react';
import { Input, BotaoPrincipal, EscolherQuestao} from '../../component/index'
import { adicionarProva, retornarEspecificidades, retornarNiveisDeDificuldade } from '../../services/index'
import './cadastroProva.style.css'

export class CadastrarProvaScreen extends Component {

    constructor(props){
        super(props)
        this.state = {
          tipos: [ 'Dissertativa', 'Múltipla Escolha', 'Técnica'],
          especificidades: [],
          niveis: [],
          email: '',
          duracao: '',
          tempoParaIniciarProva:'',
          deveRenderizarEscolhaQuestoes: false
        }
    }

    async componentDidMount() {
		this.setState({
			especificidades: await retornarEspecificidades(),
			niveis: await retornarNiveisDeDificuldade()
		})
	}

    handleClickEnviarProva = async (event) => {
        event.preventDefault()

        const questao = {
            "email": this.state.email,
            "duracao": this.state.duracao,
            "tempoParaIniciarProva": this.state.tempoParaIniciarProva
        }

        //await adicionarProva(questao)

        this.setState({
            deveRenderizarEscolhaQuestoes: true
        })
    }

    handleChange = (event) => {
        const { name, value } = event.target
        this.setState({
            [name]: value
        })
    }

    renderEscolhaQuestoes() {
        return(
            <div className="container-inputs-prova">
            <EscolherQuestao 
                tipo = {this.state.tipo}
                especificidade = {this.state.especificidade}
                nivel = {this.state.nivel}
                tipos = {this.state.tipos}
                especificidades = {this.state.especificidades}
                niveis = {this.state.niveis}
                handleChange = {this.handleChange}/>
                
            <Input
                name="email"
                value={this.state.email}
                onChange={this.handleChange}
                className="input-quantidade"
                type="text"
                label="Digite o email do candidato"
                placeholder=""/>
            </div>
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
                type="time"
                label="Tempo de duração da prova"
                placeholder=""/>

            <Input
                name="tempoParaIniciarProva"
                value={this.state.tempoParaIniciarProva}
                onChange={this.handleChange}
                type="time"
                label="Tempo para iniciar a prova"
                placeholder=""/>
        </div>
        </>
        )
    }

    render() {
        return (
            <div className="tela-cadastro">
                {
                    this.state.deveRenderizarEscolhaQuestoes
                    ?
                    this.renderEscolhaQuestoes()
                    :
                    this.renderInputsProva()
                }

                <div className="container-botao">
					<BotaoPrincipal nome="Enviar" onClick={this.handleClickEnviarProva}/>
				</div>
            </div>
        )
    }
}
