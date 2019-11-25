import Axios from 'axios';
import { baseUrl } from '../baseUrl';

let token = localStorage.getItem('accessToken');

export const retornarEspecificidades = async () => {
	const response = await Axios.get(`${baseUrl}/dominio/especificidades`, { headers: { Authorization: token } });
	return response.data;
};

export const retornarNiveisDeDificuldade = async () => {
	const response = await Axios.get(`${baseUrl}/dominio/niveis-dificuldade`, { headers: { Authorization: token } });
	return response.data;
};

export const retornarTipoDeQuestao = async () => {
	const response = await Axios.get(`${baseUrl}/dominio/tipo-de-questao`, { headers: { Authorization: token } });
	return response.data;
};
