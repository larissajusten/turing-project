import { BaseService } from '../_base/base.service'

export class BuscarProvaService extends BaseService {
  async retornaProva(idProva) {
		const response = await super.get(`prova/${idProva}`)
		return response.data
  }

  async retornaProvaPorToken(token) {
		const response = await super.get(`prova/token/${token}`)
		return response.data
  }

  async retornaProvasParaCorrecao(paginaAtual) {
    const response = await super.get(`prova/correcao?page=${paginaAtual}`)
    return [response.data.content, response.data.totalPages, response.data.numberOfElements, response.data.pageable.pageNumber]
  }

  async retornarProvaParaCorrigir(idProva) {
		const response = await super.get(`prova/${idProva}/corrigir`)
		return response.data
  }

  async retornaProvasCorrigidas(pesquisa) {
    const response = await super.get(`prova/corrigida`,
    { params: {pesquisa: pesquisa} })
		return response.data
  }

  async retornaProvaCorrigidaParaPDF(idProva) {
    const response = await super.get(`prova/${idProva}/corrigida`)
		return response.data
  }
}
