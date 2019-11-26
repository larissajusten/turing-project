import Axios from 'axios'
import { baseUrl } from '../baseUrl'

let token;

function carregarToken() {
	if (!token) {
		token = localStorage.getItem('accessToken');
	}
}
export const removerQuestaoDissertativa = async (idProva, idQuestao) => {
  carregarToken();
  const response = await Axios.delete(`${baseUrl}/excluir/${idProva}/dissertativa/${idQuestao}`,
  { headers: { Authorization: token }})
  return response.data
}

export const removerQuestaoTecnica = async (idProva, idQuestao) => {
  carregarToken();
  const response = await Axios.delete(`${baseUrl}/excluir/${idProva}/tecnica/${idQuestao}`,
  { headers: { Authorization: token }})
  return response.data
}

export const removerQuestaoMultiplaEscolha = async (idProva, idQuestao) => {
  carregarToken();
  const response = await Axios.delete(`${baseUrl}/excluir/${idProva}/multipla-escolha/${idQuestao}`,
  { headers: { Authorization: token }})
  return response.data
}
