package br.com.cwi.crescer.api.repository.questao;

import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestaoMultiplaEscolhaRepository extends JpaRepository<QuestaoMultiplaEscolha, Long> {

    Page<QuestaoMultiplaEscolha> findAll(Pageable pageable);
}
