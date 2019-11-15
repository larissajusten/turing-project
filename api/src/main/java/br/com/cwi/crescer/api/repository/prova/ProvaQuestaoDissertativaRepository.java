package br.com.cwi.crescer.api.repository.prova;

import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoDissertativa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvaQuestaoDissertativaRepository extends JpaRepository<ProvaQuestaoDissertativa, Long> {
    List<ProvaQuestaoDissertativa> findAllByProvaIdEquals(Long id);
}
