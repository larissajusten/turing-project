package br.com.cwi.crescer.api.services.provaService;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questaoProva.ProvaQuestaoDissertativa;
import br.com.cwi.crescer.api.repository.ProvaQuestaoDissertativaRepository;
import br.com.cwi.crescer.api.services.questaoDissertativaService.ListarQuestoesDissertativasFiltradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncluirQuestoesDissertativasService {

    @Autowired
    private ListarQuestoesDissertativasFiltradasService listarQuestoesDissertativasFiltradas;

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorId;

    @Autowired
    private ProvaQuestaoDissertativaRepository repository;

    public void incluir( Long idProva, BuscaQuestoesRequest request) {
        List<QuestaoDissertativa> lista = listarQuestoesDissertativasFiltradas.listar(request);
        Prova prova = buscarProvaPorId.buscar(idProva);

        for (QuestaoDissertativa questaoDissertativa : lista) {
            ProvaQuestaoDissertativa provaQuestaoDissertativa = new ProvaQuestaoDissertativa();
            provaQuestaoDissertativa.setProva(prova);
            provaQuestaoDissertativa.setQuestao(questaoDissertativa);
            repository.save(provaQuestaoDissertativa);
        }

    }
}
