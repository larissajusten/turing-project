import { BaseService } from '../_base/base.service'

export class EmailService extends BaseService {
	async enviarEmail(emailCandidato){
		const response = await super.post(`email/${emailCandidato}`)
		return response.data;
	}
}
