import axios from 'axios';

const api = axios.create({
	baseURL: 'http://localhost:8100/cwi-turing'
	//Para quando tiver autenticação
	// headers: {
	// 	'Authorization': localStorage.getItem('token')
	// }
});

export default api;
