import Axios from 'axios'
import { baseUrl } from '../baseUrl'

const token = localStorage.getItem("accessToken")

export const adicionaQuestaoTecnica = async (questao) => {
  const response = await Axios.post(`${baseUrl}/questao-tecnica`, questao)
  return response.data
}

export const retornaQuestoesTecnicas = async (busca) => {
  const response = await Axios.get(`${baseUrl}/questao-tecnica`, busca)
  return response.data
}
