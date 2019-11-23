package br.com.cwi.crescer.api.repository.questao;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestaoTecnicaRepository extends JpaRepository<QuestaoTecnica, Long> {

    List<QuestaoTecnica> findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaAsc(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade, Pageable page);
    
    @Query("SELECT q FROM QuestaoTecnica q " +
            "WHERE q.especificidade = :especificidade " +
            "AND q.nivelDeDificuldade = :nivelDeDificuldade")
    Page<QuestaoTecnica> acharPorNivelEEspecificidadePaginado(Pageable pageable, @Param("especificidade")Especificidade especificidade,
                                                      @Param("nivelDeDificuldade")NivelDeDificuldade nivelDeDificuldade);

}

