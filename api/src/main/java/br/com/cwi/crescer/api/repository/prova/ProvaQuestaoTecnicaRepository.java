package br.com.cwi.crescer.api.repository.prova;

import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoTecnica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvaQuestaoTecnicaRepository extends JpaRepository<ProvaQuestaoTecnica, Long> {
    List<ProvaQuestaoTecnica> findAllByProvaIdEquals(Long id);
}
