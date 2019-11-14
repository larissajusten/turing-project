package br.com.cwi.crescer.api.repository;

import br.com.cwi.crescer.api.domain.questaoProva.ProvaQuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questaoProva.ProvaQuestaoTecnica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvaQuestaoTecnicaRepository extends JpaRepository<ProvaQuestaoTecnica, Long> {
}
