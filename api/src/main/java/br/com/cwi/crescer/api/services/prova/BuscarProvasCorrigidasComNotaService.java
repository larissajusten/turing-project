package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaCorrigidaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarProvasCorrigidasComNotaService {

    @Autowired
    private ProvaRepository provaRepository;

    @Autowired
    private RetornarQuestaoTecnicaComRespostaResponseService retornarQuestaoTecnicaComRespostaResponseService;

    @Autowired
    private RetornarQuestaoDissertativaComRespostaResponseService retornarQuestaoDissertativaComRespostaResponseService;

    @Autowired
    private RetornarQuestaoMultiplaEscolhaComRespostaResponseService retornarQuestaoMultiplaEscolhaComRespostaResponseService;

    public Page<ProvaCorrigidaResponse> buscar(Pageable pageable) {

        Page<Prova> provas = provaRepository.findAllByStatusEquals(pageable, StatusProva.CORRIGIDA);

        Page<ProvaCorrigidaResponse> provaCorrigidaResponse = provas.map(prova -> {

            List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = retornarQuestaoTecnicaComRespostaResponseService.buscar(prova);
            List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = retornarQuestaoDissertativaComRespostaResponseService.buscar(prova);
            List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova);

            ProvaCorrigidaResponse provaResponse = new ProvaCorrigidaResponse();
            provaResponse.setId(prova.getId());
            provaResponse.setNomeCandidato(prova.getNomeCandidato());
            provaResponse.setNota(prova.getNota());
            provaResponse.setQuestoesMultiplaEscolha(questaoMultiplaEscolha);
            provaResponse.setQuestoesDissertativas(questaoDissertativa);
            provaResponse.setQuestoesTecnicas(questoesTecnicas);

            return provaResponse;
        });

        return provaCorrigidaResponse;
    }
}
