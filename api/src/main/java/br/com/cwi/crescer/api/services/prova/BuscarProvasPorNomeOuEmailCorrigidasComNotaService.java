package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.*;
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
    private BuscarProvaPorIdCorrigidaService buscarProvaPorIdCorrigidaService;

    @Autowired
    private ProvasVaziaValidador validator;

    public List<ProvaCorrigidaResponse> buscar(String nomeOuEmail) {

        List<Prova> provas = repository.findByEmailCandidatoContainingOrNomeCandidatoContainingAndStatusEquals(nomeOuEmail,
                nomeOuEmail, StatusProva.CORRIGIDA);
        List<ProvaCorrigidaResponse> listaDasProvas = new ArrayList<>();

        validator.validar(provas);

        provas.forEach(prova -> {
            ProvaCorrigidaResponse provaResponse = buscarProvaPorIdCorrigidaService.buscar(prova.getId());
            listaDasProvas.add(provaResponse);
        });

        return listaDasProvas;
    }
}
