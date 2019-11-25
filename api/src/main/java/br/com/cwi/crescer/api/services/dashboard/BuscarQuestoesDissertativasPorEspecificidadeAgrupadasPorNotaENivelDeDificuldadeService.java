package br.com.cwi.crescer.api.services.dashboard;

import br.com.cwi.crescer.api.controller.responses.RespostaParaDashboardResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarQuestoesDissertativasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService {

    @Autowired
    private RespostasDissertativaRepository repository;


    public List<RespostaParaDashboardResponse> buscar(Especificidade especificidade) {

        return repository.findAllByGroupByNotaWhereQuestaoDissertativaEspecificidadeEquals(especificidade);
    }


}
