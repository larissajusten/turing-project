import Axios from 'axios'
import { baseUrl } from '../baseUrl'

let token = localStorage.getItem('accessToken')

export const adicionarQuestaoDissertativa = async (questao) => {
  const response = await Axios.post(`${baseUrl}/questao-dissertativa`, questao, { headers: { Authorization: token }})
  return response.data
}

export const retornarQuestoesDissertativasFiltradas = async (paginaAtual, especificidade, nivel) => {
  const response = await Axios.get(`${baseUrl}/questao-dissertativa/todas-questoes-filtradas?page=${paginaAtual}`, 
    { headers: { Authorization: token }, params: {especificidade: especificidade, nivel: nivel} })
  return [response.data.content, response.data.totalPages, response.data.numberOfElements, response.data.pageable.pageNumber]
}
