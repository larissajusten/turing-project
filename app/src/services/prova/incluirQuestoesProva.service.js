import Axios from 'axios'
import { baseUrl } from '../baseUrl'

let token;

function carregarToken() {
	if (!token) {
		token = localStorage.getItem('accessToken');
	}
}

export const incluirDissertativas = async (idProva, questao) => {
  carregarToken();
  const response = await Axios.put(`${baseUrl}/incluir/${idProva}/incluir-dissertativa`, questao,
  { headers: { Authorization: token }})
  return response.data
}

export const incluirTecnicas = async (idProva, questao) => {
  carregarToken();
  const response = await Axios.put(`${baseUrl}/incluir/${idProva}/incluir-tecnica`, questao,
  { headers: { Authorization: token }})
  return response.data
}

export const incluirMultiplaEscolha = async (idProva, questao) => {
  carregarToken();
  const response = await Axios.put(`${baseUrl}/incluir/${idProva}/incluir-multipla-escolha`, questao,
  { headers: { Authorization: token }})
  return response.data
}
