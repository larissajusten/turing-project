package br.com.cwi.crescer.api.repository.prova;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProvaRepository extends JpaRepository<Prova, Long> {

    Prova findAllByCriadorIdEquals(Long id);

    List<Prova> findByEmailCandidatoContainingOrNomeCandidatoContainingAndStatusEquals(String email, String nome, StatusProva statusProva);

    boolean existsByEmailCandidatoEqualsAndStatusEquals(String email, StatusProva ativa);

    Page<Prova> findAllByStatusEquals(Pageable pageable, StatusProva status);

    Prova findByEmailCandidatoEqualsAndStatusEquals(String email, StatusProva status);

}

