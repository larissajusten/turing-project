import { BaseService } from '../_base/base.service'

export class DominioService extends BaseService {
	async retornarEspecificidades() {
		const response = await super.get(`dominio/especificidade`)
		return response.data;
	}

	async retornarNiveisDeDificuldade() {
		const response = await super.get(`dominio/dificuldade`)
		return response.data;
	}

	async retornarTipoDeQuestao() {
		const response = await super.get(`dominio/tipo`)
		return response.data;
	}
}
