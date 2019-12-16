import { BaseService } from '../_base/base.service'

export class QuestaoTecnicaService extends BaseService {
  async adicionarQuestaoTecnica(questao) {
    const response = await super.post(`tecnica`, questao)
    return response.data
  }

  async retornarQuestoesTecnicasFiltradas(paginaAtual, especificidade, nivel) {
    const response = await super.get(`tecnica/filtrar?page=${paginaAtual}`,
      { params: {especificidade: especificidade, nivel: nivel} })
    return [response.data.content, response.data.totalElements, response.data.numberOfElements, response.data.number]
  }

  async retornaQuestaoTecnicaParaBaixar(idResposta) {
    const response = await super.get(`tecnica/download/${idResposta}`)
    return response.data
  }
}
