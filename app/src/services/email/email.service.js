import Axios from 'axios'
import { baseUrl } from '../baseUrl'

let token;

function carregarToken() {
	if (!token) {
		token = localStorage.getItem('accessToken');
	}
}

export const enviarEmail = async (emailCandidato) => {
	carregarToken();
	const response = await Axios.post(`${baseUrl}/email/${emailCandidato}/enviar`,
	{ headers: { Authorization: token } });
	return response.data;
}
