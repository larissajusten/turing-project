import axios from 'axios'
import { baseUrl } from './baseUrl.js'

const carregarToken = () => {
  let token
	if (!token) {
		token = localStorage.getItem('accessToken');
  }
  return token
}

const httpClient = () => axios.create({
  timeout: 30000,
  headers: {
    'Content-type': 'application/json',
    Authorization: carregarToken()
  },
  baseUrl
})

export class BaseService {
  constructor() {
    this.client = httpClient()
  }

  async get(url) {
    const result = await this.client.get(url)
    return result.data
  }

  async put(url) {
    const result = await this.client.get(url)
    return result.data
  }
}