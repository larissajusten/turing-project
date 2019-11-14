import Axios from 'axios'
import { baseUrl } from '../baseUrl'

const token = localStorage.getItem("accessToken")

export const retornaQuestoesMultiplasEscolhas = async () => {
  const response = await Axios.get(`${baseUrl}/questao-multipla-escolha/buscar-todas`)
  return response.data
}

export const adicionaQuestaoTecnica = async (questao) => {
  const response = await Axios.post(`${baseUrl}/questao-multipla-escolha`, questao)
  return response.data
}