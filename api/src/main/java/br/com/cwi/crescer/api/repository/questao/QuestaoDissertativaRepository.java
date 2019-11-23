package br.com.cwi.crescer.api.repository.questao;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestaoDissertativaRepository extends JpaRepository<QuestaoDissertativa, Long> {

    List<QuestaoDissertativa> findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaAsc(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade, Pageable page);

    @Query("SELECT q FROM QuestaoDissertativa q WHERE q.especificidade = :especificidade" +
            " AND q.nivelDeDificuldade = :nivelDeDificuldade")
    Page<QuestaoDissertativa> acharPorNivelEEspecificidadePaginado(Pageable pageable, @Param("especificidade") Especificidade especificidade,
                                                                   @Param("nivelDeDificuldade") NivelDeDificuldade nivelDeDificuldade);

    @Query("SELECT " +
            "   q " +
            "FROM QuestaoDissertativa q " +
            "   WHERE q.especificidade = :especificidade" +
            "   AND q.nivelDeDificuldade = :nivelDeDificuldade")
    List<QuestaoDissertativa> acharPorNivelEEspecificidadeLista(@Param("especificidade") Especificidade especificidade,
                                                                @Param("nivelDeDificuldade") NivelDeDificuldade nivelDeDificuldade);


}
