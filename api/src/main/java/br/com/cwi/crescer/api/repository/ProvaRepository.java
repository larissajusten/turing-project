package br.com.cwi.crescer.api.repository;

import br.com.cwi.crescer.api.domain.prova.Prova;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvaRepository extends JpaRepository<Prova, Long> {
}
