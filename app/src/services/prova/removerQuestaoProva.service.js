import { BaseService } from '../_base/base.service'

export class RemoverQuestaoProvaService extends BaseService {
	async removerQuestaoDissertativa(idProva, idQuestao){
		const response = await super.delete(`prova/${idProva}/dissertativa/${idQuestao}`)
		return response.data;
  }

  async removerQuestaoTecnica(idProva, idQuestao){
		const response = await super.delete(`prova/${idProva}/tecnica/${idQuestao}`)
		return response.data;
  }

  async removerQuestaoMultiplaEscolha(idProva, idQuestao){
		const response = await super.delete(`prova/${idProva}/multipla/${idQuestao}`)
		return response.data;
  }
}
