import { BaseService } from '../_base/base.service'

export class EmailService extends BaseService {
	async enviarEmail(emailCandidato){
		const response = await super.get(`email/${emailCandidato}`)
		return response.data;
	}
}
