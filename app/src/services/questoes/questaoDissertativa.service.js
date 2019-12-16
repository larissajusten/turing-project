import { BaseService } from '../_base/base.service'

export class QuestaoDissertativaService extends BaseService {
  async adicionarQuestaoDissertativa(questao) {
    const response = await super.post(`dissertativa`, questao)
    return response.data
  }

  async retornarQuestoesDissertativasFiltradas(paginaAtual, especificidade, nivel) {
    const response = await super.get(`dissertativa/filtrar?page=${paginaAtual}`,
      { params: { especificidade: especificidade, nivel: nivel } })
    return [response.data.content, response.data.totalElements, response.data.numberOfElements, response.data.number]
  }
}
