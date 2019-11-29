import Axios from 'axios';
import { baseUrl } from '../baseUrl';

let token;

function carregarToken() {
	if (!token) {
		token = localStorage.getItem('accessToken');
	}
}

export const criarProva = async (prova) => {
	carregarToken();
	const response = await Axios.post(`${baseUrl}/prova`, prova,
	{ headers: { Authorization: token } });
	return response.data;
}

export const iniciarProva = async (idProva) => {
	carregarToken();
	const response = await Axios.put(`${baseUrl}/prova/${idProva}/iniciar-prova`,
	{ headers: { Authorization: token } });
	return response.data;
}

export const enviarRespostasDaProva = async (idProva, respostas) => {
	carregarToken();
	const response = await Axios.put(`${baseUrl}/prova/${idProva}/finalizar-prova`, respostas,
	{ headers: { Authorization: token }});
	return response.data;
}

export const corrigirProva = async (idProva, body) => {
	carregarToken();
	const response = await Axios.put(`${baseUrl}/prova/${idProva}/corrigir-prova`, body,
	{ headers: { Authorization: token } });
	return response.data;
}

export const cancelarProva = async (idProva) => {
	carregarToken();
	const response = await Axios.put(`${baseUrl}/prova/${idProva}/cancelar-prova`,
	{ headers: { Authorization: token } });
	return response.data;
}
