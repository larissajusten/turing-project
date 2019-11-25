import Axios from 'axios'
import { baseUrl } from '../baseUrl'

let token = localStorage.getItem('accessToken')

export const adicionarQuestaoMultiplaEscolha = async (questao) => {
  const response = await Axios.post(`${baseUrl}/questao-multipla-escolha`, questao, { headers: { Authorization: token }})
  return response.data
}

export const retornarQuestoesMultiplasEscolhasFiltradas = async (paginaAtual, especificidade, nivel) => {
  const response = await Axios.get(`${baseUrl}/questao-multipla-escolha/todas-questoes-filtradas?page=${paginaAtual}`,
    { headers: { Authorization: token }, params: {especificidade: especificidade, nivel: nivel} })
  return [response.data.content, response.data.totalElements, response.data.numberOfElements, response.data.number]
}
