import { BaseService } from '../_base/base.service'

export class IncluirQuestoesProvaService extends BaseService {
  async incluirDissertativas(idProva, questao) {
		const response = await super.post(`prova/${idProva}/dissertativa`, questao)
		return response.data
	}

	async incluirTecnicas(idProva, questao) {
		const response = await super.post(`prova/${idProva}/tecnica`, questao)
		return response.data
	}

	async incluirMultiplaEscolha(idProva, questao) {
		const response = await super.post(`prova/${idProva}/multipla`, questao)
		return response.data
	}
}
