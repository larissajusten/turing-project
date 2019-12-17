import { BaseService } from '../_base/base.service'

export class IncluirQuestoesProvaService extends BaseService {
  async incluirDissertativas(idProva, questoes) {
		await super.put(`prova/${idProva}/dissertativa`, questoes)
	}

	async incluirTecnicas(idProva, questoes) {
		await super.put(`prova/${idProva}/tecnica`, questoes)
	}

	async incluirMultiplaEscolha(idProva, questoes) {
		await super.put(`prova/${idProva}/multipla`, questoes)
	}
}
