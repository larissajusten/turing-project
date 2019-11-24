import Axios from 'axios'
import { baseUrl } from '../baseUrl'

let token = localStorage.getItem('accessToken')

export const retornaProva = async (idProva) => {
  const response = await Axios.get(`${baseUrl}/buscar-prova/${idProva}`, { headers: { Authorization: token }})
  return response.data
}

export const retornaProvaPorToken = async (token) => {
  const response = await Axios.get(`${baseUrl}/buscar-prova/token/${token}`, { headers: { Authorization: token }})
  console.log(response)
  return response.data
}

export const retornaProvasParaCorrecao = async (paginaAtual) => {
  const response = await Axios.get(`${baseUrl}/buscar-prova/para-correcao?page=${paginaAtual}`, { headers: { Authorization: token }})
  return [response.data.content, response.data.totalPages, response.data.numberOfElements, response.data.pageable.pageNumber]
}

export const retornarProvaParaCorrigir = async (idProva) => {
  const response = await Axios.get(`${baseUrl}/buscar-prova/${idProva}/respostas`, { headers: { Authorization: token }})
  return response.data
}

export const retornaProvasCorrigidas = async (pesquisa) => {
  const response = await Axios.get(`${baseUrl}/buscar-prova/corrigidas`, { headers: {Authorization: token}, params: {pesquisa: pesquisa} } )
  console.log(response.data)
  return response.data
}

export const retornaProvaCorrigidaParaPDF = async (idProva) => {
  const response = await Axios.get(`${baseUrl}/buscar-prova/${idProva}/corrigida`, { headers: { Authorization: token }})
  return response.data
}
