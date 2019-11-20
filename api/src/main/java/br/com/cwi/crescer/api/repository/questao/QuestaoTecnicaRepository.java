package br.com.cwi.crescer.api.repository.questao;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestaoTecnicaRepository extends JpaRepository<QuestaoTecnica, Long> {

    List<QuestaoTecnica> findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaDesc(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade, Pageable page);




}

