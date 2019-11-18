package br.com.cwi.crescer.api.repository.prova;

import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoMultiplaEscolha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvaQuestaoMultiplaEscolhaRepository extends JpaRepository<ProvaQuestaoMultiplaEscolha, Long> {

    List<ProvaQuestaoMultiplaEscolha> findAllByProvaIdEquals(Long id);

    void deleteByQuestaoIdAndProvaId(Long idQuestao, Long idPRova);
}
