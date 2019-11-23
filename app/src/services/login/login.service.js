import Axios from 'axios'
import { baseUrl } from '../baseUrl'

let token = localStorage.getItem('accessToken')

export const login = async (user) => {
  const response = await Axios.post(`${baseUrl}/login`, user)
  return response.data
}

export const retornaPerfil = async (perfil) => {
  const response = await Axios.get(`${baseUrl}/login/${perfil}`, { headers: { Authorization: token }})
  return response.data
}
