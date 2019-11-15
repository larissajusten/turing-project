import Axios from 'axios'
import { baseUrl } from '../baseUrl'

export const adicionarProva = async (prova) => {
  const response = await Axios.post(`${baseUrl}/prova`, prova)
  return response.data
}