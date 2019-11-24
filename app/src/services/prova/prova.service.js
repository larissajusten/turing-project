import Axios from 'axios'
import { baseUrl } from '../baseUrl'

let token = localStorage.getItem('accessToken')

//adicionarProva
export const criarProva = async (prova) => {
  const response = await Axios.post(`${baseUrl}/prova`, prova, { headers: { Authorization: token }})
  return response.data
}

export const iniciarProva = async (idProva) => {
  const response = await Axios.put(`${baseUrl}/prova/${idProva}/iniciar-prova`, { headers: { Authorization: token }})
  return response.data
}

export const enviarRespostasDaProva = async (idProva, respostas) => {
  const response = await Axios.put(`${baseUrl}/prova/${idProva}/finalizar-prova`, respostas, { headers: { Authorization: token }})
  return response.data
}

export const corrigirProva = async (idProva, body) => {
  const response = await Axios.put(`${baseUrl}/prova/${idProva}/corrigir-prova`, body)
  return response.data
}

