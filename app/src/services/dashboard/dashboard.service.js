import { BaseService } from '../_base/base.service'

export class DashboardService extends BaseService {
	async retornaTecnologias(){
		const response = await super.get(`dashboard`)
		return response.data;
	}

	async retornarResultadosMultipla(especificidade){
		const response = await super.get(`dashboard/${especificidade}/multipla`)
		return response.data;
	}

	async retornarResultadosDissertativa(especificidade){
		const response = await super.get(`dashboard/${especificidade}/dissertativa`)
		return response.data;
	}

	async retornarResultadosTecnica(especificidade){
		const response = await super.get(`dashboard/${especificidade}/tecnica`)
		return response.data;
	}
}
