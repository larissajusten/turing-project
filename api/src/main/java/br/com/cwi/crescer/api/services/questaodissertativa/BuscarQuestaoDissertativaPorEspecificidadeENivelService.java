package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarQuestaoDissertativaPorEspecificidadeENivelService {
    @Autowired
    private QuestaoDissertativaRepository repository;

    public Page<QuestaoDissertativa> buscarPaginado(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade, Pageable pageable) {
        return repository.acharPorNivelEEspecificidadePaginado(especificidade, nivelDeDificuldade, pageable);
    }

    public List<QuestaoDissertativa> buscarListado(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade) {
        return repository.acharPorNivelEEspecificidadeLista(especificidade, nivelDeDificuldade);
    }
}
