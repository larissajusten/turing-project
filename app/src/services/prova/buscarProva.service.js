import Axios from 'axios'
import { baseUrl } from '../baseUrl'

let token;

function carregarToken() {
	if (!token) {
		token = localStorage.getItem('accessToken');
	}
}

export const retornaProva = async (idProva) => {
  carregarToken();
  const response = await Axios.get(`${baseUrl}/buscar-prova/${idProva}`,
  { headers: { Authorization: token }})
  return response.data
}

export const retornaProvaPorToken = async (token) => {
  carregarToken();
  const response = await Axios.get(`${baseUrl}/buscar-prova/token/${token}`,
  { headers: { Authorization: token }})
  return response.data
}

export const retornaProvasParaCorrecao = async (paginaAtual) => {
  carregarToken();
  const response = await Axios.get(`${baseUrl}/buscar-prova/para-correcao?page=${paginaAtual}`,
  { headers: { Authorization: token }})
  return [response.data.content, response.data.totalPages, response.data.numberOfElements, response.data.pageable.pageNumber]
}

export const retornarProvaParaCorrigir = async (idProva) => {
  carregarToken();
  const response = await Axios.get(`${baseUrl}/buscar-prova/${idProva}/respostas`,
  { headers: { Authorization: token }})
  return response.data
}

export const retornaProvasCorrigidas = async (pesquisa) => {
  carregarToken();
  const response = await Axios.get(`${baseUrl}/buscar-prova/corrigidas`,
  { headers: {Authorization: token}, params: {pesquisa: pesquisa} } )
  return response.data
}

export const retornaProvaCorrigidaParaPDF = async (idProva) => {
  carregarToken();
  const response = await Axios.get(`${baseUrl}/buscar-prova/${idProva}/corrigida`,
  { headers: { Authorization: token }})
  return response.data
}
