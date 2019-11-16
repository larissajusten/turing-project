package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarProvaComQuestoesService {


    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @Autowired
    private BuscarQuestoesTecnicasDeUmaProvaPorIdService buscarQuestoesTecnicasDeUmaProvaPorIdService;

    @Autowired
    private BuscarQuestoesDissertativasDeUmaProvaPorIdService buscarQuestoesDissertativasDeUmaProvaPorIdService;

    @Autowired
    private BuscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService;

    public ProvaResponse buscar(Long idProva) {

        Prova prova = buscarProvaPorIdService.buscar(idProva);

        ProvaResponse provaResponse = new ProvaResponse();

        provaResponse.setId(prova.getId());
        provaResponse.setDataCriacao(prova.getDataCriacao());
        provaResponse.setIdCriador(prova.getCriador().getId());
        provaResponse.setStatus(prova.getStatus());
        provaResponse.setTempoDeDuracaoDaProva(prova.getTempoDeDuracaoDaProva());
        provaResponse.setTempoParaInicioProva(prova.getTempoParaInicioProva());
        provaResponse.setQuestoesTecnicas(buscarQuestoesTecnicasDeUmaProvaPorIdService.buscar(idProva));
        provaResponse.setQuestoesDissertativas(buscarQuestoesDissertativasDeUmaProvaPorIdService.buscar(idProva));
        provaResponse.setQuestoesDeMultiplaEscolha(buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService.buscar(idProva));

        return provaResponse;
    }

}
