import Axios from 'axios';
import { baseUrl } from '../_base/baseUrl';

let token;

function carregarToken() {
	if (!token) {
		token = localStorage.getItem('accessToken');
	}
}

export const retornarEspecificidades = async () => {
	carregarToken();
	const response = await Axios.get(`${baseUrl}/dominio/especificidades`,
	{ headers: { Authorization: token } });
	return response.data;
}

export const retornarNiveisDeDificuldade = async () => {
	carregarToken();
	const response = await Axios.get(`${baseUrl}/dominio/niveis-dificuldade`,
	{ headers: { Authorization: token } });
	return response.data;
}

export const retornarTipoDeQuestao = async () => {
	const response = await Axios.get(`${baseUrl}/dominio/tipo-de-questao`)
	return response.data;
}
