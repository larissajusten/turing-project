/* Login */
export { login } from './login/login.service'
export { retornaPerfil } from './login/login.service'

/* Dominio Service */
export { retornarEspecificidades } from './dominio/dominio.service'
export { retornarNiveisDeDificuldade } from './dominio/dominio.service'
export { retornarTipoDeQuestao } from './dominio/dominio.service'

/* Questão Multipla Escolha Service*/
export { adicionarQuestaoMultiplaEscolha } from './questoes/questao-multipla-escolha.service'
export { retornarQuestoesMultiplasEscolhasFiltradas } from './questoes/questao-multipla-escolha.service'

/* Questão Tecnica Service*/
export { adicionarQuestaoTecnica } from './questoes/questao-tecnica.service'
export { retornarQuestoesTecnicasFiltradas } from './questoes/questao-tecnica.service'

/* Questão Dissertativa Service*/
export { adicionarQuestaoDissertativa } from './questoes/questao-dissertativa.service'
export { retornarQuestoesDissertativasFiltradas } from './questoes/questao-dissertativa.service'

/* Prova */
export { criarProva } from './prova/prova.service'
export { iniciarProva } from './prova/prova.service'
export { enviarRespostasDaProva } from './prova/prova.service'
export { corrigirProva } from './prova/prova.service'

/* Prova */ //buscar prova
export { retornaProva } from './prova/bucarProva.service'
export { retornaProvaPorToken } from './prova/bucarProva.service'
export { retornaProvasParaCorrecao } from './prova/bucarProva.service'
export { retornarProvaParaCorrigir } from './prova/bucarProva.service'
export { retornaProvasCorrigidas } from './prova/bucarProva.service'
export { retornaProvaCorrigidaParaPDF } from './prova/bucarProva.service'

/* Prova */ //incluir questão
export { incluirDissertativas } from './prova/incluirQuestoesProva.service'
export { incluirTecnicas } from './prova/incluirQuestoesProva.service'
export { incluirMultiplaEscolha } from './prova/incluirQuestoesProva.service'

/* Prova */ //excluir questão
export { removerQuestaoDissertativa } from './prova/excluirQuestaoProva.service'
export { removerQuestaoTecnica } from './prova/excluirQuestaoProva.service'
export { removerQuestaoMultiplaEscolha } from './prova/excluirQuestaoProva.service'
