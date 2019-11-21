import Axios from 'axios'
import { baseUrl } from '../baseUrl'

export const adicionarProva = async (prova) => {
  const response = await Axios.post(`${baseUrl}/prova`, prova)
  return response.data
}

export const incluirDissertativas = async (idProva, questao) => {
  const response = await Axios.put(`${baseUrl}/prova/${idProva}/incluir-dissertativa`, questao)
  return response.data
}

export const incluirTecnicas = async (idProva, questao) => {
  const response = await Axios.put(`${baseUrl}/prova/${idProva}/incluir-tecnica`, questao)
  return response.data
}

export const incluirMultiplaEscolha = async (idProva, questao) => {
  const response = await Axios.put(`${baseUrl}/prova/${idProva}/incluir-multipla-escolha`, questao)
  return response.data
}

export const retornaProva = async (idProva) => {
  const response = await Axios.get(`${baseUrl}/prova/${idProva}/buscar-prova`)
  return response.data
}

export const removerQuestaoDissertativa = async (idProva, idQuestao) => {
  const response = await Axios.delete(`${baseUrl}/prova/${idProva}/excluir-dissertativa/${idQuestao}`)
  return response.data
}

export const removerQuestaoTecnica = async (idProva, idQuestao) => {
  const response = await Axios.delete(`${baseUrl}/prova/${idProva}/excluir-tecnica/${idQuestao}`)
  return response.data
}

export const removerQuestaoMultiplaEscolha = async (idProva, idQuestao) => {
  const response = await Axios.delete(`${baseUrl}/prova/${idProva}/excluir-multipla-escolha/${idQuestao}`)
  return response.data
}

export const iniciarProva = async (idProva) => {
  const response = await Axios.put(`${baseUrl}/prova/${idProva}/iniciar-prova`)
  return response.data
}

export const enviarRespostasDaProva = async (idProva, respostas) => {
  const response = await Axios.put(`${baseUrl}/prova/${idProva}/finalizar-prova`, respostas)
  return response.data
}

export const retornaProvasParaCorrecao = async (paginaAtual) => {
  const response = await Axios.get(`${baseUrl}/prova/para-correcao?page=${paginaAtual}`)
  return [response.data.content, response.data.totalPages, response.data.numberOfElements, response.data.pageable.pageNumber]
}

export const retornaProvasCorrigidas = async (paginaAtual) => {
  const response = await Axios.get(`${baseUrl}/prova/provas-corrigidas?page=${paginaAtual}`)
  return [response.data.content, response.data.totalPages, response.data.numberOfElements, response.data.pageable.pageNumber]
}

export const corrigirProva = async (idProva, body) => {
  const response = await Axios.put(`${baseUrl}/prova/${idProva}-corrigir`, body)
  return response.data
}

export const retornarProvaComRespostas = async (idProva) => {
  const response = await Axios.get(`${baseUrl}/prova/${idProva}-respostas`)
  return response.data
}