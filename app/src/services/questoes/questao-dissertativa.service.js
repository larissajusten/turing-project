import Axios from 'axios'
import { baseUrl } from '../baseUrl'

const token = localStorage.getItem("accessToken")

export const adicionaQuestaoDissertativa = async (questao) => {
  const response = await Axios.post(`${baseUrl}/questao-dissertativa`, questao)
  return response.data
}