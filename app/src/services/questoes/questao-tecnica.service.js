import Axios from 'axios'
import { baseUrl } from '../baseUrl'

export const adicionarQuestaoTecnica = async (questao) => {
  const response = await Axios.post(`${baseUrl}/questao-tecnica`, questao)
  return response.data
}

export const retornarQuestoesTecnicasFiltradas = async (busca) => {
  const response = await Axios.put(`${baseUrl}/questao-tecnica/todas-questoes-filtradas`, busca)
  return response.data
}

export const retornarQuestoesTecnicasRandomicasFiltradas = async (buscaRandomica) => {
  const response = await Axios.put(`${baseUrl}/questao-tecnica`, buscaRandomica)
  return response.data
}
