import Axios from 'axios';
import { BaseService } from '../_base/base.service'
//import { baseUrl } from '../_base/baseUrl';

export class DashboardService extends BaseService {
	async retornaTecnologias(){
		const response = await super.get(`dashboard`)
		return response.data;
	}

	async retornarResultadosMultipla(especificidade){
		const response = await super.get(`dashboard/${especificidade}/multiplas`)
		return response.data;
	}

	async retornarResultadosDissertativa(especificidade){
		const response = await super.get(`dashboard/${especificidade}/dissertativas`)
		return response.data;
	}

	async retornarResultadosTecnica(especificidade){
		const response = await super.get(`dashboard/${especificidade}/tecnicas`)
		return response.data;
	}
}

// let token;

// function carregarToken() {
// 	if (!token) {
// 		token = localStorage.getItem('accessToken');
// 	}
// }

// export const retornaTecnologias = async () => {
// 	carregarToken();
// 	const response = await Axios.get(`${baseUrl}/dashboard`,
// 	{ headers: { Authorization: token } });
// 	return response.data;
// }

// export const retornarResultadosMultipla = async (especificidade) => {
// 	carregarToken();
// 	const response = await Axios.get(`${baseUrl}/dashboard/${especificidade}/multiplas`,
// 	{ headers: { Authorization: token } });
// 	return response.data;
// }

// export const retornarResultadosDissertativa = async (especificidade) => {
// 	carregarToken();
// 	const response = await Axios.get(`${baseUrl}/dashboard/${especificidade}/dissertativas`,
// 	{ headers: { Authorization: token } });
// 	return response.data;
// };

// export const retornarResultadosTecnica = async (especificidade) => {
// 	carregarToken();
// 	const response = await Axios.get(`${baseUrl}/dashboard/${especificidade}/tecnicas`,
// 	{ headers: { Authorization: token } });
// 	return response.data;
// };
