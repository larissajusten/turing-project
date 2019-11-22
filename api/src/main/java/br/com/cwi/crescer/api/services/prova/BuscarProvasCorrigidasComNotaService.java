package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaCorrigidaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.exception.ValidacaoDeAplicacaoException;
import br.com.cwi.crescer.api.exception.prova.ProvaNaoEncontradaException;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarProvasCorrigidasComNotaService {

    @Autowired
    private ProvaRepository repository;

    @Autowired
    private RetornarQuestaoTecnicaComRespostaResponseService retornarQuestaoTecnicaComRespostaResponseService;

    @Autowired
    private RetornarQuestaoDissertativaComRespostaResponseService retornarQuestaoDissertativaComRespostaResponseService;

    @Autowired
    private RetornarQuestaoMultiplaEscolhaComRespostaResponseService retornarQuestaoMultiplaEscolhaComRespostaResponseService;

    public List<ProvaCorrigidaResponse> buscar(String nomeOuEmail) {

        List<Prova> provas = repository.findPorNomeUsuarioCorrigida(nomeOuEmail, StatusProva.CORRIGIDA);
        List<ProvaCorrigidaResponse> listaDasProvas = new ArrayList<>();

        if(provas.isEmpty()) {
            throw new ProvaNaoEncontradaException("Nenhuma prova corrigida foi encontrada");
        }

        provas.forEach(prova -> {
            List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = retornarQuestaoTecnicaComRespostaResponseService.buscar(prova);
            List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = retornarQuestaoDissertativaComRespostaResponseService.buscar(prova);
            List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova);

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

            provaResponse.setQuestoesMultiplaEscolha(questaoMultiplaEscolha);
            provaResponse.setQuestoesDissertativas(questaoDissertativa);
            provaResponse.setQuestoesTecnicas(questoesTecnicas);

            listaDasProvas.add(provaResponse);
        });

        return listaDasProvas;
    }
}
