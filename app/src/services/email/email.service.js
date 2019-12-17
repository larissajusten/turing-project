import { BaseService } from '../_base/base.service'

export class EmailService extends BaseService {
	async enviarEmail(emailCandidato){
		await super.post(`email/${emailCandidato}`)
	}

	async enviarEmailCrescer(emailDoResponsavel){
		await super.post(`email/crescer/${emailDoResponsavel}`)
	}
}
