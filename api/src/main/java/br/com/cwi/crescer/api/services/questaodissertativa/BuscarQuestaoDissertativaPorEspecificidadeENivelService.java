package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarQuestaoDissertativaPorEspecificidadeENivelService {
    @Autowired
    private QuestaoDissertativaRepository repository;

    public List<QuestaoDissertativa> buscarListado(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade) {
        return repository.acharPorNivelEEspecificidadeLista(especificidade, nivelDeDificuldade);
    }
}
