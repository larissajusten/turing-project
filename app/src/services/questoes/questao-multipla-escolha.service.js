import Axios from 'axios'
import { baseUrl } from '../baseUrl'

const token = localStorage.getItem("accessToken")

export const adicionaQuestaoMultiplaEscolha = async (questao) => {
  const response = await Axios.post(`${baseUrl}/questao-multipla-escolha`, questao)
  return response.data
}

export const retornaQuestoesMultiplaEscolhas = async () => {
  const response = await Axios.get(`${baseUrl}/questao-multipla-escolha/buscar-todas`)
  return response.data
}
