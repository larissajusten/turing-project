import Axios from 'axios'
import { baseUrl } from '../baseUrl'

export const adicionarQuestaoMultiplaEscolha = async (questao) => {
  const response = await Axios.post(`${baseUrl}/questao-multipla-escolha`, questao)
  return response.data
}

export const retornarQuestoesMultiplasEscolhasFiltradas = async (paginaAtual, busca) => {
  const response = await Axios.put(`${baseUrl}/questao-multipla-escolha/todas-questoes-filtradas?page=${paginaAtual}`, busca)
  const dados = [response.data.content, response.data.totalElements, response.data.numberOfElements, response.data.number]
  return dados
}
