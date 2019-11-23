package br.com.cwi.crescer.api.repository.prova;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProvaRepository extends JpaRepository<Prova, Long> {

    List<Prova> findByEmailCandidatoContainingOrNomeCandidatoContainingAndStatusEquals(String email, String nome, StatusProva statusProva);

    boolean existsByEmailCandidatoEqualsAndStatusEquals(String email, StatusProva ativa);

    Page<Prova> findAllByStatusEquals(Pageable pageable, StatusProva status);

    Optional<Prova> findByEmailCandidatoEqualsAndStatusEquals(String email, StatusProva status);

    Page<Prova> findAllByOrderByNotaDesc(Pageable pageable);

}

