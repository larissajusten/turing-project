package br.com.cwi.crescer.api.repository.questao;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestaoDissertativaRepository extends JpaRepository<QuestaoDissertativa, Long> {

    @Query(value = "SELECT q.* FROM QUESTAO_DISSERTATIVA q WHERE q.especificidade = :especificidade AND q.nivel = :nivel ORDER BY q.vezes_usada ASC",
            nativeQuery = true)
    List<QuestaoDissertativa> acharPorNivelEEspecificidade(@Param("especificidade") Especificidade especificidade,
                                                      @Param("nivel") NivelDeDificuldade nivel);

    List<QuestaoDissertativa> findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaDesc(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade, Pageable page);



}
