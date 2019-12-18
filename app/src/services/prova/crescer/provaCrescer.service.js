import { BaseService } from '../../_base/base.service'

export class ProvaCrescerService extends BaseService {
  async criarProvaCrescer(provaCrescer) {
    await super.post(`prova/crescer`, provaCrescer)
  }

  async iniciarProvaCrescer(idProvaCrescer, nome, email) {
    const body = { nomeCandidato: nome, email }
    await super.put(`prova/${idProvaCrescer}/crescer`, body)
  }
}
