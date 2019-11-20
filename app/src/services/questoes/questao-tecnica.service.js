import Axios from 'axios'
import { baseUrl } from '../baseUrl'

export const adicionarQuestaoTecnica = async (questao) => {
  const response = await Axios.post(`${baseUrl}/questao-tecnica`, questao)
  return response.data
}

export const retornarQuestoesTecnicasFiltradas = async (paginaAtual, busca) => {
  const response = await Axios.put(`${baseUrl}/questao-tecnica/todas-questoes-filtradas?page=${paginaAtual}`, busca)
  const dados = [response.data.content, response.data.totalElements, response.data.numberOfElements, response.data.number]
  return dados
}
