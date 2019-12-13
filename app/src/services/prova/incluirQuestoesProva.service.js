import Axios from 'axios';
import { baseUrl } from '../baseUrl';

let token;

function carregarToken() {
	if (!token) {
		token = localStorage.getItem('accessToken');
	}
}

export const incluirDissertativas = async (idProva, questao) => {
	carregarToken();
	const response = await Axios.put(`${baseUrl}/prova/${idProva}/dissertativa`, questao, {
		headers: { Authorization: token }
	});
	return response.data;
}

export const incluirTecnicas = async (idProva, questao) => {
	carregarToken();
	const response = await Axios.put(`${baseUrl}/prova/${idProva}/tecnica`, questao, {
		headers: { Authorization: token }
	});
	return response.data;
}

export const incluirMultiplaEscolha = async (idProva, questao) => {
	carregarToken();
	const response = await Axios.put(`${baseUrl}/prova/${idProva}/multipla`, questao, {
		headers: { Authorization: token }
	});
	return response.data;
}
