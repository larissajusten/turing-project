package br.com.cwi.crescer.api.mapper;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRequest;
import br.com.cwi.crescer.api.controller.responses.ProvaParaCorrecaoResponse;
import br.com.cwi.crescer.api.controller.responses.ProvaResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdComQuestoesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProvaMapper {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BuscarProvaPorIdComQuestoesService buscarProvaPorIdComQuestoesService;

    public Prova transformar(ProvaRequest request) {

        Prova prova = mapper.map(request, Prova.class);
        prova.setDataCriacao(LocalDateTime.now());
        prova.setEmailCandidato(request.getEmail());
        prova.setStatus(StatusProva.ATIVA);

        return prova;
    }

    public ProvaParaCorrecaoResponse paraCorrigir(Prova prova) {

        List<Especificidade> especificidades = new ArrayList<>();

        ProvaResponse provaResponse = buscarProvaPorIdComQuestoesService.buscar(prova.getId());

        ProvaParaCorrecaoResponse provaParaCorrecaoResponse = new ProvaParaCorrecaoResponse();
        provaParaCorrecaoResponse.setDataCriacao(prova.getDataCriacao());
        provaParaCorrecaoResponse.setEmailCandidato(prova.getEmailCandidato());
        provaParaCorrecaoResponse.setId(prova.getId());
        provaParaCorrecaoResponse.setNomeCandidato(prova.getNomeCandidato());
        provaParaCorrecaoResponse.setTempoDeDuracaoDaProva(prova.getTempoDeDuracaoDaProva());

        provaResponse.getQuestoesDeMultiplaEscolha().forEach(q -> {
            if (!especificidades.contains(q.getEspecificidade())) {
                especificidades.add(q.getEspecificidade());
            }
        });
        provaResponse.getQuestoesDissertativas().forEach(q -> {
            if (!especificidades.contains(q.getEspecificidade())) {
                especificidades.add(q.getEspecificidade());
            }
        });
        provaResponse.getQuestoesTecnicas().forEach(q -> {
            if (!especificidades.contains(q.getEspecificidade())) {
                especificidades.add(q.getEspecificidade());
            }
        });
        provaParaCorrecaoResponse.setEspecificidades(especificidades);
        provaParaCorrecaoResponse.setNumeroQuestoes(provaResponse.getQuestoesDeMultiplaEscolha().size() +
                provaResponse.getQuestoesTecnicas().size() +
                provaResponse.getQuestoesDissertativas().size()
        );
        return provaParaCorrecaoResponse;
    }
}
