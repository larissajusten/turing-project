import { BaseService } from '../_base/base.service'

export class QuestaoMultiplaEscolhaService extends BaseService {
  async adicionarQuestaoMultiplaEscolha(questao) {
    return await super.post(`multipla`, questao)
  }

  async retornarQuestoesMultiplasEscolhasFiltradas(paginaAtual, especificidade, nivel) {
    const response = await super.get(`multipla/filtrar?page=${paginaAtual}`,
      { params: {especificidade: especificidade, nivel: nivel} })
    return [response.data.content, response.data.totalElements, response.data.numberOfElements, response.data.number]
  }
}
