package br.com.cwi.crescer.api.repository.prova;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProvaRepository extends JpaRepository<Prova, Long> {

    @Query("SELECT p from Prova p WHERE p.status = :status AND " +
            "(p.emailCandidato LIKE %:email% OR p.nomeCandidato LIKE %:nome%)")
    List<Prova> acharPorNomeOuEmail(@Param("email") String email,
                                                                                       @Param("nome") String nome,
                                                                                       @Param("status") StatusProva status);

    boolean existsByEmailCandidatoEqualsAndStatusEquals(String email, StatusProva ativa);

    Page<Prova> findAllByStatusEquals(Pageable pageable, StatusProva status);

    Optional<Prova> findByEmailCandidatoEqualsAndStatusEquals(String email, StatusProva status);

    Page<Prova> findAllByOrderByNotaDesc(Pageable pageable);

}

