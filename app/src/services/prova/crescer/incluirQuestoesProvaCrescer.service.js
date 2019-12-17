import { BaseService } from '../_base/base.service'

export class IncluirQuestoesProvaCrescerService extends BaseService {
  async incluirDissertativas(questoesCrescer) {
		await super.put(`prova/crescer/dissertativa`, questoesCrescer)
	}

	async incluirTecnicas(questoesCrescer) {
		await super.put(`prova/crescer/tecnica`, questoesCrescer)
	}

	async incluirMultiplaEscolha(questoesCrescer) {
		await super.put(`prova/crescer/multipla`, questoesCrescer)
	}
}
