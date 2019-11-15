import Axios from 'axios'
import { baseUrl } from '../baseUrl'

export const adicionaQuestaoDissertativa = async (questao) => {
  const response = await Axios.post(`${baseUrl}/questao-dissertativa`, questao)
  return response.data
}
