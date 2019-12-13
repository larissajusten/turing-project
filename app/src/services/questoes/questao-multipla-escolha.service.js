import Axios from 'axios'
import { baseUrl } from '../baseUrl'

let token;

function carregarToken() {
	if (!token) {
		token = localStorage.getItem('accessToken');
	}
}

export const adicionarQuestaoMultiplaEscolha = async (questao) => {
  carregarToken();
  const response = await Axios.post(`${baseUrl}/prova/questao/multipla`, questao,
  { headers: { Authorization: token }})
  return response.data
}

export const retornarQuestoesMultiplasEscolhasFiltradas = async (paginaAtual, especificidade, nivel) => {
  carregarToken();
  const response = await Axios.get(`${baseUrl}/multipla/todas-questoes-filtradas?page=${paginaAtual}`,
  { headers: { Authorization: token }, params: {especificidade: especificidade, nivel: nivel} })
  return [response.data.content, response.data.totalElements, response.data.numberOfElements, response.data.number]
}
