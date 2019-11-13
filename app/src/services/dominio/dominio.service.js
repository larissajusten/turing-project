import Axios from 'axios'
import { baseUrl } from '../baseUrl'

const token = localStorage.getItem("accessToken")

export const retornarEspecificidades = async () => {
  const response = await Axios.get(`${baseUrl}/dominio/especificidades`)
  return response.data
}

export const retornarNiveisDeDificuldade = async () => {
  const response = await Axios.get(`${baseUrl}/dominio/niveis-dificuldade`)
  return response.data
}
