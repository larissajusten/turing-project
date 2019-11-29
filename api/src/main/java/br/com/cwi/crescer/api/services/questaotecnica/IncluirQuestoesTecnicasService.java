package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoTecnica;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoTecnicaRepository;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncluirQuestoesTecnicasService {

    @Autowired
    private ListarQuestoesTecnicasFiltradasService listarQuestoesTecnicasFiltradasService;

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorId;

    @Autowired
    private ProvaQuestaoTecnicaRepository repository;

    @Autowired
    private AcrescentarQuantasVezesUsadaQuestaoTecnicaService acrescentarQuantasVezesUsadaQuestaoTecnicaService;

    public void incluir(Long idProva, BuscaQuestoesRequest request) {

        Prova prova = buscarProvaPorId.buscar(idProva);
        List<QuestaoTecnica> lista = listarQuestoesTecnicasFiltradasService.listar(request);
        acrescentarQuantasVezesUsadaQuestaoTecnicaService.acrescentar(lista);

        for (QuestaoTecnica questaoTecnica : lista) {
            ProvaQuestaoTecnica provaQuestaoTecnica = new ProvaQuestaoTecnica();
            provaQuestaoTecnica.setProva(prova);
            provaQuestaoTecnica.setQuestao(questaoTecnica);
            repository.save(provaQuestaoTecnica);
        }
    }
}
