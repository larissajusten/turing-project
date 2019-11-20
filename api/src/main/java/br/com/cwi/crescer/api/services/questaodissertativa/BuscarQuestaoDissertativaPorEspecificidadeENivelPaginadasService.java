package br.com.cwi.crescer.api.services.questaodissertativa;


import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarQuestaoDissertativaPorEspecificidadeENivelPaginadasService {

    @Autowired
    private QuestaoDissertativaRepository repository;


    public Page<QuestaoDissertativa> buscar(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade, Pageable pageable) {

        return repository.acharPorNivelEEspecificidadePaginado(pageable, especificidade, nivelDeDificuldade);

    }
}
