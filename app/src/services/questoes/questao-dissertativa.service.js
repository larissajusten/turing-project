import Axios from 'axios'
import { baseUrl } from '../baseUrl'

export const adicionarQuestaoDissertativa = async (questao) => {
  const response = await Axios.post(`${baseUrl}/questao-dissertativa`, questao)
  return response.data
}

export const retornarQuestoesDissertativasFiltradas = async (paginaAtual, especificidade, nivel) => {
  const response = await Axios.get(`${baseUrl}/questao-dissertativa/todas-questoes-filtradas/${especificidade}/${nivel}?page=${paginaAtual}`)
  console.log(response)
  const dados = [response.data.content, response.data.totalPages, response.data.numberOfElements, response.data.pageable.pageNumber]
  return dados
}
