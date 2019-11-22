import Axios from 'axios'
import { baseUrl } from '../baseUrl'

export const adicionarQuestaoMultiplaEscolha = async (questao) => {
  const response = await Axios.post(`${baseUrl}/questao-multipla-escolha`, questao)
  return response.data
}

export const retornarQuestoesMultiplasEscolhasFiltradas = async (paginaAtual, especificidade, nivel) => {
  const response = await Axios.get(`${baseUrl}/questao-multipla-escolha/todas-questoes-filtradas?page=${paginaAtual}`, 
    { params: {especificidade: especificidade, nivel: nivel} })
  return [response.data.content, response.data.totalElements, response.data.numberOfElements, response.data.number]
}
