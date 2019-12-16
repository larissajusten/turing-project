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
		const response = await super.get(`dominio/tipoDeQuestao`)
		return response.data;
	}

	async retornarTipoDeProva() {
		const response = await super.get(`dominio/tipoDeProva`)
		return response.data;
	}
}
