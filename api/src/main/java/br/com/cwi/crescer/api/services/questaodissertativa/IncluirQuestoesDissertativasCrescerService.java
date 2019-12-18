package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoDissertativa;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorCriadaECrescerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncluirQuestoesDissertativasCrescerService {

    @Autowired
    private ListarQuestoesDissertativasFiltradasService listarQuestoesDissertativasFiltradas;

    @Autowired
    private BuscarProvaPorCriadaECrescerService buscarProvaPorCriadaECrescerService;

    @Autowired
    private ProvaQuestaoDissertativaRepository repository;

    @Autowired
    private AcrescentarQuantasVezesUsadaQuestaoDissertativaService acrescentarUmaVezEmVezesUsada;

    public List<QuestaoDissertativa> incluir(BuscaQuestoesRequest request) {
        List<QuestaoDissertativa> lista = listarQuestoesDissertativasFiltradas.listar(request);

        List<Prova> listaDeProvas = buscarProvaPorCriadaECrescerService.buscar();

        for (Prova prova : listaDeProvas) {
            for (QuestaoDissertativa questaoDissertativa : lista) {
                ProvaQuestaoDissertativa provaQuestaoDissertativa = new ProvaQuestaoDissertativa();
                provaQuestaoDissertativa.setProva(prova);
                acrescentarUmaVezEmVezesUsada.acrescentar(lista);
                provaQuestaoDissertativa.setQuestao(questaoDissertativa);
                repository.save(provaQuestaoDissertativa);
            }
        }

        return lista;
    }
}
