import Axios from 'axios'
import { baseUrl } from '../baseUrl'

let token;

function carregarToken() {
	if (!token) {
		token = localStorage.getItem('accessToken');
	}
}

export const adicionarQuestaoTecnica = async (questao) => {
  carregarToken();
  const response = await Axios.post(`${baseUrl}/prova/questao/tecnica`, questao,
  { headers: { Authorization: token }})
  return response.data
}

export const retornarQuestoesTecnicasFiltradas = async (paginaAtual, especificidade, nivel) => {
  carregarToken();
  const response = await Axios.get(`${baseUrl}/tecnica/filtrar?page=${paginaAtual}`,
  { headers: { Authorization: token }, params: {especificidade: especificidade, nivel: nivel} })
  return [response.data.content, response.data.totalElements, response.data.numberOfElements, response.data.number]
}

export const retornaQuestaoTecnicaParaBaixar = async (idResposta) => {
  carregarToken();
  const response = await Axios.get(`${baseUrl}/download/${idResposta}`,
  { headers: { Authorization: token }})
  return response.data
}
