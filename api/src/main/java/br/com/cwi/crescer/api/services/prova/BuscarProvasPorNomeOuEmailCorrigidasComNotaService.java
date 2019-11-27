package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaCorrigidaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import br.com.cwi.crescer.api.services.respostaprova.RetornarQuestaoDissertativaComRespostaResponseService;
import br.com.cwi.crescer.api.services.respostaprova.RetornarQuestaoMultiplaEscolhaComRespostaResponseService;
import br.com.cwi.crescer.api.services.respostaprova.RetornarQuestaoTecnicaComRespostaResponseService;
import br.com.cwi.crescer.api.validator.ProvasVaziaValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarProvasPorNomeOuEmailCorrigidasComNotaService {

    @Autowired
    private ProvaRepository repository;

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

    public List<ProvaCorrigidaResponse> buscar(String nomeOuEmail) {

        List<Prova> provas = repository.findByEmailCandidatoContainingOrNomeCandidatoContainingAndStatusEquals(nomeOuEmail, nomeOuEmail, StatusProva.CORRIGIDA);
        List<ProvaCorrigidaResponse> listaDasProvas = new ArrayList<>();

        validator.validar(provas);

        provas.forEach(prova -> {
            List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = retornarQuestaoTecnicaComRespostaResponseService.buscar(prova);
            List<QuestaoDissertativaComRespostaResponse> questoesDissertativas = retornarQuestaoDissertativaComRespostaResponseService.buscar(prova);
            List<QuestaoMultiplaEscolhaComRespostaResponse> questoesMultiplaEscolhas = retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova);
            List<Especificidade> especificidades = retornarListaDeEspecifidadesDeUmaProvaService.retornar(questoesTecnicas, questoesDissertativas, questoesMultiplaEscolhas);

            int totalDeQuestoes = questoesTecnicas.size() + questoesDissertativas.size() + questoesMultiplaEscolhas.size();

            ProvaCorrigidaResponse provaResponse = new ProvaCorrigidaResponse();
            provaResponse.setId(prova.getId());
            provaResponse.setIdCriador(prova.getCriador().getId());

            provaResponse.setStatusProva(prova.getStatus());
            provaResponse.setNota(prova.getNota());

            provaResponse.setEmailCandidato(prova.getEmailCandidato());
            provaResponse.setNomeCandidato(prova.getNomeCandidato());

            provaResponse.setDataInicio(prova.getDataInicio());
            provaResponse.setDataCriacao(prova.getDataCriacao());
            provaResponse.setTempoDeDuracaoDaProva(prova.getTempoDeDuracaoDaProva());
            provaResponse.setTempoParaInicioProva(prova.getTempoParaInicioProva());

            provaResponse.setQuestoesMultiplaEscolha(questoesMultiplaEscolhas);
            provaResponse.setQuestoesDissertativas(questoesDissertativas);
            provaResponse.setQuestoesTecnicas(questoesTecnicas);

            provaResponse.setNumeroDeQuestoes(totalDeQuestoes);
            provaResponse.setEspecificidades(especificidades);

            listaDasProvas.add(provaResponse);
        });

        return listaDasProvas;
    }

}
