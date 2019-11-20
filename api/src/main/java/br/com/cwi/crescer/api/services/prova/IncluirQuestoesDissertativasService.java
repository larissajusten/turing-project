package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoDissertativa;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import br.com.cwi.crescer.api.services.questaodissertativa.AcrescentarQuantiaDeVezesUsadaQuestaoDissertativaService;
import br.com.cwi.crescer.api.services.questaodissertativa.ListarQuestoesDissertativasFiltradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    private AcrescentarQuantiaDeVezesUsadaQuestaoDissertativaService acrescentarUmaVezEmVezesUsada;

    public void incluir(Long idProva, BuscaQuestoesRequest request) {
        List<QuestaoDissertativa> lista = listarQuestoesDissertativasFiltradas.listar(request);

        acrescentarUmaVezEmVezesUsada.addVezesQuestaoDissertativa(lista);
        Prova prova = buscarProvaPorId.buscar(idProva);

        for (QuestaoDissertativa questaoDissertativa : lista) {
            ProvaQuestaoDissertativa provaQuestaoDissertativa = new ProvaQuestaoDissertativa();
            provaQuestaoDissertativa.setProva(prova);
            provaQuestaoDissertativa.setQuestao(questaoDissertativa);
            repository.save(provaQuestaoDissertativa);
        }

    }
}
