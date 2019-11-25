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
	const response = await Axios.post(`${baseUrl}/prova`, prova, { headers: { Authorization: token } });
	return response.data;
};

export const iniciarProva = async (idProva) => {
	const response = await Axios.put(`${baseUrl}/prova/${idProva}/iniciar-prova`, 
	{ headers: { Authorization: token } });
	return response.data;
};

export const enviarRespostasDaProva = async (idProva, respostas) => {
	const response = await Axios.put(`${baseUrl}/prova/${idProva}/finalizar-prova`, respostas, 
	{ headers: { Authorization: token }});
	return response.data;
};

export const corrigirProva = async (idProva, body) => {
	const response = await Axios.put(`${baseUrl}/prova/${idProva}/corrigir-prova`, body, 
	{ headers: { Authorization: token } });
	return response.data;
};

export const retornarResultadosMultipla = async (especificidade) => {
	const response = await Axios.put(`${baseUrl}/dashboard/${especificidade}/multiplas`,
	{ headers: { Authorization: token } });
	return response.data;
};

export const retornarResultadosDissertativa = async (especificidade) => {
	const response = await Axios.put(`${baseUrl}/dashboard/${especificidade}/dissertativas`,
	{ headers: { Authorization: token } });
	return response.data;
};

export const retornarResultadosTecnica = async (especificidade) => {
	const response = await Axios.put(`${baseUrl}/dashboard/${especificidade}/tecnicas`,
	{ headers: { Authorization: token } });
	return response.data;
};

