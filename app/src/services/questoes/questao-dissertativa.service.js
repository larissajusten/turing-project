import Axios from 'axios'
import { baseUrl } from '../baseUrl'

export const adicionarQuestaoDissertativa = async (questao) => {
  const response = await Axios.post(`${baseUrl}/questao-dissertativa`, questao)
  return response.data
}

export const retornarQuestoesDissertativasFiltradas = async (busca) => {
  const response = await Axios.put(`${baseUrl}/questao-dissertativa/todas-questoes-filtradas`, busca)
  return response.data
}
