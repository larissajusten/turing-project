package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.services.provaquestao.BuscarQuestoesDissertativasDeUmaProvaPorIdService;
import br.com.cwi.crescer.api.services.provaquestao.BuscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService;
import br.com.cwi.crescer.api.services.provaquestao.BuscarQuestoesTecnicasDeUmaProvaPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarProvaPorIdComQuestoesService {

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @Autowired
    private BuscarQuestoesTecnicasDeUmaProvaPorIdService buscarQuestoesTecnicasDeUmaProvaPorIdService;

    @Autowired
    private BuscarQuestoesDissertativasDeUmaProvaPorIdService buscarQuestoesDissertativasDeUmaProvaPorIdService;

    @Autowired
    private BuscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService;

    @Autowired
    private VerificarSeProvaEstaDentroDoPrazoParaIniciarService verificarSeProvaEstaDentroDoPrazoParaIniciarService;

    public ProvaResponse buscar(Long idProva) {

        ProvaResponse provaResponse = new ProvaResponse();
        Prova prova = buscarProvaPorIdService.buscar(idProva);
        provaResponse.setPodeIniciar(verificarSeProvaEstaDentroDoPrazoParaIniciarService.verificar(prova));

        provaResponse.setId(prova.getId());
        provaResponse.setEmailCandidato(prova.getEmailCandidato());
        provaResponse.setNomeCandidato(prova.getNomeCandidato());
        provaResponse.setDataCriacao(prova.getDataCriacao());

        provaResponse.setStatus(prova.getStatus());

        provaResponse.setTempoDeDuracaoDaProva(prova.getTempoDeDuracaoDaProva());
        provaResponse.setTempoParaInicioProva(prova.getTempoParaInicioProva());

        provaResponse.setQuestoesTecnicas(buscarQuestoesTecnicasDeUmaProvaPorIdService.buscar(idProva));
        provaResponse.setQuestoesDissertativas(buscarQuestoesDissertativasDeUmaProvaPorIdService.buscar(idProva));
        provaResponse.setQuestoesDeMultiplaEscolha(buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService.buscar(idProva));

        return provaResponse;
    }

}
