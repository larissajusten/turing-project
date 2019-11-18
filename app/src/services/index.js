/* Dominio Service */
export { retornarEspecificidades } from './dominio/dominio.service'
export { retornarNiveisDeDificuldade } from './dominio/dominio.service'

/* Questão Multipla Escolha Service*/
export { adicionarQuestaoMultiplaEscolha } from './questoes/questao-multipla-escolha.service'
export { retornarQuestoesMultiplasEscolhasFiltradas } from './questoes/questao-multipla-escolha.service'

/* Questão Tecnica Service*/
export { adicionarQuestaoTecnica } from './questoes/questao-tecnica.service'
export { retornarQuestoesTecnicasFiltradas } from './questoes/questao-tecnica.service'
export { retornarQuestoesTecnicasRandomicasFiltradas } from './questoes/questao-tecnica.service'

/* Questão Dissertativa Service*/
export { adicionarQuestaoDissertativa } from './questoes/questao-dissertativa.service'
export { retornarQuestoesDissertativasFiltradas } from './questoes/questao-dissertativa.service'

/* Prova */
export { adicionarProva } from './prova/prova.service'
export { retornaProva } from './prova/prova.service'

/* Prova */ //incluir questão
export { incluirDissertativas } from './prova/prova.service'
export { incluirTecnicas } from './prova/prova.service'
export { incluirMultiplaEscolha } from './prova/prova.service'

/* Prova */ //excluir questão
export { removerQuestaoDissertativa } from './prova/prova.service'
export { removerQuestaoTecnica } from './prova/prova.service'
export { removerQuestaoMultiplaEscolha } from './prova/prova.service'
