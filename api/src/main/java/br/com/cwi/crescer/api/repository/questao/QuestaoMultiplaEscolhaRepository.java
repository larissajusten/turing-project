package br.com.cwi.crescer.api.repository.questao;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestaoMultiplaEscolhaRepository extends JpaRepository<QuestaoMultiplaEscolha, Long> {

    Page<QuestaoMultiplaEscolha> findAll(Pageable pageable);

    List<QuestaoMultiplaEscolha> findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaDesc(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade, Pageable page);

}
