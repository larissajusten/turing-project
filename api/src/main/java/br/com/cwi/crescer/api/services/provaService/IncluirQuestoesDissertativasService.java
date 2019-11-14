package br.com.cwi.crescer.api.services.provaService;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questaoProva.ProvaQuestaoDissertativa;
import br.com.cwi.crescer.api.repository.ProvaQuestaoDissertativaRepository;
import br.com.cwi.crescer.api.services.questaoDissertativaService.BuscarQuestaoDissertativaPorEspecificidadeENivelService;
import br.com.cwi.crescer.api.services.questaoDissertativaService.ListarQuestoesDissertativasFiltradas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncluirQuestoesDissertativasService {

    @Autowired
    private ListarQuestoesDissertativasFiltradas listarQuestoesDissertativasFiltradas;

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorId;

    @Autowired
    private ProvaQuestaoDissertativaRepository repository;

    public ProvaQuestaoDissertativa incluir( Long idProva, BuscaQuestoesRequest request){
        List<QuestaoDissertativa> lista = listarQuestoesDissertativasFiltradas.listar(request);
        Prova prova = buscarProvaPorId.buscar(idProva);

        ProvaQuestaoDissertativa provaQuestaoDissertativa = new ProvaQuestaoDissertativa();
        provaQuestaoDissertativa.setProva(prova);

        lista.forEach(
                provaQuestaoDissertativa::setQuestao
        );

        return repository.save(provaQuestaoDissertativa);
    }
}
