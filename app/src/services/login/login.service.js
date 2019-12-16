import Axios from 'axios'

export const login = async (user) => {
  const response = await Axios.post(`http://localhost:8100/cwi-turing/login`, user)
  return response.data
}
