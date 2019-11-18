package br.com.cwi.crescer.api.repository.prova;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvaRepository extends JpaRepository<Prova, Long> {

    Prova findAllByCriadorIdEquals(Long id);

    boolean existsByEmailEqualsAndStatusEquals(String email, StatusProva ativa);
}

