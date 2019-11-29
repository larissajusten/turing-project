import Axios from 'axios';
import { baseUrl } from '../baseUrl';

let token;

function carregarToken() {
	if (!token) {
		token = localStorage.getItem('accessToken');
	}
}

export const retornaTecnologias = async () => {
	carregarToken();
	const response = await Axios.get(`${baseUrl}/dashboard`,
	{ headers: { Authorization: token } });
	return response.data;
}

export const retornarResultadosMultipla = async (especificidade) => {
	carregarToken();
	const response = await Axios.get(`${baseUrl}/dashboard/${especificidade}/multiplas`,
	{ headers: { Authorization: token } });
	return response.data;
}

export const retornarResultadosDissertativa = async (especificidade) => {
	carregarToken();
	const response = await Axios.get(`${baseUrl}/dashboard/${especificidade}/dissertativas`,
	{ headers: { Authorization: token } });
	return response.data;
};

export const retornarResultadosTecnica = async (especificidade) => {
	carregarToken();
	const response = await Axios.get(`${baseUrl}/dashboard/${especificidade}/tecnicas`,
	{ headers: { Authorization: token } });
	return response.data;
};
