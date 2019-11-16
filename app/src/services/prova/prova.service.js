import Axios from 'axios'
import { baseUrl } from '../baseUrl'

export const adicionarProva = async (prova) => {
  const response = await Axios.post(`${baseUrl}/prova`, prova)
  return response.data
}

export const incluirDissertativas = async (idProva, questao) => {
  const response = await Axios.put(`${baseUrl}/prova/${idProva}/incluir-dissertativa`, questao)
  return response.data
}

export const incluirTecnicas = async (idProva, questao) => {
  const response = await Axios.put(`${baseUrl}/prova/${idProva}/incluir-tecnica`, questao)
  return response.data
}

export const incluirMultiplaEscolha = async (idProva, questao) => {
  const response = await Axios.put(`${baseUrl}/prova/${idProva}/incluir-multipla-escolha`, questao)
  return response.data
}