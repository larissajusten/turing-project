package br.com.cwi.crescer.api.services.provaService;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.domain.questaoProva.ProvaQuestaoTecnica;
import br.com.cwi.crescer.api.repository.ProvaQuestaoTecnicaRepository;
import br.com.cwi.crescer.api.services.questaoTecnicaService.ListarQuestoesTecnicasFiltradasService;
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

    public void incluir(Long idProva, BuscaQuestoesRequest request){
        List<QuestaoTecnica> lista = listarQuestoesTecnicasFiltradasService.listar(request);
        Prova prova = buscarProvaPorId.buscar(idProva);


        for (QuestaoTecnica questaoTecnica : lista) {
            ProvaQuestaoTecnica provaQuestaoTecnica = new ProvaQuestaoTecnica();
            provaQuestaoTecnica.setProva(prova);
            provaQuestaoTecnica.setQuestao(questaoTecnica);
            repository.save(provaQuestaoTecnica);
        }

    }
}
