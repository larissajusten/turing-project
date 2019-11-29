package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaCorrigidaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.services.respostaprova.RetornarQuestaoDissertativaComRespostaResponseService;
import br.com.cwi.crescer.api.services.respostaprova.RetornarQuestaoMultiplaEscolhaComRespostaResponseService;
import br.com.cwi.crescer.api.services.respostaprova.RetornarQuestaoTecnicaComRespostaResponseService;
import br.com.cwi.crescer.api.validator.ProvasVaziaValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarProvaPorIdCorrigidaService {

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @Autowired
    private RetornarQuestaoTecnicaComRespostaResponseService retornarQuestaoTecnicaComRespostaResponseService;

    @Autowired
    private RetornarQuestaoDissertativaComRespostaResponseService retornarQuestaoDissertativaComRespostaResponseService;

    @Autowired
    private RetornarQuestaoMultiplaEscolhaComRespostaResponseService retornarQuestaoMultiplaEscolhaComRespostaResponseService;

    @Autowired
    private RetornarListaDeEspecifidadesDeUmaProvaService retornarListaDeEspecifidadesDeUmaProvaService;

    @Autowired
    private ProvasVaziaValidador validator;

    public ProvaCorrigidaResponse buscar(Long idProva) {

        ProvaCorrigidaResponse provaCorrigidaResponse = new ProvaCorrigidaResponse();
        Prova prova = buscarProvaPorIdService.buscar(idProva);

        List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = retornarQuestaoTecnicaComRespostaResponseService.buscar(prova);
        List<QuestaoDissertativaComRespostaResponse> questoesDissertativas = retornarQuestaoDissertativaComRespostaResponseService.buscar(prova);
        List<QuestaoMultiplaEscolhaComRespostaResponse> questoesMultiplaEscolhas = retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova);
        List<Especificidade> especificidades = retornarListaDeEspecifidadesDeUmaProvaService.retornar(questoesTecnicas, questoesDissertativas, questoesMultiplaEscolhas);

        int totalDeQuestoes = questoesTecnicas.size() + questoesDissertativas.size() + questoesMultiplaEscolhas.size();

        provaCorrigidaResponse.setId(prova.getId());

        provaCorrigidaResponse.setStatusProva(prova.getStatus());
        provaCorrigidaResponse.setNota(prova.getNota());

        provaCorrigidaResponse.setEmailCandidato(prova.getEmailCandidato());
        provaCorrigidaResponse.setNomeCandidato(prova.getNomeCandidato());

        provaCorrigidaResponse.setDataInicio(prova.getDataInicio());
        provaCorrigidaResponse.setDataCriacao(prova.getDataCriacao());
        provaCorrigidaResponse.setTempoDeDuracaoDaProva(prova.getTempoDeDuracaoDaProva());
        provaCorrigidaResponse.setTempoParaInicioProva(prova.getTempoParaInicioProva());

        provaCorrigidaResponse.setQuestoesMultiplaEscolha(questoesMultiplaEscolhas);
        provaCorrigidaResponse.setQuestoesDissertativas(questoesDissertativas);
        provaCorrigidaResponse.setQuestoesTecnicas(questoesTecnicas);

        provaCorrigidaResponse.setEspecificidades(especificidades);
        provaCorrigidaResponse.setNumeroDeQuestoes(totalDeQuestoes);

        return provaCorrigidaResponse;
    }
}


