import axios from 'axios'

let token

const carregarToken = () => {
	if (!token) {
    token = localStorage.getItem('accessToken');
  }
  return token
}

const httpClient = (baseUrl) => axios.create({
  timeout: 30000000,
  headers: {
    'Content-type': 'application/json',
    Authorization: carregarToken()
  },
  baseURL: baseUrl
})

export class BaseService {
  constructor() {
    this.client = httpClient(`http://localhost:8100/cwi-turing`)
  }

  async get(url, config) {
    return await this.client.get(url, config)
  }

  async post(url, body, config) {
    return await this.client.post(url, body, config)
  }

  async put(url, body, config) {
    return await this.client.put(url, body, config)
  }

  async delete(url, config) {
    return await this.client.delete(url, config)
  }
}
