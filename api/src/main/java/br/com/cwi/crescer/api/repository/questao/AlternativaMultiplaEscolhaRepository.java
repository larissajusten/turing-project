package br.com.cwi.crescer.api.repository.questao;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlternativaMultiplaEscolhaRepository extends JpaRepository<AlternativaMultiplaEscolha, Long> {

    List<AlternativaMultiplaEscolha> findAllByQuestaoMultiplaEscolhaIdEquals(Long id);
}
