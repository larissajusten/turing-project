import Axios from 'axios';
import { baseUrl } from '../baseUrl';

let token;

function carregarToken() {
	if (!token) {
		token = localStorage.getItem('accessToken');
	}
}

export const retornarEspecificidades = async () => {
	carregarToken();
	const response = await Axios.get(`${baseUrl}/dominio/especificidade`,
	{ headers: { Authorization: token } });
	return response.data;
}

export const retornarNiveisDeDificuldade = async () => {
	carregarToken();
	const response = await Axios.get(`${baseUrl}/dominio/dificuldade`,
	{ headers: { Authorization: token } });
	return response.data;
}

export const retornarTipoDeQuestao = async () => {
	const response = await Axios.get(`${baseUrl}/dominio/tipo`)
	return response.data;
}
