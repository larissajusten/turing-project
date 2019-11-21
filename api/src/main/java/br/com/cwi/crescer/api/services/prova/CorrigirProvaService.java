package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.requests.questoes.CorrecaoProvaRequest;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.enums.TipoDeQuestao;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import br.com.cwi.crescer.api.services.respostaprova.CorrigirQuestaoDissertativaService;
import br.com.cwi.crescer.api.services.respostaprova.CorrigirQuestaoTecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorrigirProvaService {

    @Autowired
    private BuscarProvaPorIdService buscarProvaPorIdService;

    @Autowired
    private CorrigirQuestaoDissertativaService corrigirQuestaoDissertativaService;

    @Autowired
    private CorrigirQuestaoTecnicaService corrigirQuestaoTecnicaService;

    @Autowired
    private ProvaRepository repository;


    public StatusProva corrigir(Long idProva,
                                List<CorrecaoProvaRequest> listaDeCorrecoes){
        Prova prova = buscarProvaPorIdService.buscar(idProva);

        for (CorrecaoProvaRequest request : listaDeCorrecoes) {
            if(request.getTipoDeQuestao() == TipoDeQuestao.DISSERTATIVA){
                corrigirQuestaoDissertativaService.corrigir(request.getIdResposta(), request);
            } else if (request.getTipoDeQuestao() == TipoDeQuestao.TECNICA){
                corrigirQuestaoTecnicaService.corrigir(request.getIdResposta(), request);
            }
        }

        prova.setStatus(StatusProva.CORRIGIDA);
        repository.save(prova);

        return prova.getStatus();
    }
}
