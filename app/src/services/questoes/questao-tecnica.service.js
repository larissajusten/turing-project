import Axios from 'axios'
import { baseUrl } from '../baseUrl'

export const adicionarQuestaoTecnica = async (questao) => {
  const response = await Axios.post(`${baseUrl}/questao-tecnica`, questao)
  return response.data
}

export const retornarQuestoesTecnicasFiltradas = async (paginaAtual, especificidade, nivel) => {
  const response = await Axios.get(`${baseUrl}/questao-tecnica/todas-questoes-filtradas/${especificidade}/${nivel}?page=${paginaAtual}`)
  return [response.data.content, response.data.totalElements, response.data.numberOfElements, response.data.number]
}
