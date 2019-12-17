import { BaseService } from '../_base/base.service'

export class ProvaService extends BaseService {
  async criarProva(prova) {
		const response = await super.post(`prova`, prova)
		return response.data
	}
	
	async iniciarProva(idProva) {
		await super.put(`prova/${idProva}/iniciar`)
	}
	
	async enviarRespostasDaProva(idProva, prova) {
		const response =  await super.put(`prova/${idProva}/finalizar`, prova)
		return response.data;
	}
	
	async corrigirProva(idProva, correcao) {
		const response =  await super.put(`prova/${idProva}/corrigir`, correcao)
		return response.data;
	}

	async cancelarProva(idProva, correcao) {
		const response =  await super.put(`prova/${idProva}/cancelar`)
		return response.data;
	}
}
