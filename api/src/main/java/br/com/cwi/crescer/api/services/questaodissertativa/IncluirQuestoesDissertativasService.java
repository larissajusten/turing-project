package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoDissertativa;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdService;
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

    @Autowired
    private AcrescentarQuantasVezesUsadaQuestaoDissertativaService acrescentarUmaVezEmVezesUsada;

    public List<QuestaoDissertativa> incluir(Long idProva, BuscaQuestoesRequest request) {
        List<QuestaoDissertativa> lista = listarQuestoesDissertativasFiltradas.listar(request);

        acrescentarUmaVezEmVezesUsada.acrescentar(lista);
        Prova prova = buscarProvaPorId.buscar(idProva);

        for (QuestaoDissertativa questaoDissertativa : lista) {
            ProvaQuestaoDissertativa provaQuestaoDissertativa = new ProvaQuestaoDissertativa();
            provaQuestaoDissertativa.setProva(prova);
            provaQuestaoDissertativa.setQuestao(questaoDissertativa);
            repository.save(provaQuestaoDissertativa);
        }

        return lista;
    }

}
